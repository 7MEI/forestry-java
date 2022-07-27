package com.lym.system.service;

import com.lym.system.entity.Admin;
import com.lym.system.entity.Plant;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lym.system.entity.RespPageBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lym
 * @since 2021-11-13
 */
public interface PlantService extends IService<Plant> {
    /**
     * 根据条件进行分页查询
     * @param
     * @param size
     * @param
     * @return @RequestBody UserVo userVo
     */
    RespPageBean getAdminByPage(Integer currentPage, Integer size, Plant plant);
}
