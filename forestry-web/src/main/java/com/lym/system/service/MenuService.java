package com.lym.system.service;

import com.lym.system.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lym
 * @since 2021-10-08
 */
public interface MenuService extends IService<Menu> {

    /*
根据用户id查询菜单列表
 */
    List<Menu> getMenusByUserId();

    /*
根据角色查询菜单列表
*/
    List<Menu> getMenuByRole();
   /*
根据菜单列表
*/

    List<Menu> getAllMenus();
}
