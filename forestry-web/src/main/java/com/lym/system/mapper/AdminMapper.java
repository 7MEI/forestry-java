package com.lym.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lym.system.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface AdminMapper extends BaseMapper<Admin> {

    List<Menu> getMenusByUserId(Integer id);

    List<Admin> getList();
    /**
     * 分页查询所有用户信息
     * @param
     * @return
     */
    IPage<Admin> getAdminByPage(Page<Admin> page, @Param("admin") Admin admin);

    /**
     * 聊天时获取所有用户
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);

    List<Admin> getInfo(@Param("username") String username);

    String getUserName(Integer id);
}
