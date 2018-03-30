package com.tyz.weixin.model.msg.receive;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 视频消息
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class VideoMsg extends IdMsg {
    private String ThumbMediaId; //	视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId; //视频消息媒体id，可以调用多媒体文件下载接口拉取数据。

    public VideoMsg() {
        super();
    }

    public VideoMsg(String toUserName, String fromUserName, long createTime, String msgType, String msgId, String thumbMediaId, String mediaId) {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        ThumbMediaId = thumbMediaId;
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
