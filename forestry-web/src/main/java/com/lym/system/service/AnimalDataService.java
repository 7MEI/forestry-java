package com.lym.system.service;

import com.lym.system.entity.AnimalData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lym.system.entity.RespPageBean;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lym
 * @since 2021-11-21
 */
public interface AnimalDataService extends IService<AnimalData> {

    /**
     * 分页获取动物历史信息
     * @param currentPage
     * @param size
     * @param animalData
     * @return
     */
    RespPageBean getAnimalsByPage(Integer currentPage, Integer size, AnimalData animalData);

    void getOrder(Integer id, HttpServletResponse response);
}
