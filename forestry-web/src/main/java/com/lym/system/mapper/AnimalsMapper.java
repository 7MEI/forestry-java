package com.lym.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.Animals;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-11-19
 */
public interface AnimalsMapper extends BaseMapper<Animals> {

    IPage<Animals> getAnimalsByPage(Page<Animals> page, @Param("animals") Animals animals);
}
