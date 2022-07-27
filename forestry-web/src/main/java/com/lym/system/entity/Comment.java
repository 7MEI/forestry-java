package com.lym.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lym
 * @since 2021-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_comment")
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    @TableField("admin_name")
    @ApiModelProperty(value = "用户名")
    private String adminName;

    @ApiModelProperty(value = "评论")
    private String content;

    @TableField("create_time")
    @ApiModelProperty(value = "发布时间")
    private LocalDateTime createTime;

    @TableField("comment_like")
    @ApiModelProperty(value = "点赞的数量")
    private Integer commentLike;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @TableField("apply_id")
    private Integer applyId;
    //在数据库表中没有的字段
    @ApiModelProperty(value = "子回复")
    @TableField(exist = false)
    private List<Reply> childReplies;

}
