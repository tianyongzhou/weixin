package com.tyz.weixin.model.msg.template;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 设置所属行业
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class SettingIndustry {
    private String industry_id1;//公众号模板消息所属行业编号
    private String industry_id2;//公众号模板消息所属行业编号

    public String getIndustry_id1() {
        return industry_id1;
    }

    public void setIndustry_id1(String industry_id1) {
        this.industry_id1 = industry_id1;
    }

    public String getIndustry_id2() {
        return industry_id2;
    }

    public void setIndustry_id2(String industry_id2) {
        this.industry_id2 = industry_id2;
    }
}
