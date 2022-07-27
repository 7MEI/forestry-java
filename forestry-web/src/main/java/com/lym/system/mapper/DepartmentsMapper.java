package com.lym.system.mapper;

import com.lym.system.entity.Departments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-11-23
 */
public interface DepartmentsMapper extends BaseMapper<Departments> {

    /**
     * 获取所有部门
     * @return
     */
    List<Departments> getAllInFo(Integer parentId);


    /**
     * 添加部门
     * @param departments
     * @return
     */
    void addDept(Departments departments);

    void deleteDept(Departments departments);
}
