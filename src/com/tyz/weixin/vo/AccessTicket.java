package com.tyz.weixin.vo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: jsapi_ticket 实体
 * @Date: 2017/12/19.
 * @Modified: tyz
 */
public class AccessTicket extends ResultStatusMsg{
    private String ticket;
    private long expires_in; //expires_in

    public AccessTicket() {
    }

    public AccessTicket(String ticket, long expires_in) {
        this.ticket = ticket;
        this.expires_in = expires_in;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }
}
