package com.lym.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.Sort;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-11-13
 */
public interface SortMapper extends BaseMapper<Sort> {

    IPage<Sort> getAdminByPage(Page<Sort> page,@Param("sort") Sort sort);
}
