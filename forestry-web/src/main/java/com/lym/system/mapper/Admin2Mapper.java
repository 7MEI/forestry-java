package com.lym.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.Admin;
import com.lym.system.entity.Admin2;
import com.lym.system.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-10-06
 */
public interface Admin2Mapper extends BaseMapper<Admin2> {
//    IPage<Admin2> findUserPage(Page<Admin2> page, @Param(Constants.WRAPPER) QueryWrapper<Admin2> wrapper);

    IPage<Admin2> getAdminByPage(Page<Admin2> page, @Param("admin2") Admin2 admin2);
}
