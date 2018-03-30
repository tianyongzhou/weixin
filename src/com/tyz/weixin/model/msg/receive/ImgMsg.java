package com.tyz.weixin.model.msg.receive;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 图片消息
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class ImgMsg extends IdMsg {
    private String PicUrl; //图片链接（由系统生成）
    private String MediaId; //图片消息媒体id，可以调用多媒体文件下载接口拉取数据。

    public ImgMsg() {
        super();
    }

    public ImgMsg(String toUserName, String fromUserName, long createTime, String msgType, String msgId, String picUrl, String mediaId) {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        PicUrl = picUrl;
        MediaId = mediaId;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
