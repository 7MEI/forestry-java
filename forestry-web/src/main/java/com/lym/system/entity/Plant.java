package com.lym.system.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
 * @since 2021-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_plant")
@ApiModel(value="Plant对象", description="")
public class Plant implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "植物名称")
    @Excel(name="植物名称")
    @TableField("plantName")
    private String plantname;

    @ApiModelProperty(value = "负责人")
    @TableField("mainper")
    private Integer mainper;

    @ApiModelProperty(value = "种类")
    @TableField("plantSort")
    private Integer plantsort;

    @ApiModelProperty(value = "数量")
    @TableField("plantNumber")
    private Integer plantnumber;

    @ApiModelProperty(value = "植物形态")
    @TableField("plantIntroduce")
    private String plantintroduce;

    @ApiModelProperty(value = "图片")
    @TableField("plantPicture")
    private String plantpicture;

    @ApiModelProperty(value = "等级")
    @TableField("plantGrade")
    private String plantgrade;

    @ApiModelProperty(value = "植物价值")
    @TableField("plantValue")
    private String plantvalue;

    @ApiModelProperty(value = "二维码图片")
    @TableField("plantQr")
    private String plantqr;

    @ApiModelProperty(value = "保护措施")
    private String measure;

    @ApiModelProperty(value = "位置")
    private String location;

    @ApiModelProperty(value = "种类")
    @TableField(exist = false)
    private Sort sort;

    @TableField(exist = false)
    private Employee employee;

}
