package com.lym.system.service;

import com.lym.system.entity.Departments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lym.system.entity.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lym
 * @since 2021-11-23
 */
public interface DepartmentsService extends IService<Departments> {

    /**
     * 获取所有部门
     * @return
     */
    List<Departments> getAllInFo();
    /**
     * 添加部门
     * @param departments
     * @return
     */
    RespBean addDept(Departments departments);
    /**
     * 删除部门
     * @param id
     * @return
     */
    RespBean deleteDept(Integer id);
}
