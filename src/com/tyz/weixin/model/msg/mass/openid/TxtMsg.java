package com.tyz.weixin.model.msg.mass.openid;

import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.Txt;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 发送 文本消息
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class TxtMsg extends OpenIdMsg{
    private Txt text;

    public TxtMsg(){
        super.setMsgtype(MsgType.TEXT);
    }

    public Txt getText() {
        return text;
    }

    public void setText(Txt text) {
        this.text = text;
    }
}
