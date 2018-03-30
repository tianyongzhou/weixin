package com.tyz.weixin.model.msg.mass.openid;

import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.Voice;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 发送 语音/音频消息
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class VoiceMsg extends OpenIdMsg{
    private Voice voice;

    public VoiceMsg(){
        super.setMsgtype(MsgType.VOICE);
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }
}
