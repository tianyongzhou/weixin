package com.tyz.weixin.model.menu;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 跳转按钮
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class ViewButton extends TypeButton {
    private String url;

    public ViewButton(String url) {
        this(null, url);
    }

    public ViewButton(String name, String url) {
        super("view", name);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
