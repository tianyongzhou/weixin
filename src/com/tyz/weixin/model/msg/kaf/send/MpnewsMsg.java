package com.tyz.weixin.model.msg.kaf.send;

import com.tyz.weixin.model.msg.Mpnews;
import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.kaf.KafInfo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 图文消息(点击跳转到图文消息页面)
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class MpnewsMsg extends Msg{
    private Mpnews mpnews;

    public MpnewsMsg() {
        this.setMsgtype(MsgType.MPNEWS);
    }

    public MpnewsMsg(String touser, String msgtype, Mpnews mpnews) {
        super(touser, msgtype);
        this.mpnews = mpnews;
        this.setMsgtype(MsgType.MPNEWS);
    }

    public MpnewsMsg(String touser, String msgtype, KafInfo customservice, Mpnews mpnews) {
        super(touser, msgtype, customservice);
        this.mpnews = mpnews;
        this.setMsgtype(MsgType.MPNEWS);
    }

    public Mpnews getMpnews() {
        return mpnews;
    }

    public void setMpnews(Mpnews mpnews) {
        this.mpnews = mpnews;
    }
}
