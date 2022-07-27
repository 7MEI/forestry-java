package com.lym.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lym.handle.BusinessException;
import com.lym.reponse.ResultCode;
import com.lym.system.entity.Department;
import com.lym.system.entity.User;
import com.lym.system.mapper.DepartmentMapper;
import com.lym.system.mapper.UserMapper;
import com.lym.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lym
 * @since 2021-09-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public IPage<User> findUserPage(Page<User> page, QueryWrapper<User> wrapper) {
        return this.baseMapper.findUserPage(page,wrapper);
    }

    @Override
    public void addUser(User user) {
        //判断是否增加了同一个用户
        String username = user.getUsername();
        //获取部门
        Long departmentId = user.getDepartmentId();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Integer count = this.baseMapper.selectCount(wrapper);
        if(count!=0){
            throw new BusinessException(ResultCode.USER_ACCOUNT_ALREADY_EXIST.getCode(),
                    ResultCode.USER_ACCOUNT_ALREADY_EXIST.getMessage());
        }
        Department department = departmentMapper.selectById(departmentId);
        if(department==null){
            throw new BusinessException(ResultCode.DEPARTMENT_NOT_EXIST.getCode(),
                    ResultCode.DEPARTMENT_NOT_EXIST.getMessage());
        }
        String salt = UUID.randomUUID().toString().substring(0,32);
        user.setSalt(salt);
        //没有设置创建时间和更新时间  使用mybatis-plus的自动填充功能实现
        user.setCreateTime(new Date());
        user.setModifiedTime(new Date());
        //使用spring security自带的密码加密策略
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //用户类型UserTypeEnum.SYSTEM_USER.getTypeCode()
        user.setType(1);
        //设置状态UserStatusEnum.AVAILABLE.getStatusCode()
        user.setStatus(1);
        //设置是否删除
        user.setDeleted(false);
        this.baseMapper.insert(user);

    }
}
