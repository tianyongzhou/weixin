package com.tyz.weixin.model.msg.kaf.send;

import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.Music;
import com.tyz.weixin.model.msg.kaf.KafInfo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 音乐消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class MusicMsg extends Msg{
    private Music music;

    public MusicMsg() {
        this.setMsgtype(MsgType.MUSIC);
    }

    public MusicMsg(String touser, String msgtype, Music music) {
        super(touser, msgtype);
        this.music = music;
        this.setMsgtype(MsgType.MUSIC);
    }

    public MusicMsg(String touser, String msgtype, KafInfo customservice, Music music) {
        super(touser, msgtype, customservice);
        this.music = music;
        this.setMsgtype(MsgType.MUSIC);
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
