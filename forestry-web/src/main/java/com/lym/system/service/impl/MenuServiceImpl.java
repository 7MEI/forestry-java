package com.lym.system.service.impl;

import com.lym.system.entity.Admin;
import com.lym.system.entity.Menu;
import com.lym.system.mapper.MenuMapper;
import com.lym.system.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lym.util.AdminUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lym
 * @since 2021-10-08
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    /*
根据用户id获取菜单列表
*/
    @Override
    public List<Menu> getMenusByUserId() {
        return menuMapper.getMenusByUserId(AdminUtils.getCurrentAdmin().getId());
    }
    /*
根据角色获取菜单列表
*/
    @Override
    public List<Menu> getMenuByRole() {
        return menuMapper.getMenuByRole();
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
