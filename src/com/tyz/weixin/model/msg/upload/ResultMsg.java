package com.tyz.weixin.model.msg.upload;

import com.tyz.weixin.vo.ResultStatusMsg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 返回 上传结果信息
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class ResultMsg extends ResultStatusMsg{
    private String type; //媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息（news）
    private String media_id;//媒体文件/图文消息上传后获取的唯一标识
    private long created_at;//	媒体文件上传时间

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }
}
