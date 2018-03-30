package com.tyz.weixin.model.event;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 事件类型
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class EventType {
    //上报地理位置事件
    public static final String LOCATION = "LOCATION";
    //群发结果事件推送
    public static final String MASSSENDJOBFINISH = "MASSSENDJOBFINISH";

    //菜单事件---------------------------------------------------------------------------------------
    //点击菜单事件
    public static final String CLICK = "CLICK";
    //点击跳转
    public static final String VIEW = "VIEW";

    //弹出系统拍照发图的事件推送
    public static final String PIC_SYSPHOTO = "pic_sysphoto";
    //弹出拍照或者相册发图的事件推送
    public static final String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
    //弹出微信相册发图器的事件推送
    public static final String PIC_WEIXIN = "pic_weixin";

    //扫码推事件的事件推送
    public static final String SCANCODE_PUSH = "scancode_push";
    //扫码推事件且弹出“消息接收中”提示框的事件推送
    public static final String SCANCODE_WAITMSG = "scancode_waitmsg";
    //弹出地理位置选择器的事件推送
    public static final String LOCATION_SELECT = "location_select";
    //-----------------------------------------------------------------------------------------------

    //1.关注
    //2.用户扫描带场景值二维码时，如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
    public static final String SUBSCRIBE = "subscribe";
    //取消关注事件
    public static final String UNSUBSCRIBE = "unsubscribe";
    //扫描带场景值二维码时 用户已关注时的事件推送
    public static final String SCAN = "SCAN";
    //模版消息发送任务完成后，微信服务器会将是否送达成功作为通知
    public static final String TEMPLATE_SEND_JOBFINISH = "TEMPLATESENDJOBFINISH";
}
