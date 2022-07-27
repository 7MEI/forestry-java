package com.lym.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.AnimalData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lym.system.entity.Animals;
import com.lym.system.entity.PlantData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-11-21
 */
public interface AnimalDataMapper extends BaseMapper<AnimalData> {

    IPage<Animals> getAnimalsByPage(Page<Animals> page,@Param("animalData") AnimalData animalData);
    List<AnimalData> getOrderList(@Param("id") Integer id);
}
