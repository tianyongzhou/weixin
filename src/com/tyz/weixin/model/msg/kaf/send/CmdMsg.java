package com.tyz.weixin.model.msg.kaf.send;

import com.tyz.weixin.model.msg.kaf.KafInfo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 发送 客服输入状态 消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class CmdMsg extends Msg{
    private String command;

    public static final String CMD_TYPING = "Typing"; //发“正在输入"状态
    public static final String CMD_CANCEL_TYPING = "CancelTyping"; // 取消对用户的”正在输入"状态

    public CmdMsg() {
        this.command = CMD_TYPING;
    }

    public CmdMsg(String touser, String msgtype, String command) {
        super(touser, msgtype);
        this.command = command;
    }

    public CmdMsg(String touser, String msgtype, KafInfo customservice, String command) {
        super(touser, msgtype, customservice);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
