package com.tyz.weixin.model.msg.mass.openid;

import com.tyz.weixin.model.msg.Img;
import com.tyz.weixin.model.msg.MsgType;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 发送 图片消息
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class ImgMsg extends OpenIdMsg{
    private Img image;

    public ImgMsg(){
        super.setMsgtype(MsgType.IMAGE);
    }

    public Img getImage() {
        return image;
    }

    public void setImage(Img image) {
        this.image = image;
    }
}
