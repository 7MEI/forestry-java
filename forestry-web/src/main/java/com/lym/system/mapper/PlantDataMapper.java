package com.lym.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.PlantData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-11-16
 */
public interface PlantDataMapper extends BaseMapper<PlantData> {

    IPage<PlantData> getDateByPage(Page<PlantData> page, @Param("plantData") PlantData plantData);

    List<PlantData> getOrderList(@Param("id") Integer id);
}
