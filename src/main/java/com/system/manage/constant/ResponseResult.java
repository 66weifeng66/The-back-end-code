package com.system.manage.constant;

import lombok.Data;

/**
 * @author Created by lq
 * @version jdk1.8
 * @description 请求返回结果
 * @date 2021/4/12 20:51
 */
@Data
public class ResponseResult<T> {
    /**
     * 响应码
     */
    private Integer code;
    /**
     * 相应消息
     */
    private String msg;
    /**
     * 相应结果
     */
    private T data;


    /**
     * 请求操作成功
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> HANDLE_SUCCESS() {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(200000);
        responseResult.setMsg("请求操作成功");
        return responseResult;
    }

    /**
     * 请求操作成功  带返回值
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> HANDLE_SUCCESS(T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(200000);
        responseResult.setMsg("请求操作成功");
        responseResult.setData(data);
        return responseResult;
    }

    /**
     * 请求操作成功  带返回值  layui返回的固定格式
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> LAYUI_HANDLE_SUCCESS(T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(0);
        responseResult.setMsg("请求操作成功");
        responseResult.setData(data);
        return responseResult;
    }

    /**
     * 登录认证失败
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> LOGIN_AUTH_FAILED() {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(500001);
        responseResult.setMsg("登录认证失败");
        return responseResult;
    }


    /**
     * 处理数据异常
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> HANDLE_FAILED() {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(500002);
        responseResult.setMsg("处理数据异常");
        return responseResult;
    }

}
