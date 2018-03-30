package com.tyz.weixin.model.menu;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 跳转图文消息URI按钮
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class ViewLimitedButton extends TypeButton {
    private String media_id;

    public ViewLimitedButton(String media_id) {
        this(null, media_id);
    }

    public ViewLimitedButton(String name, String media_id) {
        super("view_limited", name);
        this.media_id = media_id;
    }

}
