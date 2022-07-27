package com.lym.system.mapper;

import com.lym.system.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-10-08
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /*
根据用户id获取菜单列表
*/
    List<Menu> getMenusByUserId(Integer id);
    /*
根据角色获取菜单列表
*/
    List<Menu> getMenuByRole();

    List<Menu> getAllMenus();
}
