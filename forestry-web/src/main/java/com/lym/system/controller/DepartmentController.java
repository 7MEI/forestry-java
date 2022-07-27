package com.lym.system.controller;


import com.lym.handle.BusinessException;
import com.lym.reponse.Result;
import com.lym.reponse.ResultCode;
import com.lym.system.entity.Admin2;
import com.lym.system.entity.Department;
import com.lym.system.entity.RespBean;
import com.lym.system.entity.RespPageBean;
import com.lym.system.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lym
 * @since 2021-09-28
 */
@RestController
@RequestMapping("/department/deps")
@Api(tags = "部门管理")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    /**
     * 根据条件进行分页查询
     * @param
     * @param size
     * @param
     * @return @RequestBody UserVo userVo
     */
    @ApiOperation(value = "分页获取所有用户信息")
    @GetMapping("/AllDep")
    public RespPageBean findUserPage(@RequestParam(defaultValue = "1")Integer currentPage,
                                     @RequestParam(defaultValue = "5")Integer size,
                                     Department department
    ){
        return departmentService.getByPage(currentPage,size,department);

    }
     /*
    添加所有部门信息
     */
    @ApiOperation(value = "添加部门")
    @PostMapping("/addDep")
    public RespBean addDep(@RequestBody Department department){
//        department.setCreateTime(LocalDateTime.now());
        department.setCreateTime(LocalDateTime.now());
        if (departmentService.save(department)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

     /*
    修改所有部门信息
     */
    @ApiOperation(value = "更新部门信息")
    @PutMapping("/updateDep")
    public RespBean updataDep(@RequestBody Department department){
        if(departmentService.updateById(department)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }
     /*
    删除部门信息
     */
    @ApiOperation(value = "删除部门")
    @DeleteMapping("/{id}")
    public RespBean deleteDep(@PathVariable Integer id){
        if (departmentService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return  RespBean.error("删除失败");
    }
     /*
    批量删除部门信息
     */
    @ApiOperation(value = "批量删除")
    @DeleteMapping("/")
    public RespBean deleteDepByIds(Integer[] ids){
        if (departmentService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

}

