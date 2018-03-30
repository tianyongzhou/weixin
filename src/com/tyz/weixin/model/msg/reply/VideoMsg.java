package com.tyz.weixin.model.msg.reply;
import com.tyz.weixin.model.msg.MsgType;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 回复视频消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class VideoMsg extends VoiceMsg{
    private String Title;//	视频消息的标题
    private String Description;//	视频消息的描述

    public VideoMsg() {
        this.setMsgType(MsgType.VIDEO);
    }

    public VideoMsg(String toUserName, String fromUserName, long createTime, String mediaId, String title, String description) {
        super(toUserName, fromUserName, createTime, mediaId);
        this.setMsgType(MsgType.VIDEO);
        Title = title;
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
