package com.lym.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lym.system.entity.Department;
import com.lym.system.entity.Departments;
import com.lym.system.entity.RespPageBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lym
 * @since 2021-09-28
 */
public interface DepartmentService extends IService<Department> {


    List<Department> findDeptAndCount();
    /**
     * 根据条件进行分页查询
     * @param
     * @param size
     * @param
     * @return @RequestBody UserVo userVo
     */
    RespPageBean getByPage(Integer currentPage, Integer size, Department department);


}
