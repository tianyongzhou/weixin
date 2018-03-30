package com.tyz.weixin.model.msg.kaf.send;

import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.WxCard;
import com.tyz.weixin.model.msg.kaf.KafInfo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 卡券消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class WxCardMsg extends Msg{
    private WxCard wxcard;

    public WxCardMsg() {
        this.setMsgtype(MsgType.IMAGE);
    }

    public WxCardMsg(String touser, String msgtype, WxCard wxcard) {
        super(touser, msgtype);
        this.wxcard = wxcard;
        this.setMsgtype(MsgType.IMAGE);
    }

    public WxCardMsg(String touser, String msgtype, KafInfo customservice, WxCard wxcard) {
        super(touser, msgtype, customservice);
        this.wxcard = wxcard;
        this.setMsgtype(MsgType.IMAGE);
    }

    public WxCard getWxcard() {
        return wxcard;
    }

    public void setWxcard(WxCard wxcard) {
        this.wxcard = wxcard;
    }
}
