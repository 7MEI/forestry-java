package com.lym.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.Admin2;
import com.lym.system.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-09-28
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    List<Department> findDeptAndCount();

    IPage<Department> getAdminByPage( Page<Department> page, @Param("department") Department department);


}
