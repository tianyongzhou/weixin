package com.tyz.weixin.model.msg.mass;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 需要删除的实体
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class DeleteMsg {
    private long msg_id; //发送出去的消息ID
    private long article_idx; //	要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章

    public long getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(long msg_id) {
        this.msg_id = msg_id;
    }

    public long getArticle_idx() {
        return article_idx;
    }

    public void setArticle_idx(long article_idx) {
        this.article_idx = article_idx;
    }
}
