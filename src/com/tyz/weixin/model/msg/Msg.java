package com.tyz.weixin.model.msg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 回复消息基类
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class Msg {
    private String ToUserName; //开发者微信号
    private String FromUserName; //发送方帐号（一个OpenID）
    private long CreateTime; //消息创建时间 （整型）
    private String MsgType; //	消息类型，event

    public Msg() {
    }

    public Msg(String toUserName, String fromUserName, long createTime, String msgType) {
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}
