package com.lym.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.Admin;
import com.lym.system.entity.Plant;
import com.lym.system.entity.RespPageBean;
import com.lym.system.mapper.PlantMapper;
import com.lym.system.service.PlantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lym
 * @since 2021-11-13
 */
@Service
public class PlantServiceImpl extends ServiceImpl<PlantMapper, Plant> implements PlantService {
    @Autowired
    private PlantMapper plantMapper;
    /**
     * 根据条件进行分页查询
     * @param
     * @param size
     * @param
     * @return @RequestBody UserVo userVo
     */
    @Override
    public RespPageBean getAdminByPage(Integer currentPage, Integer size, Plant plant) {
        Page<Plant> page = new Page<>(currentPage,size);
        IPage<Plant> adminByPage = plantMapper.getAdminByPage(page, plant);
        RespPageBean respPageBean = new RespPageBean(adminByPage.getTotal(), adminByPage.getRecords());
        return respPageBean;
    }
}
