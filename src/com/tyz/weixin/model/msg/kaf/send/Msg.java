package com.tyz.weixin.model.msg.kaf.send;

import com.tyz.weixin.model.msg.kaf.KafInfo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 客服发送消息基本
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public abstract class Msg {
    private String touser; //普通用户openid
    /**
     *  	消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，
     *  	图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）
     *  	为mpnews，卡券为wxcard，小程序为miniprogrampage
     */
    private String msgtype;
    private KafInfo customservice; //客服信息 可以为空

    public Msg(String touser, String msgtype) {
        this.touser = touser;
        this.msgtype = msgtype;
        this.customservice = customservice;
    }

    public Msg(){}

    public Msg(String touser, String msgtype, KafInfo customservice) {
        this.touser = touser;
        this.msgtype = msgtype;
        this.customservice = customservice;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public KafInfo getCustomservice() {
        return customservice;
    }

    public void setCustomservice(KafInfo customservice) {
        this.customservice = customservice;
    }
}
