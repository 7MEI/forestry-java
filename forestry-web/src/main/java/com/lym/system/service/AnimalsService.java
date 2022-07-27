package com.lym.system.service;

import com.lym.system.entity.Animals;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lym.system.entity.RespPageBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lym
 * @since 2021-11-19
 */
public interface AnimalsService extends IService<Animals> {

    RespPageBean getAnimalsByPage(Integer currentPage, Integer size, Animals animals);

}
