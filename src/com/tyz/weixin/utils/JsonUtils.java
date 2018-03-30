package com.tyz.weixin.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description:
 * @Date: 2017/12/19.
 * @Modified: tyz
 */
public class JsonUtils {
    private JsonUtils(){}


    public static String obj2Str(Object obj){
        try {
            JSONObject json = JSONObject.fromObject(obj);
            return json.toString();
        }catch (Exception e){}
        return "";
    }

    public static String objArr2Str(Object obj){
        try {
            JSONArray jsonArr = JSONArray.fromObject(obj);
            return jsonArr.toString();
        }catch (Exception e){}
        return "";
    }

    public static <T> T str2Obj(String str, Class<T> clz){
        try {
            JSONObject jsonObj =JSONObject.fromObject(str);
            return (T) JSONObject.toBean(jsonObj, clz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T json2Obj(JSONObject json, Class<T> clz){
        try {
            return (T) JSONObject.toBean(json, clz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> str2ObjArr(String str, Class<T> clz){
        try {
            JSONArray jsonArr =JSONArray.fromObject(str);
            return (List<T>) JSONArray.toArray(jsonArr, clz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> jsonArr2ObjArr(JSONArray jsonArr, Class<T> clz){
        try {
            return (List<T>) JSONArray.toArray(jsonArr, clz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
