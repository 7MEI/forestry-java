package com.lym.system.controller;


import com.lym.system.entity.Comment;
import com.lym.system.entity.RespBean;
import com.lym.system.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
@Api(value = "系统求租模块",tags = "AskGoodController")
public class CommentController {


    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "通过活动id查询评论列表")
    @GetMapping("/activity/user/comment")
    public List<Comment> getAskGood(){
        return commentService.getAllComment();
    }

    @ApiOperation(value = "更新点赞数量")
    @PutMapping("/activity/user/comment/update")
    public RespBean updateAskGood(@RequestBody Comment comment){
        if (commentService.updateById(comment)) {
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }


    @ApiOperation(value = "添加评论")
    @PostMapping("/activity/user/comment/add")
    public RespBean addAskGood(@RequestBody Comment comment){
        comment.setCreateTime(LocalDateTime.now());
        if (commentService.save(comment)) { return RespBean.success("添加评论成功"); }
        return RespBean.error("添加评论失败");
    }

}

