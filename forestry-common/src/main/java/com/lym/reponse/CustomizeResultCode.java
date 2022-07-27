package com.lym.reponse;

public interface CustomizeResultCode {
//获取错误状态码
    Integer getCode();

    /**
     * 获取错误信息
     * @return
     */
    String getMessage();
}
