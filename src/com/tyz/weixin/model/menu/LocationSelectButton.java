package com.tyz.weixin.model.menu;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 弹出地理位置选择器按钮
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class LocationSelectButton extends TypeButton {
    private String key;

    public LocationSelectButton(String key) {
        this(null, key);
    }

    public LocationSelectButton(String name, String key) {
        super("location_select", name);
        this.key = key;
    }
}
