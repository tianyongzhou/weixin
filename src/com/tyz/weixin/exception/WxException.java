package com.tyz.weixin.exception;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 微信异常
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class WxException extends RuntimeException{

    public WxException(String message){
        super(message);
    };
}
