package com.lym.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lym.system.entity.RespBean;
import com.lym.system.entity.RespPageBean;
import com.lym.system.entity.SysMsg;
import com.lym.system.entity.SysMsgContent;
import com.lym.system.service.AdminService;
import com.lym.system.service.SysMsgContentService;
import com.lym.system.service.SysMsgService;
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
@Api(value = "系统通知推送模块",tags = "SysMsgController")
public class SysMsgController {
    @Autowired
    private SysMsgService msgService;

    @Autowired
    private SysMsgContentService contentService;

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "根据用户id查询用户名")
    @PostMapping("/system/cfg/userById/{id}")
    public String selectAllGoods(@PathVariable Integer id){
        String userName = adminService.getUserName(id);
        return userName;
    }

    @ApiOperation(value = "添加通知消息")
    @PostMapping("/system/cfg/send")
    public RespBean addSysMsg(@RequestBody SysMsg sysMsg){
        if (msgService.save(sysMsg)) { return RespBean.success("添加成功"); }
        return RespBean.error("添加失败");
    }


    @ApiOperation(value = "根据mid查询通知范围")
    @PostMapping("/system/cfg/send/{mid}")
    public List<SysMsg> selectAllSend(@PathVariable Integer mid){
        QueryWrapper<SysMsg> wrapper = new QueryWrapper<>();
        wrapper
                .eq("mid", mid);
        List<SysMsg> list = msgService.list(wrapper);
        return list;
    }

    @ApiOperation(value = "根据uid查询通知")
    @PostMapping("/system/cfg/my_msg/{uid}")
    public List<SysMsg> selectMsgByUid(@PathVariable Integer uid,
                                       @RequestParam Integer state){
        QueryWrapper<SysMsg> wrapper = new QueryWrapper<>();
        wrapper
                .eq("uid", uid)
                .eq("state", state);
        wrapper.or(i->i.eq("type", 0)
                .eq("state", state)
        );
        List<SysMsg> list = msgService.list(wrapper);
        return list;
    }

    @ApiOperation(value = "根据Mid查询通知")
    @GetMapping("/system/cfg/my_content/{mid}")
    public SysMsgContent selectMsgByMid(@PathVariable Integer mid){
        QueryWrapper<SysMsgContent> wrapper = new QueryWrapper<>();
        wrapper
                .eq("id", mid);
        SysMsgContent content = contentService.getOne(wrapper);
        return content;
    }

    @ApiOperation(value = "修改通知阅读状态信息")
    @GetMapping("/system/cfg/update/{id}")
    public RespBean updateRent(@PathVariable Integer id,
                             @RequestParam Integer uid){
        QueryWrapper<SysMsg> wrapper = new QueryWrapper<>();
        wrapper
                .eq("mid", id)
                .eq("uid", uid);
        SysMsg one = msgService.getOne(wrapper);
        one.setState(1);
        if (msgService.updateById(one)) {
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }


    @ApiOperation(value = "删除一条通知")
    @DeleteMapping("/system/cfg/deleteMsg/{id}")
    public RespBean deleteRent(@PathVariable Integer id,
                             @RequestParam Integer uid){

        QueryWrapper<SysMsg> wrapper = new QueryWrapper<>();
        wrapper
                .eq("mid", id)
                .eq("uid", uid);
        SysMsg one = msgService.getOne(wrapper);
        if (msgService.removeById(one.getId())) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

}

