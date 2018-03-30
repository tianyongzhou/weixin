package com.tyz.weixin.model.msg.mass.tag;

import com.tyz.weixin.model.msg.mass.Msg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 根据标签进行群发
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public abstract class TagMsg extends Msg{
    private Filter filter; //用于设定图文消息的接收者

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }
}
