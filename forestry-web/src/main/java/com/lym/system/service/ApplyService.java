package com.lym.system.service;

import com.lym.system.entity.Apply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lym.system.entity.RespPageBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lym
 * @since 2021-10-25
 */
public interface ApplyService extends IService<Apply> {

    RespPageBean getByPage(Integer currentPage, Integer size, Apply apply);

    RespPageBean getUserByPage(Integer currentPage, Integer size, Apply apply);
}
