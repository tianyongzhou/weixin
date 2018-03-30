package com.tyz.weixin.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description:
 * @Date: 2017/5/15.
 * @Modified: tyz
 */
public class HttpUtil {
    private HttpUtil(){}

    public static JSONObject receiveJsonData(HttpServletRequest request) {
        JSONObject json = null;
        //将json字符串转换为json对象
        String receiveStr = receiveStrData(request);
        if(null != receiveStr){
            json = JSONObject.fromObject(receiveStr);
        }
        return json;
    }

    public static JSONArray receiveJsonArrData(HttpServletRequest request) {
        JSONArray jsonArray = null;
        //将json字符串转换为json对象
        String receiveStr = receiveStrData(request);
        if(null != receiveStr){
            jsonArray = JSONArray.fromObject(receiveStr);
        }
        return jsonArray;
    }

    private  static String receiveStrData(HttpServletRequest request){
        BufferedReader br = null;
        InputStreamReader isReader = null;
        InputStream is = null;
        try {
            // 读取请求内容
            is = request.getInputStream();
            isReader = new InputStreamReader(is, "utf-8");
            br = new BufferedReader(isReader);
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            //将json字符串转换为json对象
            String result = sb.toString();
            return  result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(null != br){
                    br.close();
                }
                if(null != isReader){
                    isReader.close();
                }
                if(null != is){
                    is.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return  null;
    }

    public static String getIpAddr(HttpServletRequest request){
        if(request.getSession().getAttribute("sq_u_ip") != null){
            return request.getSession().getAttribute("sq_u_ip").toString();
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        request.getSession().setAttribute("sq_u_ip", ip);
        return ip;
    }

    public static void responseJson(HttpServletResponse response, String jsonStr) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(jsonStr.toString());
        if (out != null) {
            out.close();
        }
    }
}
