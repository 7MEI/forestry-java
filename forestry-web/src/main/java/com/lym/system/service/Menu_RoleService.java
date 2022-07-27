package com.lym.system.service;

import com.lym.system.entity.Menu_Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lym.system.entity.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lym
 * @since 2021-10-09
 */
public interface Menu_RoleService extends IService<Menu_Role> {
    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
