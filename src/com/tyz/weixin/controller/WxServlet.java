package com.tyz.weixin.controller;

import com.qq.weixin.mp.aes.AesException;
import com.tyz.weixin.WxAdapter;
import com.tyz.weixin.exception.WxException;
import com.tyz.weixin.model.event.Event;
import com.tyz.weixin.model.menu.MenuHandler;
import com.tyz.weixin.model.msg.Msg;
import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.utils.LogUtils;
import com.tyz.weixin.utils.WxUtils;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 微信通信API入口
 * @Date: 2017/12/19.
 * @Modified: tyz
 */
public class WxServlet extends HttpServlet {

    private WxAdapter mWxAdapter;

    @Override
    public void init() throws ServletException {
        super.init();
        //实例化一个WxAdapter单例对象
        Class<?> clz = null;
        try{
            clz = Class.forName(WxUtils.WX_ADAPTER_CLASSNAME);
            mWxAdapter = (WxAdapter) clz.newInstance();
            LogUtils.debug("WxAdapter instance finished：" + mWxAdapter);
        }catch(Exception e){
            throw new WxException("WxAdapter实现类配置有误-->weixin.properties:wxAdapterPath");
        }
    }

    /**
     * @Author: tyz
     * @Description:  验证微信共众号接口
     * @Date 16:43 2017/12/19
     * @return
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 验证公众号
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        LogUtils.log("signature:" + signature+"timestamp:" + timestamp+"nonce:" + nonce+"echostr:" + echostr);
        String[] array = {WxUtils.WX_TOKEN, timestamp, nonce};
        Arrays.sort(array);
        String str = "";
        for (int i = 0; i < array.length; i++){
            str += array[i];
        }
        LogUtils.debug("str:" + str);
        String sign = DigestUtils.shaHex(str);
        LogUtils.debug("sign:" + sign);
        if (signature.equals(sign)) {
            resp.getWriter().print(echostr);
            resp.getWriter().close();
        }

        if(mWxAdapter.isAutoCreateMenu()){
            //创建菜单
           String result = MenuHandler.createMenu(mWxAdapter.initMenu());
           LogUtils.log("自定义菜单:" + result);
        }
    }

    /**
     * @Author: tyz
     * @Description: 与微信通信的入口
     * @Date 17:18 2017/12/20
     * @return
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String xmlStr = WxUtils.xmlInputStream2Str(req.getInputStream());
        try {
            req.getInputStream().close();
        } catch (IOException e) {
        }
        if (WxUtils.IS_SAFE_MODE) {
            // 以下四个参数任何模式都可以收到
            //String signature = request.getParameter("signature");
            String timestamp = req.getParameter("timestamp");
            String nonce = req.getParameter("nonce");
            //String openid = request.getParameter("openid");
            // 以下两个参数只有在安全模式可以收到
            //String encrypt_type = request.getParameter("encrypt_type");
            String msg_signature = req.getParameter("msg_signature");
            // 开始解密
            try {
                xmlStr = WxUtils.decryptMsg(WxUtils.WX_TOKEN, WxUtils.AES_KEY, WxUtils.APP_ID, msg_signature,
                        timestamp, nonce, xmlStr);
            } catch (AesException e) {
                e.printStackTrace();
            }
        }
        Msg msg = WxUtils.xml2Obj(Msg.class, xmlStr);

        switch (msg.getMsgType()){
            case MsgType.EVENT:
                Event event = WxUtils.xml2Obj(Event.class, xmlStr);
                mWxAdapter.receiveEvent(event, xmlStr, req, resp, getServletContext());
                break;
            default:
                mWxAdapter.receiveMsg(WxUtils.xml2Obj(Msg.class, xmlStr), xmlStr, req, resp, getServletContext());
                break;
        }
        LogUtils.debug(xmlStr);
        resp.getWriter().print("ok");
        resp.getWriter().close();
    }
}
