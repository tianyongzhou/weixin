package com.tyz.weixin;

import com.tyz.weixin.model.event.*;
import com.tyz.weixin.model.menu.Menu;
import com.tyz.weixin.model.msg.Msg;
import com.tyz.weixin.model.msg.MsgType;
import com.tyz.weixin.model.msg.receive.*;
import com.tyz.weixin.utils.LogUtils;
import com.tyz.weixin.utils.StrUtil;
import com.tyz.weixin.utils.WxUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 默认WxAdaptert实现类，开发中继承此类即可
 * @Date: 2018/1/5.
 * @Modified: tyz
 */
public class DefaultWxAdapter extends AbsWxAdapter{
    @Override
    public Menu initMenu() {
        return null;
    }

    @Override
    public boolean isAutoCreateMenu() {
        return true;
    }

    @Override
    public void receiveEvent(Event event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {
        LogUtils.debug(event);
        LogUtils.debug(xml);
        switch (event.getMsgType()){
            case EventType.LOCATION:
                this.locEvent(WxUtils.xml2Obj(LocEvent.class, xml), xml, request, response, servletContext);
                break;
            case EventType.MASSSENDJOBFINISH:
                this.massSendEndJobFinish(WxUtils.xml2Obj(MassSendEndJobFinishEvent.class, xml), xml, request, response, servletContext);
                break;
            case EventType.CLICK: //菜单点击事件
                this.menuClickEvent(WxUtils.xml2Obj(MenuEvent.MenuClickEvent.class, xml), xml, request, response, servletContext);
                break;
            case EventType.VIEW:
                this.menuViewEvent(WxUtils.xml2Obj(MenuEvent.MenuViewEvent.class, xml), xml, request, response, servletContext);
                break;
            case EventType.LOCATION_SELECT:
                this.menuLocSelectEvent(WxUtils.xml2Obj(MenuEvent.MenuLocSelectEvent.class, xml), xml, request, response, servletContext);
                break;
            case EventType.PIC_SYSPHOTO:
            case EventType.PIC_PHOTO_OR_ALBUM:
            case EventType.PIC_WEIXIN:
                this.menuPicEvent(WxUtils.xml2Obj(MenuEvent.MenuPicEvent.class, xml), xml, request, response, servletContext);
                break;
            case EventType.SCANCODE_PUSH:
            case EventType.SCANCODE_WAITMSG:
                this.menuScanCodeEvent(WxUtils.xml2Obj(MenuEvent.MenuScanCodeEvent.class, xml), xml, request, response, servletContext);
                break;
            case EventType.SUBSCRIBE:
                ScanEvent.ScanSubscribeEvent ssEvent = WxUtils.xml2Obj(ScanEvent.ScanSubscribeEvent.class, xml);
                if(StrUtil.isEmpty(ssEvent.getTicket())){
                    this.subscribeEvent(WxUtils.xml2Obj(SubscribeEvent.class, xml), xml, request, response, servletContext);
                }else{
                    this.scanSubscribeEvent(ssEvent, xml, request, response, servletContext); //扫码订阅
                }
                break;
            case EventType.UNSUBSCRIBE:
                this.unSubscribeEvent(WxUtils.xml2Obj(SubscribeEvent.UnSubscribeEvent.class, xml), xml, request, response, servletContext);
                break;
            case EventType.SCAN:
                this.scanEvent(WxUtils.xml2Obj(ScanEvent.class, xml), xml, request, response, servletContext);
                break;
            case EventType.TEMPLATE_SEND_JOBFINISH:
                this.templateSendEndJobFinishEvent(WxUtils.xml2Obj(TemplateSendEndJobFinishEvent.class, xml), xml, request, response, servletContext);
                break;
        }
    }

    @Override
    public void receiveMsg(Msg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {
        switch (msg.getMsgType()){
            case MsgType.TEXT:
                this.receiveTxtMsg(WxUtils.xml2Obj(TxtMsg.class, xml), xml, request, response, servletContext);
                break;
            case MsgType.IMAGE:
                this.receiveImgMsg(WxUtils.xml2Obj(ImgMsg.class, xml), xml, request, response, servletContext);
                break;
            case MsgType.VOICE:
                this.receiveVoiceMsg(WxUtils.xml2Obj(VoiceMsg.class, xml), xml, request, response, servletContext);
                break;
            case MsgType.VIDEO:
            case MsgType.SHORTVIDEO:
                this.receiveVideoMsg(WxUtils.xml2Obj(VideoMsg.class, xml), xml, request, response, servletContext);
                break;
            case MsgType.LOCATION:
                this.receiveLocMsg(WxUtils.xml2Obj(LocMsg.class, xml), xml, request, response, servletContext);
                break;
            case MsgType.LINK:
                this.receiveLinkMsg(WxUtils.xml2Obj(LinkMsg.class, xml), xml, request, response, servletContext);
                break;
        }
    }

    @Override
    public void locEvent(LocEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void massSendEndJobFinish(MassSendEndJobFinishEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void menuClickEvent(MenuEvent.MenuClickEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void menuLocSelectEvent(MenuEvent.MenuLocSelectEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void menuPicEvent(MenuEvent.MenuPicEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void menuScanCodeEvent(MenuEvent.MenuScanCodeEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void menuViewEvent(MenuEvent.MenuViewEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void scanEvent(ScanEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void scanSubscribeEvent(ScanEvent.ScanSubscribeEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void subscribeEvent(SubscribeEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void unSubscribeEvent(SubscribeEvent.UnSubscribeEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void templateSendEndJobFinishEvent(TemplateSendEndJobFinishEvent event, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void receiveTxtMsg(TxtMsg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {
    }

    @Override
    public void receiveImgMsg(ImgMsg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void receiveVoiceMsg(VoiceMsg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void receiveVideoMsg(VideoMsg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void receiveLocMsg(LocMsg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }

    @Override
    public void receiveLinkMsg(LinkMsg msg, String xml, HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {

    }
}
