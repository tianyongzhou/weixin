package com.tyz.weixin.model.msg.template;

import com.tyz.weixin.model.msg.MiniProgrampage;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 发送模板消息
 * @Date: 2017/12/28.
 * @Modified: tyz
 */
public class TemplateMsg {
    private String touser; //	接收者openid
    private String template_id; //模板ID
    private String url; //模板跳转链接
    private MiniProgrampage miniprogram; //微信小程序
    private DataSet data; //	模板数据

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MiniProgrampage getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(MiniProgrampage miniprogram) {
        this.miniprogram = miniprogram;
    }

    public DataSet getData() {
        return data;
    }

    public void setData(DataSet data) {
        this.data = data;
    }

    public static abstract class DataSet{
        private Data first; //第一条信息
        private Data remark; //最后一条信息
        private Data keynote1; //第一条关键信息 可动态添加

        public Data getFirst() {
            return first;
        }

        public void setFirst(Data first) {
            this.first = first;
        }

        public Data getRemark() {
            return remark;
        }

        public void setRemark(Data remark) {
            this.remark = remark;
        }

        public Data getKeynote1() {
            return keynote1;
        }

        public void setKeynote1(Data keynote1) {
            this.keynote1 = keynote1;
        }
    }

    public static class Data{
        private String value; //内容
        private String color; //模板内容字体颜色，不填默认为黑色

        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }
    }
}
