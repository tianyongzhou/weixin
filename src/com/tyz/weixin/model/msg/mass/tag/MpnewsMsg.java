package com.tyz.weixin.model.msg.mass.tag;

import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.Mpnews;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 发送 图文消息
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class MpnewsMsg extends TagMsg{
    private Mpnews mpnews;

    public MpnewsMsg(){
        super.setMsgtype(MsgType.MPNEWS);
    }

    public Mpnews getMpnews() {
        return mpnews;
    }

    public void setMpnews(Mpnews mpnews) {
        this.mpnews = mpnews;
    }
}
