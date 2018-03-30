package com.tyz.weixin.model.msg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 音乐实体
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class Music extends Video {
    private String musicurl; //音乐链接
    private String hqmusicurl; //高品质音乐链接，wifi环境优先使用该链接播放音乐

    public String getMusicurl() {
        return musicurl;
    }

    public void setMusicurl(String musicurl) {
        this.musicurl = musicurl;
    }

    public String getHqmusicurl() {
        return hqmusicurl;
    }

    public void setHqmusicurl(String hqmusicurl) {
        this.hqmusicurl = hqmusicurl;
    }
}
