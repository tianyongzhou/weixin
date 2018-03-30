package com.tyz.weixin.model.msg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 视频实体
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class Video extends Voice {
    private String thumb_media_id; //缩略图/小程序卡片图片的媒体ID，小程序卡片图片建议大小为520*416
    private String title; //图文消息/视频消息/音乐消息/小程序卡片的标题
    private String description; //图文消息/视频消息/音乐消息的描述

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
