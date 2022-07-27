package com.lym.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.Apply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lym.system.entity.Department;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-10-25
 */
public interface ApplyMapper extends BaseMapper<Apply> {

    IPage<Apply> getApplyByPage(Page<Apply> page, @Param("apply") Apply apply);

    IPage<Apply> getUserByPage(Page<Apply> page, @Param("apply") Apply apply);
}
