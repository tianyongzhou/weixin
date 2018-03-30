package com.tyz.weixin.model.msg.kaf.send;

import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.Txt;
import com.tyz.weixin.model.msg.kaf.KafInfo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 文本消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class TxtMsg extends Msg{
    private Txt text; //文本对象

    public TxtMsg() {
        this.setMsgtype(MsgType.TEXT);
    }

    public TxtMsg(String touser, String msgtype, Txt text) {
        super(touser, msgtype);
        this.text = text;
        this.setMsgtype(MsgType.TEXT);
    }

    public TxtMsg(String touser, String msgtype, KafInfo customservice, Txt text) {
        super(touser, msgtype, customservice);
        this.text = text;
        this.setMsgtype(MsgType.TEXT);
    }

    public Txt getText() {
        return text;
    }

    public void setText(Txt text) {
        this.text = text;
    }
}
