package com.lym.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lym.auth.security.JwtTokenUtil;
import com.lym.system.entity.*;
import com.lym.system.mapper.Admin2Mapper;
import com.lym.system.mapper.AdminMapper;
import com.lym.system.mapper.RoleMapper;
import com.lym.system.service.Admin2Service;
import com.lym.system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
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
public class Admin2ServiceImpl extends ServiceImpl<Admin2Mapper, Admin2> implements Admin2Service {
    @Autowired
    private Admin2Mapper admin2Mapper;

//    @Override
//    public IPage<Admin2> findUserPage(Page<Admin2> page, QueryWrapper<Admin2> wrapper) {
//        return this.baseMapper.findUserPage(page,wrapper);
//    }
    /**
     * 根据条件进行分页查询
     * @param
     * @param size
     * @param
     * @return @RequestBody UserVo userVo
     */
    @Override
    public RespPageBean getAdminByPage(Integer currentPage, Integer size, Admin2 admin2) {
//        开启分页
        Page<Admin2> page = new Page<>(currentPage,size);
        IPage<Admin2> adminByPage = admin2Mapper.getAdminByPage(page, admin2);
        RespPageBean respPageBean = new RespPageBean(adminByPage.getTotal(), adminByPage.getRecords());
        return respPageBean;
    }
}
