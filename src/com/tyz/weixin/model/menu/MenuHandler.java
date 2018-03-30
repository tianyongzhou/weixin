package com.tyz.weixin.model.menu;

import com.tyz.weixin.utils.HttpClientUtils;
import com.tyz.weixin.utils.JsonUtils;
import com.tyz.weixin.utils.WxUtils;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 菜单处理器
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class MenuHandler {
    /**
     * @Author: tyz
     * @Description: 创建菜单
     * @Date 13:27 2017/12/21
     * @return
     */
    public static String createMenu(Menu menu){
        return HttpClientUtils.httpPostJson(WxUtils.addUriAccessTokenParam(WxUtils.URI_MENU_CREATE), JsonUtils.obj2Str(menu)).toString();
    }

    /**
     * @Author: tyz
     * @Description: 删除菜单
     * @Date 13:33 2017/12/21
     * @return
     */
    public static String deleteMenu(){
        return HttpClientUtils.httpGet(WxUtils.addUriAccessTokenParam(WxUtils.URI_MENU_DELETE),null);
    }

    /**
     * @Author: tyz
     * @Description: 查询菜单
     * @Date 13:48 2017/12/21
     * @return
     */
    public String getMenu(){
        return HttpClientUtils.httpGet(WxUtils.addUriAccessTokenParam(WxUtils.URI_MENU_FIND),null);
    }
}
