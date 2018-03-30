package com.tyz.weixin.model.msg.reply;
import com.tyz.weixin.model.msg.MsgType;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 回复语音消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class VoiceMsg extends ImgMsg {

    public VoiceMsg() {
        this.setMsgType(MsgType.VOICE);
    }

    public VoiceMsg(String toUserName, String fromUserName, long createTime, String mediaId) {
        super(toUserName, fromUserName, createTime, mediaId);
        this.setMsgType(MsgType.VOICE);
    }
}
