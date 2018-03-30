package com.tyz.weixin.model.msg.receive;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 图片消息
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class VoiceMsg extends IdMsg {
    private String Format; //语音格式，如amr，speex等
    private String MediaId; //语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String Recognition; //语音识别结果，UTF8编码

    public VoiceMsg() {
        super();
    }

    public VoiceMsg(String toUserName, String fromUserName, long createTime, String msgType, String msgId, String format, String mediaId, String recognition) {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        Format = format;
        MediaId = mediaId;
        Recognition = recognition;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }
}
