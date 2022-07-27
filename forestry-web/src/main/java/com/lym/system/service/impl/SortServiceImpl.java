package com.lym.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.RespPageBean;
import com.lym.system.entity.Sort;
import com.lym.system.mapper.SortMapper;
import com.lym.system.service.SortService;
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
public class SortServiceImpl extends ServiceImpl<SortMapper, Sort> implements SortService {
@Autowired
private SortMapper sortMapper;
    @Override
    public RespPageBean getAdminByPage(Integer currentPage, Integer size, Sort sort) {
        Page<Sort> page = new Page<>(currentPage,size);
        IPage<Sort> adminByPage = sortMapper.getAdminByPage(page, sort);
        RespPageBean respPageBean = new RespPageBean(adminByPage.getTotal(), adminByPage.getRecords());
        return respPageBean;
    }
}
