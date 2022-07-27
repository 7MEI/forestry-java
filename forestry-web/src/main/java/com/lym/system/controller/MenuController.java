package com.lym.system.controller;


import com.lym.system.entity.Menu;
import com.lym.system.service.AdminService;
import com.lym.system.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lym
 * @since 2021-10-08
 */
@RestController
@RequestMapping("/system/cfg")
public class MenuController {
    @Autowired
    private MenuService menuService;
/*
根据用户ID 获得菜单列表
 */
    @GetMapping("/menu")
    @ApiOperation(value = "用户Id查询菜单列表")
    private List<Menu> getMenusByUserId(){
        return menuService.getMenusByUserId();
    }
    /*
根据用户ID 获得菜单列表
 */
//    @GetMapping("/menu")
//    @ApiOperation(value = "用户Id查询菜单列表")
//    private List<Menu> getMenusByUserId(){
//        return menuService.getMenusByUserId();
//    }
}

