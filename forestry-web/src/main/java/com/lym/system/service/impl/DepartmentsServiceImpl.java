package com.lym.system.service.impl;

import com.lym.system.entity.Departments;
import com.lym.system.entity.RespBean;
import com.lym.system.mapper.DepartmentsMapper;
import com.lym.system.service.DepartmentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lym
 * @since 2021-11-23
 */
@Service
public class DepartmentsServiceImpl extends ServiceImpl<DepartmentsMapper, Departments> implements DepartmentsService {
    @Autowired
    private DepartmentsMapper departmentsMapper;
    /**
     * 获取所有部门
     * @return
     */
    @Override
    public List<Departments> getAllInFo() {
        return departmentsMapper.getAllInFo(-1);
    }

    @Override
    public RespBean addDept(Departments departments) {
        departments.setEnabled(true);
        departmentsMapper.addDept(departments);
        if (departments.getResult() == 1){
            return RespBean.success("添加成功！",departments);
        }
        return RespBean.error("添加失败！");
    }

    @Override
    public RespBean deleteDept(Integer id) {
        Departments departments = new Departments();
        departments.setId(id);
        departmentsMapper.deleteDept(departments);
        if (departments.getResult() == -2) return RespBean.error("该部门下还有子部门，删除失败！");
        if (departments.getResult() == -1) return RespBean.error("该部门下还有员工，删除失败！");
        if (departments.getResult() == 1) return RespBean.success("删除成功！");
        return RespBean.error("删除失败！");
    }
}
