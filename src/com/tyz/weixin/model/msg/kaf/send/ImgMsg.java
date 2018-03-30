package com.tyz.weixin.model.msg.kaf.send;

import com.tyz.weixin.model.msg.Img;
import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.kaf.KafInfo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 图片消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class ImgMsg extends Msg{
    private Img image;

    public ImgMsg() {
        this.setMsgtype(MsgType.IMAGE);
    }

    public ImgMsg(String touser, String msgtype, Img image) {
        super(touser, msgtype);
        this.image = image;
        this.setMsgtype(MsgType.IMAGE);
    }

    public ImgMsg(String touser, String msgtype, KafInfo customservice, Img image) {
        super(touser, msgtype, customservice);
        this.image = image;
        this.setMsgtype(MsgType.IMAGE);
    }

    public Img getImage() {
        return image;
    }

    public void setImage(Img image) {
        this.image = image;
    }
}
