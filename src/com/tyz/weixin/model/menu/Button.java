package com.tyz.weixin.model.menu;

import java.util.List;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 放入菜单中的组件
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class Button {
    private String name;
    private List<Button> sub_button;

    public Button(){};

    public Button(String name) {
        this.name = name;
    }

    public Button(String name, List<Button>sub_button) {
        this.name = name;
        this.sub_button = sub_button;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Button> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Button> sub_button) {
        this.sub_button = sub_button;
    }
}
