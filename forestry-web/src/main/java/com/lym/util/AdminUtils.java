package com.lym.util;


import com.lym.system.entity.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @program: yeb
 * @description: 用户工具类
 * @author: Honors
 * @create: 2021-07-19 16:06
 */
public class AdminUtils {

    /**
     * 获取当前登录用户
     * @return
     */
    public static Admin getCurrentAdmin(){
        return (Admin)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}