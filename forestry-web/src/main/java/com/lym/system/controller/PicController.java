package com.lym.system.controller;


import com.lym.system.entity.Pic;
import com.lym.system.service.PicService;
import io.swagger.annotations.Api;
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
 * @since 2021-11-18
 */
@Api(tags = "图片管理")
@RestController
@RequestMapping("/animals/basic")
public class PicController {
    @Autowired
    private PicService picService;
    @ApiOperation(value = "获取数据")
    @GetMapping("/AllPic")
    public List<Pic> findDatePage(){
        List<Pic> list = picService.list();
        return list;

    }
}

