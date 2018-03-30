package com.tyz.weixin.model.msg.kaf.send;

import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.Voice;
import com.tyz.weixin.model.msg.kaf.KafInfo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 语音消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class VoiceMsg extends Msg{
    private Voice voice;

    public VoiceMsg() {
        this.setMsgtype(MsgType.VOICE);
    }

    public VoiceMsg(String touser, String msgtype, Voice voice) {
        super(touser, msgtype);
        this.voice = voice;
        this.setMsgtype(MsgType.VOICE);
    }

    public VoiceMsg(String touser, String msgtype, KafInfo customservice, Voice voice) {
        super(touser, msgtype, customservice);
        this.voice = voice;
        this.setMsgtype(MsgType.VOICE);
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }
}
