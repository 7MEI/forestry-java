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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author lym
 * @since 2021-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_plant_data")
@ApiModel(value="PlantData对象", description="")
public class PlantData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "高度")
    @Excel(name = "高度")
    private Double height;

    @ApiModelProperty(value = "茎叶情况")
    @Excel(name = "茎叶情况")
    @TableField("stemLeaf")
    private String stemleaf;

    @ApiModelProperty(value = "温度")
    @Excel(name = "温度")
    private String temperature;

    @ApiModelProperty(value = "病虫情况")
    @Excel(name = "病虫情况")
    private String diseases;

    @ApiModelProperty(value = "植物状态")
    @Excel(name = "植物状态")
    private String status;

    @ApiModelProperty(value = "其他")
    @Excel(name = "其他")
    private String rests;

    @ApiModelProperty(value = "茎叶图片")
    @Excel(name = "茎叶图片")
    @TableField("stemPicture")
    private String stempicture;

    @ApiModelProperty(value = "病虫照片")
    @Excel(name = "病虫照片")
    @TableField("diseaPicture")
    private String diseapicture;

    @ApiModelProperty(value = "状态照片")
    @Excel(name = "状态照片")
    @TableField("statusPicture")
    private String statuspicture;

    @ApiModelProperty(value = "记录人")
    @Excel(name = "记录人")
    @TableField("writePer")
    private String writeper;

    @ApiModelProperty(value = "植物id")
    @TableField("plantId")
    private Integer plantid;

    @ApiModelProperty(value = "记录时间")
    @Excel(name = "记录时间")
    @TableField("writeTime")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/shanghai")
    private LocalDateTime writetime;

    @ApiModelProperty(value = "")
    @ExcelEntity(name="植物")
    @TableField(exist = false)
    private Plant plant;


}
