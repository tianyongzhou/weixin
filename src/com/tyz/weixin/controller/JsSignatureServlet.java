package com.tyz.weixin.controller;

import com.tyz.weixin.utils.HttpUtil;
import com.tyz.weixin.utils.WxUtils;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 处理 JS签名
 * @Date: 2018/2/6.
 * @Modified: tyz
 */
public class JsSignatureServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject obj = HttpUtil.receiveJsonData(req);
        //noncestr timestamp url
        String noncestr = UUID.randomUUID().toString();
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);

        String sig = WxUtils.wjs_urlSha1Signature(noncestr, timestamp, obj.getString("url"));
        JSONObject result = new JSONObject();
        result.put("sig", sig);
        result.put("noncestr", noncestr);
        result.put("timestamp", timestamp);
        HttpUtil.responseJson(resp, result.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
