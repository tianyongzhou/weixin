package com.tyz.weixin.model.msg.mass.tag;

import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.WxCard;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 发送 卡券消息
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class WxCardMsg extends TagMsg{
    private WxCard wxcard;

    public WxCardMsg(){
        super.setMsgtype(MsgType.WXCARD);
    }

    public WxCard getWxcard() {
        return wxcard;
    }

    public void setWxcard(WxCard wxcard) {
        this.wxcard = wxcard;
    }
}
