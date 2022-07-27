package com.lym.system.controller;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.lym.system.entity.*;
import com.lym.system.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LHC
 * @since 2021-06-25
 */
@RestController
@RequestMapping("/employee/basic")
@Api(value = "员工管理", tags = "员工管理")
public class EmployeeController {

    @Autowired
    EmployeeService iEmployeeService;

    @Autowired
    PoliticsStatusService iPoliticsStatusService;

    @Autowired
    NationService iNationService;

    @Autowired
    DepartmentsService iDepartmentService;


    @ApiOperation(value = "获取所有员工(分页)")
    @GetMapping("/list")
    public RespPageBean getEmployee(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "10") Integer size,
                                    Employee employee,
                                    @RequestParam(value = "startDate", required = false) String startDate,
                                    @RequestParam(value = "endDate", required = false) String endDate) {
        return iEmployeeService.getEmployeeList(currentPage, size, employee, startDate, endDate);
    }

    @ApiOperation(value = "获取所有政治面貌")
    @GetMapping("/get-politics-status")
    public List<PoliticsStatus> getPoliticsStatus() {
        return iPoliticsStatusService.list();
    }


    @ApiOperation(value = "获取所有民族")
    @GetMapping("/get-all-Nation")
    public List<Nation> getNation() {

        return iNationService.list();
    }


    @ApiOperation(value = "获取所有部门")
    @GetMapping("/allDepartment")
    public List<Departments> Department() {

        return iDepartmentService.list();
    }

    @ApiOperation(value = "获取最大工号方法一")
    @GetMapping("/get-max-WorkID")
    public RespBean getMaxWorkID1(){
        //工号为char类型 获取工号后 +1 可以保证ID自增并且唯一
        return iEmployeeService.getMaxWorkID();
    }

    @ApiOperation(value = "获取最大工号方法二")
    @GetMapping("/get-max-WorkID2")
    public RespBean getMaxWorkID2(){
        //工号为char类型 获取工号后 +1 可以保证ID自增并且唯一
        return iEmployeeService.getMaxWorkID2();
    }

    @ApiOperation(value = "添加员工")
    @PostMapping("/addEmp")
    public RespBean addEmp(@RequestBody Employee employee){
        RespBean bean = iEmployeeService.addEmp(employee);
        return bean;
    }

    @ApiOperation(value = "更新员工")
    @PutMapping("/update")
    public RespBean updateEmp(@RequestBody Employee employee){
        if (iEmployeeService.updateById(employee)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除员工")
    @DeleteMapping("/delete/{id}")
    public RespBean deleteEmp(@PathVariable Integer id){
        if (iEmployeeService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "导出员工表格")
    @GetMapping(value = "/export",produces = "application/octet-stream")
    public void exportEmp(HttpServletResponse response){
        iEmployeeService.getEmployee(null,response);
    }

    @ApiOperation(value = "导入员工信息")
    @PostMapping("/import")
    public RespBean importEmp(MultipartFile multipartFile){
        ImportParams params = new ImportParams();
        params.setTitleRows(1);//表的标题行数，去掉前两行(第一行表标题，第二行列标题)，如果超出表格本身的标题行数，截取数据为null
        params.setStartRows(0);//列标题和实际字段值的距离，可以设置从第几行开始截取数据，默认为0，就是列标题的下一行
        try {
            InputStream inputStream = multipartFile.getInputStream();
            //设置导入使用的流 实体类 实体类的具体字段(加了Excel注解的字段)
            //返回值就是一个对象集合，里面包含了所有从文件中获取的数据
            /* 需求：此时获取的对象信息，里面有很多字段用户添加的是名字，需要将名字找到对应的ID添加导入到数据库
            *  所以需要在添加数据库之前，把名字对应的ID准备完成，实际添加用对应ID添加
            *  这个sql只需要查询一次数据库，但是如果用户传入的某一个ID查找出来为空的，其他ID也找不到
            *  如果避免这种情况，可以写 5 条 sql 查找各自的ID
            * */
            List<Employee> employeeList = ExcelImportUtil.importExcel(inputStream, Employee.class, params);
            Iterator<Employee> iterator = employeeList.iterator();
            while (iterator.hasNext()){
                Employee next = iterator.next();
                Map<String, String> employeeMap = new HashMap<>();
                employeeMap.put("nationName",next.getNation().getName());
                employeeMap.put("politicsStatusName",next.getPoliticsStatus().getName());
                employeeMap.put("departmentName",next.getDepartment().getName());
                System.out.println(employeeMap.get("nationName"));
                System.out.println(employeeMap.get("politicsStatusName"));
                System.out.println(employeeMap.get("departmentName"));
                System.out.println(employeeMap.get("joblevelName"));
                System.out.println(employeeMap.get("positionName"));
                //各种ID 民族 政治面貌 部门 岗位 职称
                Employee ids = iEmployeeService.getIdSelectNationByName(employeeMap);
                //将获取的各种ID设置进实体对象中，进行添加操作

                //获取传进来的民族对应的ID
                next.setNationId(ids.getNation().getId());
                next.setPoliticId(ids.getPoliticsStatus().getId());
                next.setDepartmentId(ids.getDepartment().getId());
                iEmployeeService.addEmp(next);
            }
            multipartFile.getInputStream().close();
            return RespBean.success("导入成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RespBean.success("导入失败");
    }

}
