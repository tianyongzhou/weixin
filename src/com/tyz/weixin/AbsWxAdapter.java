package com.tyz.weixin;

import com.tyz.weixin.model.event.*;
import com.tyz.weixin.model.msg.receive.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 基本实现WxAdapter接口
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public abstract class AbsWxAdapter implements WxAdapter{
    /**
     * 事件处理 ########################################################################
     */

    /**
     * @Author: tyz
     * @Description: 上报地理位置事件
     * @Date 9:08 2018/2/1
     * @return
     */
    public abstract void locEvent(LocEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author:
     * @Description: 群发结果事件
     * @Date 9:18 2018/2/1
     * @return
     */
    public abstract void massSendEndJobFinish(MassSendEndJobFinishEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);


    /**
     * @Author: tyz
     * @Description: 点击 菜单事件
     * @Date 9:08 2018/2/1
     * @return
     */
    public abstract void menuClickEvent(MenuEvent.MenuClickEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 弹出地理位置选择器的事件推送
     * @Date 9:08 2018/2/1
     * @return
     */
    public abstract void menuLocSelectEvent(MenuEvent.MenuLocSelectEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 拍照发图的事件事件 pic_sysphoto pic_photo_or_album pic_weixin
     * @Date 9:08 2018/2/1
     * @return
     */
    public abstract void menuPicEvent(MenuEvent.MenuPicEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 扫码推事件的事件推送 scancode_push & scancode_waitmsg
     * @Date 9:08 2018/2/1
     * @return
     */
    public abstract void menuScanCodeEvent(MenuEvent.MenuScanCodeEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 点击菜单跳转链接事件
     * @Date 9:08 2018/2/1
     * @return
     */
    public abstract void menuViewEvent(MenuEvent.MenuViewEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 已关注用户,扫描带场景值二维码时, 事件推送
     * @Date 9:08 2018/2/1
     * @return
     */
    public abstract void scanEvent(ScanEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 扫描带场景值二维码时, 用户未关注,进行关注后的事件推送
     * @Date 9:08 2018/2/1
     * @return
     */
    public abstract void scanSubscribeEvent(ScanEvent.ScanSubscribeEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 关注事件
     * @Date 9:08 2018/2/1
     * @return
     */
    public abstract void subscribeEvent(SubscribeEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 取消关注事件
     * @Date 9:08 2018/2/1
     * @return
     */
    public abstract void unSubscribeEvent(SubscribeEvent.UnSubscribeEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 模版消息发送任务事件
     * @Date 9:08 2018/2/1
     * @return
     */
    public abstract void templateSendEndJobFinishEvent(TemplateSendEndJobFinishEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * 接收普通消息 ######################################################################################################
     */

    /**
     * @Author: tyz
     * @Description: 接收文本消息
     * @Date 13:55 2018/2/1
     * @return
     */
    public abstract void receiveTxtMsg(TxtMsg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 接收图片消息
     * @Date 13:55 2018/2/1
     * @return
     */
    public abstract void receiveImgMsg(ImgMsg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 接收语音消息
     * @Date 13:55 2018/2/1
     * @return
     */
    public abstract void receiveVoiceMsg(VoiceMsg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 接收视频消息
     * @Date 13:55 2018/2/1
     * @return
     */
    public abstract void receiveVideoMsg(VideoMsg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 接收地理位置消息
     * @Date 13:55 2018/2/1
     * @return
     */
    public abstract void receiveLocMsg(LocMsg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);

    /**
     * @Author: tyz
     * @Description: 接收链接消息
     * @Date 13:55 2018/2/1
     * @return
     */
    public abstract void receiveLinkMsg(LinkMsg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext);
}
