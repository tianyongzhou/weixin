package com.tyz.weixin.model.msg.mass.openid;

import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.Voice;
import com.tyz.weixin.model.msg.upload.ResultMsg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 发送 语音/音频消息
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class MpVideoMsg extends OpenIdMsg{
    private Voice mpvideo;

    //要求 通过上传视频之后的返回MediaId
    public MpVideoMsg(ResultMsg resultMsg){
        super.setMsgtype(MsgType.MPVIDEO);
        this.mpvideo = new Voice();
        this.mpvideo.setMedia_id(resultMsg.getMedia_id());
    }

    public Voice getMpvideo() {
        return mpvideo;
    }

    public void setMpvideo(Voice mpvideo) {
        this.mpvideo = mpvideo;
    }
}
