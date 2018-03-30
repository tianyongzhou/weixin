package com.tyz.weixin.vo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 微信处理返回状态消息实体
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class ResultStatusMsg {
    private int errcode;
    private String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
