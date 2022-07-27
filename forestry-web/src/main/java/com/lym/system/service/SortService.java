package com.lym.system.service;

import com.lym.system.entity.RespPageBean;
import com.lym.system.entity.Sort;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lym
 * @since 2021-11-13
 */
public interface SortService extends IService<Sort> {

    RespPageBean getAdminByPage(Integer currentPage, Integer size, Sort sort);
}
