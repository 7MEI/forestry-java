package com.lym.system.controller;


import com.lym.system.entity.Departments;
import com.lym.system.entity.RespBean;
import com.lym.system.service.DepartmentService;
import com.lym.system.service.DepartmentsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lym
 * @since 2021-11-23
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentsController {
    @Autowired
    DepartmentsService departmentsService;

    @ApiOperation("获取所有部门")
    @GetMapping("/list")
    public List<Departments> getAllInFo(){
        return departmentsService.getAllInFo();
    }



    @ApiOperation("添加部门")
    @PostMapping("/add")
    public RespBean addDept(@RequestBody Departments departments){

        return departmentsService.addDept(departments);
    }

    @ApiOperation("删除部门")
    @DeleteMapping("/{id}")
    public RespBean deleteDept(@PathVariable Integer id){
        return departmentsService.deleteDept(id);
    }
}

