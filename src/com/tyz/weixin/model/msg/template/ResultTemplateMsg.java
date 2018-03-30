package com.tyz.weixin.model.msg.template;

import com.tyz.weixin.vo.ResultStatusMsg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 返回发送模板消息的状态
 * @Date: 2017/12/28.
 * @Modified: tyz
 */
public class ResultTemplateMsg extends ResultStatusMsg {
    private long msgid;

    public long getMsgid() {
        return msgid;
    }

    public void setMsgid(long msgid) {
        this.msgid = msgid;
    }
}
