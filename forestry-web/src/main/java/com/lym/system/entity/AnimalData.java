package com.lym.system.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @since 2021-11-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_animal_data")
@ApiModel(value="AnimalData对象", description="")
public class AnimalData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "繁殖情况")
    @TableField("BreedSituation")
    @Excel(name = "繁殖情况")
    private String breedsituation;

    @ApiModelProperty(value = "记录人")
    @TableField("writePer")
    @Excel(name = "繁殖情况")
    private String writeper;

    @ApiModelProperty(value = "记录时间")
    @TableField("writeTime")
    @Excel(name = "繁殖情况")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/shanghai")
    private LocalDateTime writetime;

    @ApiModelProperty(value = "健康情况")
    @Excel(name = "繁殖情况")
    private String health;

    @ApiModelProperty(value = "体长")
    @Excel(name = "繁殖情况")
    @TableField("lengthData")
    private Double lengthdata;

    @ApiModelProperty(value = "体重")
    @Excel(name = "繁殖情况")
    @TableField("weigthData")
    private Double weigthdata;

    @ApiModelProperty(value = "身高")
    @Excel(name = "繁殖情况")
    private Double height;

    @ApiModelProperty(value = "生长状态")
    @Excel(name = "繁殖情况")
    @TableField("growData")
    private String growdata;

    @ApiModelProperty(value = "图片")
    @Excel(name = "繁殖情况")
    @TableField("pictureData")
    private String picturedata;

    @ApiModelProperty(value = "其他")
    @Excel(name = "繁殖情况")
    private String reset;

    @ApiModelProperty(value = "动物Id")
    @TableField("animalId")
    private Integer animalid;

    @TableField(exist = false)
    @ExcelEntity(name="动物")
    private Animals animals;


}
