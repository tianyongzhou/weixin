package com.tyz.weixin.model.msg.template;

import com.tyz.weixin.vo.ResultStatusMsg;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description:
 * @Date: 2017/12/27.
 * @Modified: tyz
 */
public class ResultTemplateStatus extends ResultStatusMsg{
    private String template_id;

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }
}
