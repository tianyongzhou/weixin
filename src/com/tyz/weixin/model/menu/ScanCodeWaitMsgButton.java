package com.tyz.weixin.model.menu;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 扫码推事件且弹出“消息接收中”提示框按钮
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class ScanCodeWaitMsgButton extends TypeButton {
    private String key;

    public ScanCodeWaitMsgButton(String key) {
        this(null, key);
    }

    public ScanCodeWaitMsgButton(String name, String key) {
        super("scancode_waitmsg", name);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
