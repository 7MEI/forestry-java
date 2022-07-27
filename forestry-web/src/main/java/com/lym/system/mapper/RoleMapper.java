package com.lym.system.mapper;

import com.lym.system.entity.Employee;
import com.lym.system.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-10-09
 */
public interface RoleMapper extends BaseMapper<Role> {
    /*
      跟据用户查询角色列表
       */
    List<Role> getRoles(Integer adminId);
    /*
   跟据用户查询员工信息
    */
    List<Employee> getEmployee(String cardId);
}
