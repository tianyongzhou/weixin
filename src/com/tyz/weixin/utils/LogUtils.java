package com.tyz.weixin.utils;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description:
 * @Date: 2017/12/19.
 * @Modified: tyz
 */
public class LogUtils {
    private static final boolean isDebug = true;

    public static void log(Object msg){
        System.out.println("-------------------------------------------------------");
        System.out.println(msg);
        System.out.println("=======================================================");
    }

    public static void debug(Object msg){
        if(isDebug){
            log(msg);
        }
    }
}
