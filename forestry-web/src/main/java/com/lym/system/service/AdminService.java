package com.lym.system.service;

import com.lym.system.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;

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
public interface AdminService extends IService<Admin> {
    RespBean UserLogin(String username, String password, String code, HttpServletRequest request);

    Admin getAdminByUserName(String username);
    /*
    跟据用户查询角色列表
     */
    List<Role> getRoles(Integer adminId);
    /*
   跟据用户查询员工信息
    */
    List<Employee> getEmployee(String CardId);


    List<Admin> getlist();

    RespPageBean getAdminByPage(Integer currentPage, Integer size, Admin admin);

    /*
    更新用户角色
     */
    RespBean updateAdminRole(Integer adminId, List<Integer> rids);

    /**
     * 聊天时获取所有用户操作员
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(String keywords);

    String getUserName(Integer id);
}
