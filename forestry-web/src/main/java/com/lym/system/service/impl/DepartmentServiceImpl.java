package com.lym.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lym.system.entity.Admin2;
import com.lym.system.entity.Department;
import com.lym.system.entity.RespPageBean;
import com.lym.system.mapper.DepartmentMapper;
import com.lym.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lym
 * @since 2021-09-28
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findDeptAndCount() {
        return this.baseMapper.findDeptAndCount();
    }

    @Override
    public RespPageBean getByPage(Integer currentPage, Integer size, Department department) {
        //        开启分页
        Page<Department> page = new Page<>(currentPage,size);
        IPage<Department> adminByPage = departmentMapper.getAdminByPage(page, department);
        RespPageBean respPageBean = new RespPageBean(adminByPage.getTotal(), adminByPage.getRecords());
        return respPageBean;

    }


}
