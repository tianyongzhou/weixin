package com.tyz.weixin.model.menu;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 弹出系统拍照发图按钮
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class PicSysPhotoButton extends TypeButton {
    private String key;

    public PicSysPhotoButton(String key) {
        this(null, key);
    }

    public PicSysPhotoButton(String name, String key) {
        super("pic_sysphoto", name);
        this.key = key;
    }
}
