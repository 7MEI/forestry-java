package com.lym.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.Animals;
import com.lym.system.entity.RespPageBean;
import com.lym.system.mapper.AnimalsMapper;
import com.lym.system.service.AnimalsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lym
 * @since 2021-11-19
 */
@Service
public class AnimalsServiceImpl extends ServiceImpl<AnimalsMapper, Animals> implements AnimalsService {
@Autowired
private AnimalsMapper animalsMapper;
    @Override
    public RespPageBean getAnimalsByPage(Integer currentPage, Integer size, Animals animals) {
        Page<Animals> page = new Page<>(currentPage,size);
        IPage<Animals> adminByPage = animalsMapper.getAnimalsByPage(page, animals);
        RespPageBean respPageBean = new RespPageBean(adminByPage.getTotal(), adminByPage.getRecords());
        return respPageBean;
    }
}
