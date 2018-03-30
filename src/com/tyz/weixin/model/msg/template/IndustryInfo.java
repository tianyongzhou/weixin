package com.tyz.weixin.model.msg.template;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 所属行业信息
 * @Date: 2017/12/27.
 * @Modified: tyz
 */
public class IndustryInfo {
    private Industry primary_industry; //帐号设置的主营行业
    private Industry secondary_industry; //	帐号设置的副营行业

    public Industry getPrimary_industry() {
        return primary_industry;
    }

    public void setPrimary_industry(Industry primary_industry) {
        this.primary_industry = primary_industry;
    }

    public Industry getSecondary_industry() {
        return secondary_industry;
    }

    public void setSecondary_industry(Industry secondary_industry) {
        this.secondary_industry = secondary_industry;
    }
}
