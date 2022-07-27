package com.lym.system.controller;


import com.lym.system.entity.Admin;
import com.lym.system.entity.Employee;
import com.lym.system.entity.Login;
import com.lym.system.entity.RespBean;
import com.lym.system.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

//@ApiOperation(value = "用户登录")
@Api(tags = "LoginController")
@RestController
public class LoginController {
    @Autowired
    private AdminService adminService;
    @ApiOperation(value = "用户登录,返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody Login login,HttpServletRequest request){
        return adminService.UserLogin(login.getUsername(),login.getPassword(),login.getCode(),request);
    }


    @ApiOperation(value = "获取当前登录用户的信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal){
//        通过principal获取用户名
        if (null==principal){
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
//        根据用户Id获取角色列表
        admin.setRoles(adminService.getRoles(admin.getId()));
        admin.setEmployee(adminService.getEmployee(admin.getCardId()));
        return admin;
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("退出成功");
    }
}
