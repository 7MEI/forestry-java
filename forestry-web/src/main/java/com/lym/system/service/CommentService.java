package com.lym.system.service;

import com.lym.system.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lym
 * @since 2021-12-02
 */
public interface CommentService extends IService<Comment> {

    List<Comment> getAllComment();
}
