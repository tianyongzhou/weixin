package com.tyz.weixin.model.msg.reply;

import com.tyz.weixin.model.msg.Msg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description:  发送消息的基类
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public abstract class ReplyMsg extends Msg{
    public ReplyMsg() {
    }
    public ReplyMsg(String toUserName, String fromUserName, long createTime, String msgType) {
        super(toUserName, fromUserName, createTime, msgType);
    }
}
