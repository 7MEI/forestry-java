package com.lym.system.mapper;

import com.lym.system.entity.Menu_Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-10-09
 */
public interface Menu_RoleMapper extends BaseMapper<Menu_Role> {

    Integer batchInset(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
