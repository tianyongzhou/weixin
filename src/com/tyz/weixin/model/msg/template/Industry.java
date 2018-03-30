package com.tyz.weixin.model.msg.template;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 行业信息
 * @Date: 2017/12/27.
 * @Modified: tyz
 */
public class Industry {
    private String first_class;//帐号设置的主营行业
    private String second_class;//帐号设置的副营行业
    private String id; //行业ID

    public Industry() {
    }

    public Industry(String first_class, String second_class, String id) {
        this.first_class = first_class;
        this.second_class = second_class;
        this.id = id;
    }
    public String getFirst_class() {
        return first_class;
    }
    public void setFirst_class(String first_class) {
        this.first_class = first_class;
    }
    public String getSecond_class() {
        return second_class;
    }
    public void setSecond_class(String second_class) {
        this.second_class = second_class;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
