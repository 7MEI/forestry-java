package com.lym.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lym.system.entity.Reply;
import com.lym.system.entity.RespBean;
import com.lym.system.service.ReplyService;
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
@Api(value = "系统回复模块",tags = "ReplyController")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

//    @ApiOperation(value = "根据评论id查询回复列表")
//    @GetMapping("/personal/data/reply")
//    public List<Reply> selectAllReply(@RequestParam Integer commentId){
//        List<Reply> list = replyService.selectReply(commentId);
//        return list;
//    }


    @ApiOperation(value = "添加回复")
    @PostMapping("/activity/user/reply/add")
    public RespBean addReply(@RequestBody Reply reply){
        if (replyService.save(reply)) { return RespBean.success("添加评论成功"); }
        return RespBean.error("添加评论失败");
    }

    @ApiOperation(value = "删除评价")
    @DeleteMapping("/activity/user/reply/{commentId}")
    public RespBean deleteReply(@PathVariable Integer commentId,
                              @RequestParam Integer userId){

        QueryWrapper<Reply> wrapper = new QueryWrapper<>();
        wrapper
                .eq("comment_Id", commentId)
                .eq("user_id", userId);
        Reply one = replyService.getOne(wrapper);
        if (replyService.removeById(one.getReplyId())) {
            return RespBean.success("删除评价成功");
        }
        return RespBean.error("删除评价失败");
    }

    @ApiOperation(value = "更新点赞数量")
    @PutMapping("/activity/user/reply/update")
    public RespBean updateAskReply(@RequestBody Reply reply){
        if (replyService.updateById(reply)) {
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }
}

