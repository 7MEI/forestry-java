package com.lym.system.controller;


import com.lym.system.entity.Apply;
import com.lym.system.entity.RespBean;
import com.lym.system.entity.RespPageBean;
import com.lym.system.service.ApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lym
 * @since 2021-10-25
 */
@RestController
@Api(tags = "活动管理")
@RequestMapping("/act")
public class ApplyController {
   @Autowired
    private ApplyService applyService;
    /**
     * 根据条件进行分页查询
     * @param
     * @param size
     * @param
     * @return @RequestBody UserVo userVo
     */
    @ApiOperation(value = "分页获取所有申请活动信息")
    @GetMapping ("/apply/AllApply")
    public RespPageBean findUserPage(@RequestParam(defaultValue = "1")Integer currentPage,
                                     @RequestParam(defaultValue = "5")Integer size,
                                     Apply apply
    ){
        return applyService.getByPage(currentPage,size,apply);

    }
    /**
     * 普通用户根据条件进行分页查询
     * @param
     * @param size
     * @param
     * @return @RequestBody UserVo userVo
     */
    @ApiOperation(value = "用户查看活动信息")
    @GetMapping ("/user/AllApply")
    public RespPageBean findPage(@RequestParam(defaultValue = "1")Integer currentPage,
                                     @RequestParam(defaultValue = "8")Integer size,
                                     Apply apply
    ){
        return applyService.getUserByPage(currentPage,size,apply);

    }
    /*
   申请活动信息
    */
    @ApiOperation(value = "申请活动")
    @PostMapping("/apply/addApply")
    public RespBean addDep(@RequestBody Apply apply){
        apply.setStatus(0);
        apply.setNowtime(LocalDateTime.now());
        if (applyService.save(apply)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

//    /*
//   更新活动信息
//    */
    @ApiOperation(value = "更新活动信息")
    @PutMapping("/apply/updateApply")
    public RespBean updataDep(@RequestBody Apply apply){
        if(applyService.updateById(apply)){
                    return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }
//    /*
//   删除活动信息
//    */
    @ApiOperation(value = "删除活动")
    @DeleteMapping("/apply/{id}")
    public RespBean deleteDep(@PathVariable Integer id){
        if (applyService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return  RespBean.error("删除失败");
    }
}

