package com.tyz.weixin.model.msg.reply;
import com.tyz.weixin.model.msg.MsgType;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 回复音乐消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class MusicMsg extends VideoMsg{
    private String MusicURL;//	音乐链接
    private String HQMusicUrl;//	高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String ThumbMediaId;//	缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id

    public MusicMsg() {
        this.setMsgType(MsgType.MUSIC);
    }

    public MusicMsg(String toUserName, String fromUserName, long createTime, String mediaId, String title, String description, String musicURL, String HQMusicUrl, String thumbMediaId) {
        super(toUserName, fromUserName, createTime, mediaId, title, description);
        this.setMsgType(MsgType.MUSIC);
        MusicURL = musicURL;
        this.HQMusicUrl = HQMusicUrl;
        ThumbMediaId = thumbMediaId;
    }

    public String getMusicURL() {
        return MusicURL;
    }

    public void setMusicURL(String musicURL) {
        MusicURL = musicURL;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
