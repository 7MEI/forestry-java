package com.lym.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.Apply;
import com.lym.system.entity.Department;
import com.lym.system.entity.RespPageBean;
import com.lym.system.mapper.ApplyMapper;
import com.lym.system.service.ApplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lym
 * @since 2021-10-25
 */
@Service
public class ApplyServiceImpl extends ServiceImpl<ApplyMapper, Apply> implements ApplyService {
    @Autowired
    private ApplyMapper applyMapper;

    @Override
    public RespPageBean getByPage(Integer currentPage, Integer size, Apply apply) {
        //        开启分页
        Page<Apply> page = new Page<>(currentPage,size);
        IPage<Apply> Page = applyMapper.getApplyByPage(page, apply);
        RespPageBean respPageBean = new RespPageBean(Page.getTotal(), Page.getRecords());
        return respPageBean;
    }

    @Override
    public RespPageBean getUserByPage(Integer currentPage, Integer size, Apply apply) {
        //        开启分页
        Page<Apply> page = new Page<>(currentPage,size);
        IPage<Apply> Page = applyMapper.getUserByPage(page, apply);
        RespPageBean respPageBean = new RespPageBean(Page.getTotal(), Page.getRecords());
        return respPageBean;
    }
}
