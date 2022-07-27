package com.lym.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lym.system.entity.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lym
 * @since 2021-10-06
 */
public interface Admin2Service extends IService<Admin2> {
//    IPage<Admin2> findUserPage(Page<Admin2> page, QueryWrapper<Admin2> wrapper);
    /**
     * 根据条件进行分页查询
     * @param
     * @param size
     * @param
     * @return @RequestBody UserVo userVo
     */
    RespPageBean getAdminByPage(Integer currentPage, Integer size, Admin2 admin2);
}
