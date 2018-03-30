package com.tyz.weixin.utils;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description:
 * @Date: 2017/5/18.
 * @Modified: tyz
 */
public class StrUtil {

    private StrUtil(){}

    /**
     * @Author: tyz
     * @Description: 判断字符串是否为空
     * @param str
     * @Date 8:55 2017/5/18
     * @return
     */
    public static boolean isEmpty(String str){
        if(str==null || "".equals(str.trim())){
            return  true;
        }
        return false;
    }

    /**
     * @Author: tyz
     * @Description: 去掉字符串的空格
     * @param str
     * @Date 9:00 2017/5/18
     * @return
     */
    public static String removeStrEmpty(String str){
        if(StrUtil.isEmpty(str)){
            return  "";
        }
        return  str.trim();
    }
}
