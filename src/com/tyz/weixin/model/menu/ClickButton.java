package com.tyz.weixin.model.menu;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 点击按钮
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class ClickButton extends TypeButton {
    private String key;

    public ClickButton(String key) {
        this(null, key);
    }

    public ClickButton(String name, String key) {
        super("click", name);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
