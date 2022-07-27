package com.lym.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lym.system.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lym
 * @since 2021-09-24
 */
public interface UserService extends IService<User> {
    IPage<User> findUserPage(Page<User> page,QueryWrapper<User> wrapper);
//添加用户
    void addUser(User user);
}
