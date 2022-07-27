package com.lym.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
@TableName("t_reply")
@ApiModel(value="Reply对象", description="")
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "回复id")
    @TableId(value = "reply_id", type = IdType.AUTO)
    private Integer replyId;

    @TableField("reply_user_name")
    @ApiModelProperty(value = "用户名")
    private String replyUserName;

    @TableField("reply_content")
    @ApiModelProperty(value = "回复内容")
    private String replyContent;

    @TableField("reply_time")
    @ApiModelProperty(value = "回复时间")
    private Date replyTime;

    @TableField("reply_num")
    @ApiModelProperty(value = "回复的数量")
    private Integer replyNum;

    @TableField("reply_like")
    @ApiModelProperty(value = "点赞的数量")
    private Integer replyLike;

    @TableField("reply_to_id")
    @ApiModelProperty(value = "回复的评论")
    private Integer replyToId;

    @TableField("reply_avatar")
    @ApiModelProperty(value = "头像")
    private String replyAvatar;


}
