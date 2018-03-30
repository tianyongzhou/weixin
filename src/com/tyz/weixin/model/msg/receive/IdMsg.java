package com.tyz.weixin.model.msg.receive;

import com.tyz.weixin.model.msg.Msg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: MsgId 消息
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class IdMsg extends Msg {
    private String MsgId; //消息id，64位整型

    public IdMsg() {
        super();
    }

    public IdMsg(String toUserName, String fromUserName, long createTime, String msgType,String msgId) {
        super(toUserName, fromUserName, createTime, msgType);
        MsgId = msgId;
    }
}
