package com.tyz.weixin.model.msg.kaf.send;

import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.kaf.KafInfo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 小程序卡片消息
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class MiniProgramPageMsg extends Msg{
    private MiniProgramPageMsg miniprogrampage;

    public MiniProgramPageMsg() {
        this.setMsgtype(MsgType.IMAGE);
    }

    public MiniProgramPageMsg(String touser, String msgtype, MiniProgramPageMsg miniprogrampage) {
        super(touser, msgtype);
        this.miniprogrampage = miniprogrampage;
        this.setMsgtype(MsgType.IMAGE);
    }

    public MiniProgramPageMsg(String touser, String msgtype, KafInfo customservice, MiniProgramPageMsg miniprogrampage) {
        super(touser, msgtype, customservice);
        this.miniprogrampage = miniprogrampage;
        this.setMsgtype(MsgType.IMAGE);
    }

    public MiniProgramPageMsg getMiniprogrampage() {
        return miniprogrampage;
    }

    public void setMiniprogrampage(MiniProgramPageMsg miniprogrampage) {
        this.miniprogrampage = miniprogrampage;
    }
}
