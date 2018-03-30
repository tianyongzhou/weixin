package com.tyz.weixin.model.msg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 图文消息实体
 * @Date: 2017/12/22.
 * @Modified: tyz
 */
public class News{
    private String title;
    private String description;
    private String url; //图文消息被点击后跳转的链接
    private String picurl; //图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
}
