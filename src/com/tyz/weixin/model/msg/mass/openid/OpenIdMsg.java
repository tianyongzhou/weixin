package com.tyz.weixin.model.msg.mass.openid;

import com.tyz.weixin.model.msg.mass.Msg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 根据OpenID列表群发
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public abstract class OpenIdMsg extends Msg{
    private String[] touser;

    public String[] getTouser() {
        return touser;
    }

    public void setTouser(String[] touser) {
        this.touser = touser;
    }
}
