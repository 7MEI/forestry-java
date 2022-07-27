package com.lym.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lym.system.entity.Menu_Role;
import com.lym.system.entity.RespBean;
import com.lym.system.mapper.Menu_RoleMapper;
import com.lym.system.service.Menu_RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Action;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lym
 * @since 2021-10-09
 */
@Service
public class Menu_RoleServiceImpl extends ServiceImpl<Menu_RoleMapper, Menu_Role> implements Menu_RoleService {
@Autowired
private Menu_RoleMapper menuRoleMapper;
    @Override
    @Transactional
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.delete(new QueryWrapper<Menu_Role>().eq("rid",rid));
        if (mids == null || mids.length == 0){
            return RespBean.success("更新成功!");
        }
        //批量添加权限
        Integer result = menuRoleMapper.batchInset(rid, mids);
        if (result == mids.length) return RespBean.success("修改成功！");
        return RespBean.error("修改失败！");
    }
}
