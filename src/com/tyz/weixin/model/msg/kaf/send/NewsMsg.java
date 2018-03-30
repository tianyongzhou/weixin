package com.tyz.weixin.model.msg.kaf.send;

import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.News;
import com.tyz.weixin.model.msg.kaf.KafInfo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 图文消息(点击跳转到外链)
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class NewsMsg extends Msg{
    private News[] news;

    public NewsMsg() {
        this.setMsgtype(MsgType.NEWS);
    }

    public NewsMsg(String touser, String msgtype, News[] news) {
        super(touser, msgtype);
        this.news = news;
        this.setMsgtype(MsgType.NEWS);
    }

    public NewsMsg(String touser, String msgtype, KafInfo customservice, News[] news) {
        super(touser, msgtype, customservice);
        this.news = news;
        this.setMsgtype(MsgType.NEWS);
    }

    public News[] getNews() {
        return news;
    }

    public void setNews(News[] news) {
        this.news = news;
    }
}
