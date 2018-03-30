package com.tyz.weixin.model.msg.upload;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 上传 视频
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class Video {
    private String media_id;
    private String title;
    private String description;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
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
