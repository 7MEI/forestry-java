package com.lym.system.controller;

import com.lym.system.entity.RespBean;
import com.lym.system.entity.Slideshow;
import com.lym.system.service.SlideshowService;
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
 * @since 2021-12-01
 */
@RestController
@Api(tags = "轮播图管理")
@RequestMapping("/slideshow")
public class SlideshowController {
@Autowired
    private SlideshowService slideshowService;
    @ApiOperation(value = "获取所有轮播图")
    @GetMapping("/AllInfo")
    public List<Slideshow> findUserPage(){
        List<Slideshow> list = slideshowService.list();
        return list;

    }
    /*
   添加所有部门信息
    */
    @ApiOperation(value = "添加")
    @PostMapping("/addOrd")
    public RespBean addDep(@RequestBody Slideshow slideshow){
        if (slideshowService.save(slideshow)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    /*
   修改所有部门信息
    */
    @ApiOperation(value = "更新信息")
    @PutMapping("/updateOrd")
    public RespBean updataDep(@RequestBody Slideshow slideshow){
        if(slideshowService.updateById(slideshow)){
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
        if (slideshowService.removeById(id)){
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
        if (slideshowService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}

