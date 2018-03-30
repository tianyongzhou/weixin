package com.tyz.weixin.model.msg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 消息的返回状态
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class ResultMsgStatus {
    private long msg_id;
    private String msg_status;

    public long getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(long msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_status() {
        return msg_status;
    }

    public void setMsg_status(String msg_status) {
        this.msg_status = msg_status;
    }
}
