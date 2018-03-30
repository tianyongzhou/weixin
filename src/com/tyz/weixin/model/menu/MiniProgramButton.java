package com.tyz.weixin.model.menu;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 小程序按钮
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class MiniProgramButton extends TypeButton {
    private String url;
    private String appid; //小程序的appid（仅认证公众号可配置）
    private String pagepath; //小程序的页面路径

    public MiniProgramButton(String url, String appid, String pagepath) {
        this(null, url, appid, pagepath);
    }

    public MiniProgramButton(String name, String url, String appid, String pagepath) {
        super("miniprogram", name);
        this.url = url;
        this.appid = appid;
        this.pagepath = pagepath;
    }

}
