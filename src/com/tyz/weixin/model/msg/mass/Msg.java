package com.tyz.weixin.model.msg.mass;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 群发消息基础实体
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public abstract class Msg {
    private String msgtype; //群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
    private int send_ignore_reprint = 0; //图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。
    private String clientmsgid; //设置 clientmsgid 参数，避免重复推送

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public int getSend_ignore_reprint() {
        return send_ignore_reprint;
    }

    public void setSend_ignore_reprint(int send_ignore_reprint) {
        this.send_ignore_reprint = send_ignore_reprint;
    }

    public String getClientmsgid() {
        return clientmsgid;
    }

    public void setClientmsgid(String clientmsgid) {
        this.clientmsgid = clientmsgid;
    }
}
