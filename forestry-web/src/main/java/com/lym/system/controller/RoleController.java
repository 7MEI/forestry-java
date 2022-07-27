package com.lym.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lym.system.entity.Menu;
import com.lym.system.entity.Menu_Role;
import com.lym.system.entity.RespBean;
import com.lym.system.entity.Role;
import com.lym.system.service.MenuService;
import com.lym.system.service.Menu_RoleService;
import com.lym.system.service.RoleService;
import com.rabbitmq.client.AMQP;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CORBA.REBIND;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationServiceMBean;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: yeb
 * @description: 权限组
 * @author: Honors
 * @create: 2021-07-16 16:01
 */
@Api(value = "权限管理",tags = "权限管理")
@RestController
@RequestMapping("/system/basic/permission")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private Menu_RoleService menuRoleService;

    @ApiOperation("添加角色")
    @PostMapping("/add")
    public RespBean addRole(@RequestBody Role role){
        //判断传入的权限字符是否以 ROLE_ 开头，Security 权限判断要求要 ROLE_ 开头
        if (!role.getName().startsWith("ROLE_")){
            //如果不是以 ROLE_ 开头，在添加前拼接一个
            role.setName("ROLE_" + role.getName());
        }
        if (roleService.save(role)){

            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation("修改角色")
    @PutMapping("/update/")
    public RespBean update(@RequestBody Role role){
        if (roleService.updateById(role)){
            return RespBean.success("修改成功！");
        }
        return RespBean.error("修改失败！");
    }

    @ApiOperation("获取角色列表")
    @GetMapping("/list")
    public List<Role> getRoleList(){
        return roleService.list();
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/delete{id}")
    public RespBean deleteRole(@PathVariable Integer id){
        if (roleService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation("批量删除角色")
    @DeleteMapping("/delete/ids")
    public RespBean deleteRoles(@RequestParam("ids") List<Long> ids){
        if (roleService.removeByIds(ids)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation("获取所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){

        return  menuService.getAllMenus();
    }

    @ApiOperation("根据角色ID查找菜单ID")
    @GetMapping("/mid/{rid}")
    public List<Integer> getByIdMenus(@PathVariable Integer rid){
        List<Menu_Role> menuRoles = menuRoleService.list(new QueryWrapper<Menu_Role>().eq("rid", rid));
        Stream<Integer> integerStream = menuRoles.stream().map(Menu_Role::getMid);
        List<Integer> collect = integerStream.collect(Collectors.toList());
        return collect;
    }

    @ApiOperation("更新角色菜单")
    @PutMapping("/updatemenus/{rid}")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        return menuRoleService.updateMenuRole(rid,mids);
    }

}