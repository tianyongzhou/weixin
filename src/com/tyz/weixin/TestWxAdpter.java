package com.tyz.weixin;

import com.tyz.weixin.model.menu.*;
import com.tyz.weixin.model.msg.receive.TxtMsg;
import com.tyz.weixin.utils.JsonUtils;
import com.tyz.weixin.utils.LogUtils;
import com.tyz.weixin.utils.WxUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description:
 * @Date: 2018/2/1.
 * @Modified: tyz
 */
public class TestWxAdpter extends DefaultWxAdapter{
    @Override
    public Menu initMenu() {
        Button b1 = new ClickButton("今日歌曲", "V1001_TODAY_MUSIC");

        Button b21 = new ViewButton("测试网站","http://b5618ccd.ngrok.io");
        //Button b22 = new MiniProgramButton("wxa","http://mp.weixin.qq.com", "wx286b93c14bbf93aa", "pages/lunar/index");
       // Button b23 = new ClickButton("赞一下我们","V1001_GOOD");
        Button b24 = new ScanCodePushButton("扫码推事件","scancodepush");
        Button b25 = new ScanCodeWaitMsgButton("扫码带提示","scancodewaitmsg");

        List<Button> b2subs = new ArrayList<>();
        b2subs.add(b21);
        //b2subs.add(b22);
       // b2subs.add(b23);
        b2subs.add(b24);
        b2subs.add(b25);


        Button b2 = new Button("菜单", b2subs);

        List<Button> menuBtns = new ArrayList<>();
        menuBtns.add(b1);
        menuBtns.add(b2);

        Menu menu = new Menu();
        menu.setButton(menuBtns);

        LogUtils.debug(JsonUtils.obj2Str(menu));

        return menu;
    }

    @Override
    public void receiveTxtMsg(TxtMsg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {
        com.tyz.weixin.model.msg.reply.TxtMsg txtMsg = new com.tyz.weixin.model.msg.reply.TxtMsg();
        txtMsg.setToUserName(msg.getFromUserName());
        txtMsg.setFromUserName(msg.getToUserName());
        txtMsg.setCreateTime(new Date().getTime());
        txtMsg.setContent("哈哈!");
        LogUtils.log(msg.getContent());

        try {
            response.getWriter().print(WxUtils.obj2XmlStr(txtMsg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
