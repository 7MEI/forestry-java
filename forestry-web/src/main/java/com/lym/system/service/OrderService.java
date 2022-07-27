package com.lym.system.service;


import com.lym.system.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lym.system.entity.RespBean;
import com.lym.system.entity.RespPageBean;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lym
 * @since 2021-11-08
 */
public interface OrderService extends IService<Order> {

    RespPageBean getByPage(Integer currentPage, Integer size, Order order);


    /**
     * 导出员工表格
     * @param id
     */
    void getOrder(Integer id, HttpServletResponse response);


    /**
     * 获取员工添加所需要的各种id
     * @param
     * @return
     */
    Order getIdSelectNationByName(Map<String, String> orderMap);
    /**
     * 添加员工
     * @param
     */
    RespBean addEmp(Order order);
}
