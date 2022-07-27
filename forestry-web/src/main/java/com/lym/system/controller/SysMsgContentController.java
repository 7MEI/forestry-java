package com.lym.system.controller;


import com.lym.system.entity.RespBean;
import com.lym.system.entity.SysMsgContent;
import com.lym.system.service.SysMsgContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lym
 * @since 2021-12-02
 */
@RestController
@Api(value = "系统通知模块",tags = "SysMsgContentController")
public class SysMsgContentController {
    @Autowired
    private SysMsgContentService contentService;

    @ApiOperation(value = "查出全部通知消息列表")
    @PostMapping("/system/cfg/list")
    public List<SysMsgContent> selectAllLists(){
        List<SysMsgContent> content = contentService.list();
        return content;
    }

    @ApiOperation(value = "添加通知消息")
    @PostMapping("/system/cfg/add")
    public RespBean addSysMsgContent(@RequestBody SysMsgContent content){
        if (contentService.save(content)) { return RespBean.success("添加成功"); }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "更新通知消息")
    @PutMapping("/system/cfg/update")
    public RespBean updateSysMsgContent(@RequestBody SysMsgContent content){
        if (contentService.updateById(content)) {
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }


    @ApiOperation(value = "删除通知消息")
    @DeleteMapping("/system/cfg/delete/{id}")
    public RespBean deldeteSysMsgContent(@PathVariable Integer id){
        if (contentService.removeById(id)) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}

