package com.tyz.weixin.model.menu;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 放入菜单中的组件
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public abstract class TypeButton extends Button{
    private String type;

    public TypeButton(){};

    public TypeButton(String type, String name) {
        super(name);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
