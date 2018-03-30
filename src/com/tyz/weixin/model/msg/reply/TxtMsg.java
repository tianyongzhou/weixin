package com.tyz.weixin.model.msg.reply;
import com.tyz.weixin.model.msg.MsgType;
/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 回复文本消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class TxtMsg extends ReplyMsg {
    private String Content; //	回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）

    public TxtMsg() {
        this.setMsgType(MsgType.TEXT);
    }

    public TxtMsg(String toUserName, String fromUserName, long createTime, String content) {
        super(toUserName, fromUserName, createTime, MsgType.TEXT);
        Content = content;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
