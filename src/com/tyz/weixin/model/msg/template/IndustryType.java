package com.tyz.weixin.model.msg.template;

import java.util.HashMap;
import java.util.Map;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 行业类别
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class IndustryType {
    public static final Map<String, Industry> types;

    static {
        types = new HashMap<String, Industry>();
        types.put("1", new Industry("IT科技","互联网/电子商务","1"));
        types.put("2", new Industry("IT科技","IT软件与服务","2"));
        types.put("3", new Industry("IT科技","IT硬件与设备","3"));
        types.put("4", new Industry("IT科技","电子技术","4"));
        types.put("5", new Industry("IT科技","通信与运营商","5"));
        types.put("6", new Industry("IT科技","网络游戏","6"));

        types.put("7", new Industry("金融业","银行","7"));
        types.put("8", new Industry("金融业","基金理财信托","8"));
        types.put("9", new Industry("金融业","保险","9"));

        types.put("10", new Industry("餐饮","餐饮","10"));

        types.put("11", new Industry("酒店旅游","酒店","11"));
        types.put("12", new Industry("酒店旅游","旅游","12"));

        types.put("13", new Industry("运输与仓储","快递","13"));
        types.put("14", new Industry("运输与仓储","物流","14"));
        types.put("15", new Industry("运输与仓储","仓储","15"));

        types.put("16", new Industry("教育","培训","16"));
        types.put("17", new Industry("教育","院校","17"));

        types.put("18", new Industry("政府与公共事业","学术科研","18"));
        types.put("19", new Industry("政府与公共事业","交警","19"));
        types.put("20", new Industry("政府与公共事业","博物馆","20"));
        types.put("21", new Industry("政府与公共事业","公共事业非盈利机构","21"));

        types.put("22", new Industry("医药护理","医药医疗","22"));
        types.put("23", new Industry("医药护理","护理美容","23"));
        types.put("24", new Industry("医药护理","保健与卫生","24"));

        types.put("25", new Industry("交通工具","汽车相关","25"));
        types.put("26", new Industry("交通工具","摩托车相关","26"));
        types.put("27", new Industry("交通工具","火车相关","27"));
        types.put("28", new Industry("交通工具","飞机相关","28"));

        types.put("29", new Industry("房地产","建筑","29"));
        types.put("30", new Industry("房地产","物业","30"));

        types.put("31", new Industry("消费品","消费品","31"));

        types.put("32", new Industry("商业服务","法律","32"));
        types.put("33", new Industry("商业服务","会展","33"));
        types.put("34", new Industry("商业服务","中介服务","34"));
        types.put("35", new Industry("商业服务","认证","35"));
        types.put("36", new Industry("商业服务","审计","36"));

        types.put("37", new Industry("文体娱乐","传媒","37"));
        types.put("38", new Industry("文体娱乐","体育","38"));
        types.put("39", new Industry("文体娱乐","娱乐休闲","39"));

        types.put("40", new Industry("印刷","印刷","40"));

        types.put("41", new Industry("其它","其它","41"));
    }
}
