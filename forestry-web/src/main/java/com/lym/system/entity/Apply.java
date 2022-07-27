package com.lym.system.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author lym
 * @since 2021-10-25
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false,of="subject")
@TableName("t_apply")
@ApiModel(value="Apply对象", description="")
public class Apply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "申请部门")
    @TableField("applyDep")
    private int applydep;

    @ApiModelProperty(value = "活动主题")
    @Excel(name="活动主题")
    @NonNull
    private String subject;

    @ApiModelProperty(value = "申请人")
    @TableField("applyPer")
    @Excel(name = "活动负责人")
    private String applyper;

    @ApiModelProperty(value = "联系电话")
    @TableField("telephone")
    private String telephone;

    @ApiModelProperty(value = "活动内容")
    private String content;

    @ApiModelProperty(value = "申请预约人数")
    @TableField("applyNum")
    private Integer applynum;

    @ApiModelProperty(value = "活动开始时间")
    @TableField("startTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/shanghai")
    private Date starttime;


    @ApiModelProperty(value = "报名结束时间")
    @TableField("endTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/shanghai")
    private Date endtime;

    @ApiModelProperty(value = "申请时间")
    @TableField("nowTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime nowtime;



    @ApiModelProperty(value = "活动地点")
    private String place;

    @ApiModelProperty(value = "申请状态")
    private Integer status;

    @ApiModelProperty(value = "审核理由")
    private String reason;

    @ApiModelProperty(value = "审核人")
    @TableField("checkName")
    private String checkname;

    @ApiModelProperty(value = "活动图片")
    private String picture;
}
