package com.tyz.weixin.model.msg.kaf.send;

import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.Video;
import com.tyz.weixin.model.msg.kaf.KafInfo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 视频消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class VideoMsg extends Msg{
    private Video video;

    public VideoMsg() {
        this.setMsgtype(MsgType.VIDEO);
    }

    public VideoMsg(String touser, String msgtype, Video video) {
        super(touser, msgtype);
        this.video = video;
        this.setMsgtype(MsgType.VIDEO);
    }

    public VideoMsg(String touser, String msgtype, KafInfo customservice, Video video) {
        super(touser, msgtype, customservice);
        this.video = video;
        this.setMsgtype(MsgType.VIDEO);
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
