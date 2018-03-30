package com.tyz.weixin.model.msg.reply;
import com.tyz.weixin.model.msg.MsgType;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 回复图文消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class NewsMsg extends ReplyMsg {
    private String ArticleCount; //		图文消息个数，限制为8条以内
    private String Articles; //	多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
    private String Title; //	图文消息标题
    private String Description; //	图文消息描述
    private String PicUrl; //		图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    private String Url; //	点击图文消息跳转链接

    public NewsMsg() {
        this.setMsgType(MsgType.NEWS);
    }

    public NewsMsg(String toUserName, String fromUserName, long createTime, String articleCount, String articles, String title, String description, String picUrl, String url) {
        super(toUserName, fromUserName, createTime, MsgType.NEWS);
        ArticleCount = articleCount;
        Articles = articles;
        Title = title;
        Description = description;
        PicUrl = picUrl;
        Url = url;
    }
}
