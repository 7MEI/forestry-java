package com.lym.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/*
分页公共返回对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespPageBean {
    private Long total;
    private List<?> data;



}
