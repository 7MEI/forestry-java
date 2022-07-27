package com.lym.system.service.impl;

import com.lym.system.entity.Comment;
import com.lym.system.mapper.CommentMapper;
import com.lym.system.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lym
 * @since 2021-12-02
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getAllComment() {
        return commentMapper.getAllComment();
    }
}
