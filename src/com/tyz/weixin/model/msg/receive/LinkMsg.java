package com.tyz.weixin.model.msg.receive;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 链接消息
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class LinkMsg extends IdMsg {
    private String Title; //消息标题
    private String Description; //消息描述
    private String Url; //消息链接

    public LinkMsg() {
        super();
    }

    public LinkMsg(String toUserName, String fromUserName, long createTime, String msgType, String msgId, String title, String description, String url) {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        Title = title;
        Description = description;
        Url = url;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
