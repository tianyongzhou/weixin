package com.tyz.weixin.model.msg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 图片实体
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class Img {
    private String media_id; //发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }
}
