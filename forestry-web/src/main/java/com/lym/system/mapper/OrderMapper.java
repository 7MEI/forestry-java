package com.lym.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lym
 * @since 2021-11-08
 */
public interface OrderMapper extends BaseMapper<Order> {

    IPage<Order> getByPage(Page<Order> page, @Param("order") Order order);

    List<Order> getOrderList(@Param("id") Integer id);


    Order getIdSelectNationByName(Map<String, String> orderMap);
}
