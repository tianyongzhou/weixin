package com.tyz.weixin.model.menu;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 弹出微信相册发图按钮
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class PicWeixinButton extends TypeButton {
    private String key;

    public PicWeixinButton(String key) {
        this(null, key);
    }

    public PicWeixinButton(String name, String key) {
        super("pic_weixin", name);
        this.key = key;
    }
}
