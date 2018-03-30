package com.tyz.weixin.model.msg.reply;
import com.tyz.weixin.model.msg.MsgType;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 回复图片消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class ImgMsg extends ReplyMsg {
    private String MediaId; //	通过素材管理中的接口上传多媒体文件，得到的id。

    public ImgMsg() {
        this.setMsgType(MsgType.IMAGE);
    }

    public ImgMsg(String toUserName, String fromUserName, long createTime, String mediaId) {
        super(toUserName, fromUserName, createTime, MsgType.IMAGE);
        MediaId = mediaId;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
