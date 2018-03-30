package com.tyz.weixin.model.event;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 点击菜单拉取消息时的事件推送
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class ClickEvent extends Event{
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
