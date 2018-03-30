package com.tyz.weixin.model.menu;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 扫码推事件按钮
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class ScanCodePushButton extends TypeButton {
    private String key;

    public ScanCodePushButton(String key) {
        this(null, key);
    }

    public ScanCodePushButton(String name, String key) {
        super("scancode_push", name);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
