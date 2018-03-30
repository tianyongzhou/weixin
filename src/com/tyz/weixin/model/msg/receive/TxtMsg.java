package com.tyz.weixin.model.msg.receive;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 文本消息
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class TxtMsg extends IdMsg {
    private String Content; //文本消息内容

    public TxtMsg() {
        super();
    }

    public TxtMsg(String toUserName, String fromUserName, long createTime, String msgType, String msgId, String content) {
        super(toUserName, fromUserName, createTime, msgType,msgId);
        Content = content;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}
