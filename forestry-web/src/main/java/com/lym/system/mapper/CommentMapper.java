package com.lym.system.mapper;

import com.lym.system.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-12-02
 */
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> getAllComment();
}
