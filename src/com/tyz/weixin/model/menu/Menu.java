package com.tyz.weixin.model.menu;

import net.sf.json.JSONObject;

import java.util.List;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 菜单
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class Menu {
    private List<Button> button;

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }

    @Override
    public String toString() {
        JSONObject json = JSONObject.fromObject(this);
        return "";
    }
}
