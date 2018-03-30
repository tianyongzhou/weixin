package com.tyz.weixin.model.menu;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 弹出拍照或者相册发图按钮
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class PicPhotoOrAlbumButton extends TypeButton {
    private String key;

    public PicPhotoOrAlbumButton(String key) {
        this(null, key);
    }

    public PicPhotoOrAlbumButton(String name, String key) {
        super("pic_photo_or_album", name);
        this.key = key;
    }
}
