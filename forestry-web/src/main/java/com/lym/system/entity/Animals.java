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
 * @since 2021-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_animals")
@ApiModel(value="Animals对象", description="")
public class Animals implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "种类id")
    @TableField("aniSortId")
    private Integer anisortid;

    @ApiModelProperty(value = "中文名")
    @Excel(name="动物名称")
    @TableField("ChineseName")
    private String chinesename;

    @ApiModelProperty(value = "外文名")
    @TableField("ForeignName")
    private String foreignname;

    @ApiModelProperty(value = "简要")
    private String jianjie;

    @ApiModelProperty(value = "体长")
    private Double length;

    @ApiModelProperty(value = "体重")
    private Double weight;

    @ApiModelProperty(value = "身高")
    private Double height;

    @ApiModelProperty(value = "食性")
    private String feeding;

    @ApiModelProperty(value = "繁殖")
    private String breed;

    @ApiModelProperty(value = "习性")
    private String habit;

    @ApiModelProperty(value = "二维码")
    private String qr;

    @ApiModelProperty(value = "地区")
    @Excel(name="地区")
    private String location;

    @ApiModelProperty(value = "生态习性")
    @TableField("ecoHabit")
    private String ecohabit;

    @ApiModelProperty(value = "特征")
    private String feature;

    @ApiModelProperty(value = "地理分布")
    private String distribution;

    @ApiModelProperty(value = "照片")
    private String picture;

    @ApiModelProperty(value = "负责人")
    private Integer mainper;

    @ApiModelProperty(value = "")
    @TableField(exist = false)
    private AnimalSort sort;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty("数量")
    private Integer number;

    @TableField(exist = false)
    private Employee employee;
}
