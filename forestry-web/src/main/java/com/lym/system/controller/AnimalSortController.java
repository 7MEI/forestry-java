package com.lym.system.controller;


import com.lym.system.entity.*;
import com.lym.system.service.AnimalSortService;
import com.lym.system.service.AnimalsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lym
 * @since 2021-11-18
 */
@RestController
@Api(tags = "动物管理模块")
@RequestMapping("/animals/basic")
public class AnimalSortController {
@Autowired
    private AnimalSortService animalSortService;
@Autowired
private AnimalsService animalsService;

    @ApiOperation(value = "分页获取动物信息")
    @GetMapping("/AllAdmin")
    public RespPageBean findUserPage(@RequestParam(defaultValue = "1")Integer currentPage,
                                     @RequestParam(defaultValue = "3")Integer size,
                                     Animals animals
    ){
        return animalsService.getAnimalsByPage(currentPage,size,animals);

    }

    /*
   添加所有用户信息
    */
    @ApiOperation(value = "添加动物")
    @PostMapping("/addAnimal")
    public RespBean addAdmin(@RequestBody Animals animals){
        animals.setQr(animals.getPicture());
        if (animalsService.save(animals)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    /*
   修改所有用户信息
    */
    @ApiOperation(value = "更新动物")
    @PutMapping("/updateAdmin")
    public RespBean updateAdmin(@RequestBody Animals plant){
        if (animalsService.updateById(plant)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /*
   删除用户信息
    */
    @ApiOperation(value = "删除植物信息")
    @DeleteMapping("/animals/{id}")
    public RespBean deleteAnimals(@RequestParam Integer id){
        if (animalsService.removeById(id)) return RespBean.success("删除成功！");
        return RespBean.error("删除失败！");
    }

    /**
     * 动物种类
     * @return
     */
    @ApiOperation(value = "获取所有动物种类")
    @GetMapping("/AnimalSort")
    public List<AnimalSort> findUserPage(
    ){
        List<AnimalSort> list = animalSortService.list();
        return list;

    }
    /*
   添加所有用户信息
    */
    @ApiOperation(value = "添加动物种类")
    @PostMapping("/addAnimalSort")
    public RespBean addAdmin(@RequestBody AnimalSort animalSort){
        if (animalSortService.save(animalSort)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    /*
   修改所有用户信息
    */
    @ApiOperation(value = "更新动物种类")
    @PutMapping("/updateAnimalSort")
    public RespBean updateAdmin(@RequestBody AnimalSort animalSort){
        if (animalSortService.updateById(animalSort)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /*
   删除用户信息
    */
    @ApiOperation(value = "删除动物种类")
    @DeleteMapping("/{id}")
    public RespBean deleteAdmin(@RequestParam Integer id){
        if (animalSortService.removeById(id)) return RespBean.success("删除成功！");
        return RespBean.error("删除失败！");
    }

}

