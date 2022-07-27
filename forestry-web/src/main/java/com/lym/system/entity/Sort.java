package com.lym.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2021-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sort")
@ApiModel(value="Sort对象", description="")
public class Sort implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String sort;

    @ApiModelProperty("植物信息")
    @TableField(exist = false)
    private Plant plant;


}
