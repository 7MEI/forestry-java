package com.lym.system.controller;


import com.lym.system.entity.AnimalData;
import com.lym.system.entity.Animals;
import com.lym.system.entity.RespBean;
import com.lym.system.entity.RespPageBean;
import com.lym.system.service.AnimalDataService;
import com.lym.system.service.AnimalsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lym
 * @since 2021-11-21
 */
@RestController
@Api(tags = "动物历史数据模块")
@RequestMapping("/animals/basic")
public class AnimalDataController {
@Autowired
    private AnimalDataService animalDataService;
@Autowired
private AnimalsService animalsService;


    @ApiOperation(value = "分页获取动物信息")
    @GetMapping("/AllData")
    public RespPageBean findData(@RequestParam(defaultValue = "1")Integer currentPage,
                                     @RequestParam(defaultValue = "5")Integer size,
                                     AnimalData animalData
    ){
        return animalDataService.getAnimalsByPage(currentPage,size,animalData);
    }


    @ApiOperation(value = "动物信息")
    @GetMapping("/allAnimalData")
    public List<Animals> review(){
        List<Animals> list = animalsService.list();
        return list;
    }

    /*
   添加所有用户信息
    */
    @ApiOperation(value = "添加动物数据")
    @PostMapping("/addAnimalData")
    public RespBean addAdmin(@RequestBody AnimalData animalData){
        animalData.setWritetime(LocalDateTime.now());
        if (animalDataService.save(animalData)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    /*
   修改所有用户信息
    */
    @ApiOperation(value = "更新动物")
    @PutMapping("/updateAdminData")
    public RespBean updateAdmin(@RequestBody AnimalData animalData){
        if (animalDataService.updateById(animalData)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /*
   删除用户信息
    */
    @ApiOperation(value = "删除植物信息")
    @DeleteMapping("/Data/{id}")
    public RespBean deleteAnimals(@RequestParam Integer id){
        if (animalDataService.removeById(id)) return RespBean.success("删除成功！");
        return RespBean.error("删除失败！");
    }
    @ApiOperation(value = "导出历史数据表格")
    @GetMapping(value = "/export",produces = "application/octet-stream")
    public void exportEmp(HttpServletResponse response){
        animalDataService.getOrder(null,response);
    }

}

