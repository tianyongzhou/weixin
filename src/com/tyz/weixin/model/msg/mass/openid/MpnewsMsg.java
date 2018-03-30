package com.tyz.weixin.model.msg.mass.openid;

import com.tyz.weixin.model.msg.Mpnews;
import com.tyz.weixin.model.msg.MsgType;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description:
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class MpnewsMsg extends OpenIdMsg{
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
