package com.lym.system.service;

import com.lym.system.entity.PlantData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lym.system.entity.RespPageBean;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lym
 * @since 2021-11-16
 */
public interface PlantDataService extends IService<PlantData> {

    RespPageBean getDateByPage(Integer currentPage, Integer size, PlantData plantData);

    void getOrder(Integer id, HttpServletResponse response);
}
