package com.lym.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.*;
import com.lym.system.mapper.AdminMapper;
import com.lym.auth.security.JwtTokenUtil;
import com.lym.system.mapper.Admin_RoleMapper;
import com.lym.system.mapper.RoleMapper;
import com.lym.system.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lym.util.AdminUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lym
 * @since 2021-10-06
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private Admin_RoleMapper admin_roleMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public RespBean UserLogin(String username,String password,String code,HttpServletRequest request) {
        String captcha = (String) request.getSession().getAttribute("captcha");
        if (StringUtils.isEmpty(code)||!captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码错误，请重新输入!");
        }
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(username);
        if (null == userDetails || !passwordEncoder.matches(password,
                userDetails.getPassword())) {
            return RespBean.error("用户名或密码不正确!");
        }
        if (!userDetails.isEnabled()){
            return RespBean.error("账号被禁用，请联系管理员!");
        }
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null,
                        userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return RespBean.success("登录成功", tokenMap);
    }
    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    @Override
    public Admin getAdminByUserName(String username) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username",username));
//        List<Admin> adminByPage = adminMapper.getInfo(username);
//        return  adminByPage;
    }

    /*
      跟据用户查询角色列表
       */
    @Override
    public List<Role> getRoles(Integer adminId) {
        return roleMapper.getRoles(adminId);

    }
    /*
跟据用户查询员工信息
 */
    @Override
    public List<Employee> getEmployee(String CardId) {
        return roleMapper.getEmployee(CardId);

    }

    @Override
    public List<Admin> getlist() {
        return adminMapper.getList();
    }
/*
分页获得所有用户信息
 */
    @Override
    public RespPageBean getAdminByPage(Integer currentPage, Integer size, Admin admin) {
        Page<Admin> page = new Page<>(currentPage,size);
        IPage<Admin> adminByPage = adminMapper.getAdminByPage(page, admin);
        RespPageBean respPageBean = new RespPageBean(adminByPage.getTotal(), adminByPage.getRecords());
        return respPageBean;
    }

    /*
   更新用户角色
    */
    @Override
    @Transactional
    public RespBean updateAdminRole(Integer adminId, List<Integer> rids) {
//        删除角色
        admin_roleMapper.delete(new QueryWrapper<Admin_Role>().eq("adminId",adminId));
        Integer result = admin_roleMapper.updateAdminRole(adminId, rids);
        if(result == rids.size()) return RespBean.success("更新成功!");
        return RespBean.error("更新失败!");
    }
    /**
     * 聊天时获取所有用户
     *
     * @param keywords
     * @return
     */
    @Override
    public List<Admin> getAllAdmins(String keywords) {

        return adminMapper.getAllAdmins(AdminUtils.getCurrentAdmin().getId(), keywords);
    }

    @Override
    public String getUserName(Integer id) {
        return adminMapper.getUserName(id);
    }


}
