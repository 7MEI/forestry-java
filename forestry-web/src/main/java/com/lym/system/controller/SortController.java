package com.lym.system.controller;


import com.lym.system.entity.Plant;
import com.lym.system.entity.RespBean;
import com.lym.system.entity.RespPageBean;
import com.lym.system.entity.Sort;
import com.lym.system.service.SortService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lym
 * @since 2021-11-13
 */
@RestController
@Api(tags = "植物种类模块")
@RequestMapping("/system/sort")
public class SortController {
    @Autowired
    private SortService sortService;
    /**
     * 根据条件进行分页查询
     * @param
     * @param size
     * @param
     * @return @RequestBody UserVo userVo
     */
    @ApiOperation(value = "分页获取所有植物种类信息")
    @GetMapping("/AllAdmin")
    public RespPageBean findUserPage(@RequestParam(defaultValue = "1")Integer currentPage,
                                     @RequestParam(defaultValue = "12")Integer size,
                                     Sort sort
    ){
        return sortService.getAdminByPage(currentPage,size,sort);

    }
    /*
   添加所有用户信息
    */
    @ApiOperation(value = "添加植物种类信息")
    @PostMapping("/addAdmin")
    public RespBean addAdmin(@RequestBody Sort sort){
        if (sortService.save(sort)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    /*
   修改所有用户信息
    */
    @ApiOperation(value = "更新植物种类信息")
    @PutMapping("/updateAdmin")
    public RespBean updateAdmin(@RequestBody Sort sort){
        if (sortService.updateById(sort)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /*
   删除用户信息
    */
    @ApiOperation(value = "删除植物种类信息")
    @DeleteMapping("/{id}")
    public RespBean deleteAdmin(@RequestParam Integer id){
        if (sortService.removeById(id)) return RespBean.success("删除成功！");
        return RespBean.error("删除失败！");
    }

    /*
批量删除信息
 */
    @ApiOperation(value = "批量删除")
    @DeleteMapping("/")
    public RespBean deleteDepByIds(Integer[] ids){
        if (sortService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}

