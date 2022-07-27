package com.lym.system.mapper;

import com.lym.system.entity.Admin_Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lym.system.entity.RespBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-10-09
 */
public interface Admin_RoleMapper extends BaseMapper<Admin_Role> {
     /*
   更新用户角色
    */
    Integer updateAdminRole(@Param("adminId") Integer adminId, @Param("rids") List<Integer> rids);
}
