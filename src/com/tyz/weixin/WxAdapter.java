package com.tyz.weixin;

import com.tyz.weixin.model.event.Event;
import com.tyz.weixin.model.menu.Menu;
import com.tyz.weixin.model.msg.Msg;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description:
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public interface WxAdapter {

    /**
     * @Author: tyz
     * @Description: 初始化菜单
     * @Date 11:31 2017/12/21
     * @return
     */
    Menu initMenu();

    /**
     * @Author: tyz
     * @Description: 是否自动创建菜单
     * @Date 17:34 2017/12/21
     * @return
     */
    boolean isAutoCreateMenu();

    /**
     *  接收推送事件
     * @param event
     * @param xml
     * @param request
     * @param response
     * @param servletContext
     */
    void receiveEvent(Event event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * 接收消息
     * @param msg
     * @param xml
     * @param request
     * @param response
     * @param servletContext
     */
    void receiveMsg(Msg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);
}
