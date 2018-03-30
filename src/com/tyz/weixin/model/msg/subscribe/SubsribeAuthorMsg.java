package com.tyz.weixin.model.msg.subscribe;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 一次性订阅消息 需要用户同意授权(第一步：需要用户同意授权，获取一次给用户推送一条订阅模板消息的机会)
 * @Date: 2017/12/28.
 * @Modified: tyz
 */
public class SubsribeAuthorMsg {
    private String action = "get_confirm";
    private String appid;
    private String scene; //	重定向后会带上scene参数，开发者可以填0-10000的整形值，用来标识订阅场景值
    private String template_id; //订阅消息模板ID，登录公众平台后台，在接口权限列表处可查看订阅模板ID
    private String redirect_url; //授权后重定向的回调地址，请使用UrlEncode对链接进行处理。
                                 // 注：要求redirect_url的域名要跟登记的业务域名一致，且业务域名不能带路径。
                                 // 业务域名需登录公众号，在设置-公众号设置-功能设置里面对业务域名设置。
    private String reserved; //用于保持请求和回调的状态，授权请后原样带回给第三方。该参数可用于防止csrf攻击（跨站请求伪造攻击），
                             // 建议第三方带上该参数，可设置为简单的随机数加session进行校验，开发者可以填写a-zA-Z0-9的参数值，最多128字节，要求做urlencode
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }
}
