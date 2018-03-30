package com.tyz.weixin.model.event;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 已关注用户,扫描带场景值二维码时, 事件推送
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class ScanEvent extends ClickEvent{
    private String Ticket; //二维码的ticket，可用来换取二维码图片

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    /**
     * @Version 1.0
     * @Author: tyz
     * @Description: 扫描带场景值二维码时, 用户未关注,进行关注后的事件推送
     * @Date: 2017/12/21.
     * @Modified: tyz
     */
    public class ScanSubscribeEvent extends ScanEvent{
    }
}
