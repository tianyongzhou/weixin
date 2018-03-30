package com.tyz.weixin.model.event;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 模版消息发送任务事件
 * @Date: 2017/12/28.
 * @Modified: tyz
 */
public class TemplateSendEndJobFinishEvent extends Event{

    public static final String STATUS_SUCCESS = "success";
    public static final String STATUS_FAILURE_USER_BLOCK = "failed:user block";
    public static final String STATUS_FAILURE_SYSTEM = "failed: system failed";

    private long MsgID; //	消息id
    private String Status; //	发送状态为成功

    public long getMsgID() {
        return MsgID;
    }

    public void setMsgID(long msgID) {
        MsgID = msgID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
