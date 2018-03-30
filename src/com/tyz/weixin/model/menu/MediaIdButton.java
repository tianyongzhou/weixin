package com.tyz.weixin.model.menu;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 下发消息（除文本消息）按钮
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class MediaIdButton extends TypeButton {
    private String media_id;

    public MediaIdButton(String media_id) {
        this(null, media_id);
    }

    public MediaIdButton(String name, String media_id) {
        super("media_id", name);
        this.media_id = media_id;
    }
}
