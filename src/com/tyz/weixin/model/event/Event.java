package com.tyz.weixin.model.event;

import com.tyz.weixin.model.msg.Msg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 事件基类
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class Event extends Msg{
    private String Event;

    public Event() {
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }
}
