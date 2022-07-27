package com.lym.system.controller;


import com.lym.system.entity.*;
import com.lym.system.service.Admin2Service;
import com.lym.system.service.AdminService;
import com.lym.system.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lym
 * @since 2021-10-06
 */
@RestController
@Api(tags = "用户管理模块")
@RequestMapping("/user/info")
public class AdminController {


    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;

    /**
     * 根据条件进行分页查询
     * @param
     * @param size
     * @param
     * @return @RequestBody UserVo userVo
     */
    @ApiOperation(value = "分页获取所有用户信息")
    @GetMapping("/AllAdmin")
    public RespPageBean findUserPage(@RequestParam(defaultValue = "1")Integer currentPage,
                               @RequestParam(defaultValue = "5")Integer size,
                                 Admin admin
                               ){
        return adminService.getAdminByPage(currentPage,size,admin);

    }

    /*
   修改所有用户信息
    */
    @ApiOperation(value = "更新用户信息")
    @PutMapping("/updateAdmin")
    public RespBean updateAdmin(@RequestBody Admin admin){
        if (adminService.updateById(admin)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /*
   删除用户信息
    */
    @ApiOperation(value = "删除用户信息")
    @DeleteMapping("/{id}")
    public RespBean deleteAdmin(@PathVariable Integer id){
        if (adminService.removeById(id)) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation(value = "更新操作员角色")
    @PutMapping("/updateRole")
    public RespBean updateAdminRole(@RequestParam("adminId") Integer adminId,
                                    @RequestParam("rids") List<Integer> rids){

        return adminService.updateAdminRole(adminId,rids);
    }

}

