package com.lym.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_animal_sort")
@ApiModel(value="AnimalSort对象", description="")
public class AnimalSort implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "中文名")
    @TableField("ChineseName")
    private String chinesename;

    @ApiModelProperty(value = "视频")
    private String video;

    @ApiModelProperty(value = "简介")
    private String introduce;

    @ApiModelProperty(value = "外文名")
    @TableField("ForeignName")
    private String foreignname;

    @ApiModelProperty(value = "含义")
    private String hanyi;

    @ApiModelProperty(value = "特点")
    private String characteristic;

    @ApiModelProperty(value = "简介图片")
    @TableField("introPicture")
    private String intropicture;

    @ApiModelProperty(value = "发展历史")
    private String history;

    @ApiModelProperty(value = "历史图片")
    @TableField("hisPicture")
    private String hispicture;


}
