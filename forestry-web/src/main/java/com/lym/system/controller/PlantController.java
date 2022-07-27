package com.lym.system.controller;


import com.lym.system.entity.*;
import com.lym.system.service.PlantDataService;
import com.lym.system.service.PlantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lym
 * @since 2021-11-13
 */
@RestController
@Api(tags = "植物管理模块")
@RequestMapping("/plant/info")
public class PlantController {
    @Autowired
    private PlantService plantService;
    @Autowired
    private PlantDataService plantDataService;
    /**
     * 根据条件进行分页查询
     * @param
     * @param size
     * @param
     * @return @RequestBody UserVo userVo
     */
    @ApiOperation(value = "分页获取所有植物信息")
    @GetMapping("/AllAdmin")
    public RespPageBean findUserPage(@RequestParam(defaultValue = "1")Integer currentPage,
                                     @RequestParam(defaultValue = "5")Integer size,
                                     Plant plant
    ){
        return plantService.getAdminByPage(currentPage,size,plant);

    }
    @ApiOperation(value = "全部植物信息")
    @GetMapping("/All/Plant")
    public List<Plant> findAllPage(){
        List<Plant> list = plantService.list();
        return list;

    }
    /*
   添加所有用户信息
    */
    @ApiOperation(value = "添加植物信息")
    @PostMapping("/addAdmin")
    public RespBean addAdmin(@RequestBody Plant plant){
    plant.setPlantqr(plant.getPlantpicture());
        if (plantService.save(plant)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    /*
   修改所有用户信息
    */
    @ApiOperation(value = "更新植物信息")
    @PutMapping("/updateAdmin")
    public RespBean updateAdmin(@RequestBody Plant plant){
        if (plantService.updateById(plant)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /*
   删除用户信息
    */
    @ApiOperation(value = "删除植物信息")
    @DeleteMapping("/{id}")
    public RespBean deleteAdmin(@RequestParam Integer id){
        if (plantService.removeById(id)) return RespBean.success("删除成功！");
        return RespBean.error("删除失败！");
    }

/**
 *
 *记录植物数据
 */

    /**
     * 根据条件进行分页查询
     * @param
     * @param size
     * @param
     * @return @RequestBody UserVo userVo
     */
    @ApiOperation(value = "获取数据")
    @GetMapping("/AllDate")
    public RespPageBean findDatePage(@RequestParam(defaultValue = "1")Integer currentPage,
                                     @RequestParam(defaultValue = "5")Integer size,
                                     PlantData plantData
    ){
        return plantDataService.getDateByPage(currentPage,size,plantData);

    }
    /*
   添加所有信息
    */
    @ApiOperation(value = "添加信息")
    @PostMapping("/addDate")
    public RespBean addDate(@RequestBody PlantData plantData){
        plantData.setWritetime(LocalDateTime.now());
        if (plantDataService.save(plantData)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }
    /*
   修改所有信息
    */
    @ApiOperation(value = "更新信息")
    @PutMapping("/updateDate")
    public RespBean updateDate(@RequestBody PlantData plantData){
        if (plantDataService.updateById(plantData)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
    /*
   删除信息
    */
    @ApiOperation(value = "删除信息")
    @DeleteMapping("/Date/{id}")
    public RespBean deleteDate(@RequestParam Integer id){
        if (plantDataService.removeById(id)) return RespBean.success("删除成功！");
        return RespBean.error("删除失败！");
    }
    /*
   批量删除数据
    */
    @ApiOperation(value = "批量删除")
    @DeleteMapping("/")
    public RespBean deleteDepByIds(Integer[] ids){
        if (plantDataService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
    @ApiOperation(value = "导出历史数据表格")
    @GetMapping(value = "/export",produces = "application/octet-stream")
    public void exportEmp(HttpServletResponse response){
        plantDataService.getOrder(null,response);
    }
}

