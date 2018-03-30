package com.tyz.weixin.utils;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.SHA1;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.tyz.weixin.exception.WxException;
import com.tyz.weixin.model.msg.ResultMsgStatus;
import com.tyz.weixin.model.msg.kaf.KafInfo;
import com.tyz.weixin.model.msg.kaf.KfaAccount;
import com.tyz.weixin.model.msg.kaf.send.CmdMsg;
import com.tyz.weixin.model.msg.kaf.send.Msg;
import com.tyz.weixin.model.msg.mass.DeleteMsg;
import com.tyz.weixin.model.msg.mass.Speed;
import com.tyz.weixin.model.msg.mass.openid.OpenIdMsg;
import com.tyz.weixin.model.msg.mass.tag.TagMsg;
import com.tyz.weixin.model.msg.template.*;
import com.tyz.weixin.model.msg.upload.NewsMaterial;
import com.tyz.weixin.model.msg.upload.ResultMsg;
import com.tyz.weixin.model.msg.upload.Video;
import com.tyz.weixin.vo.AccessTicket;
import com.tyz.weixin.vo.AccessToken;
import com.tyz.weixin.vo.ResultStatusMsg;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 微信服务 工具集
 * @Date: 2017/12/8.
 * @Modified: tyz
 */
public final class WxUtils {
    private static final String ACCESS_TOKEN_STR = "?access_token=";

    public static final String APP_SECRET;
    public static final String APP_ID;
    public static final String WX_TOKEN;
    public static final String AES_KEY;
    public static final boolean IS_SAFE_MODE;
    public static final String ADAPTER_PATH;

    private static AccessToken token = null;
    private static long tokenExpiresTime = 0L;

    public static final String WX_ADAPTER_CLASSNAME;

    //URI
    public static final String URI_ACCESSTOKEN_FIND;
    public static final String URI_IP_FIND;
    //菜单
    public static final String URI_MENU_CREATE;
    public static final String URI_MENU_DELETE;
    public static final String URI_MENU_FIND;
    
    //客服账号管理
    public static final String URI_KFA_ACCOUNT_ADD;
    public static final String URI_KFA_ACCOUNT_UPDATE;
    public static final String URI_KFA_ACCOUNT_DELETE;
    //客服信息
    public static final String URI_KFA_INFO_FIND;
    //客户发送消息给用户
    public static final String URI_KFA_SEND_MSG;
    //发送客服输入状态
    public static final String URI_KFA_SEND_TYPING;

    //上传资源
    //上传 图文消息中的图片地址
    public static final String URI_NEWS_UPLOAD_PIC;
    //上传图文素材
    public static final String URI_NEWS_UPLOAD_NEWS;
    //上传 视频
    public static final String URI_UPLOAD_VIDEO;

    //群发消息
    //根据标签进行群发
    public static final String URI_MASS_SEND_TAB;
    //根据Openid进行群发
    public static final String URI_MASS_SEND_OPENID;
    //删除群发消息
    public static final String URI_MASS_MSG_DELETE;
    //查询群发消息发送状态
    public static final String URI_MASS_MSG_FIND_STATUS;
    //获取群发消息速度
    public static final String URI_MASS_GET_SPEED;
    //设置群发速度
    public static final String URI_MASS_SET_SPEED;

    //模板
    //设置所属行业
    public static final String URI_TEMPLATE_SET_INDUSTRY;
    //获取设置的行业信息
    public static final String URI_TEMPLATE_GET_INDUSTRY;
    //获得模板ID
    public static final String URI_TEMPLATE_GET_ID;
    //#获取模板列表
    public static final String URI_TEMPLATE_GET_LIST;
    //删除模板
    public static final String URI_TEMPLATE_DELETE;
    //发送模板消息
    public static final String URI_TEMPLATE_SEND;

    //JS
    //获取WJS jsapi_ticket
    public static final String URI_WJS_GET_TICKENT;



    static {
        LogUtils.log("WxUtils static area handling");
        Properties prop = new Properties();
        InputStream in = null;
        try {
            in = WxUtils.class.getClassLoader().getResourceAsStream("weixin.properties");
            prop.load(in);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        APP_ID = prop.getProperty("app_id");
        APP_SECRET = prop.getProperty("app_secret");
        WX_TOKEN = prop.getProperty("token");
        IS_SAFE_MODE = prop.getProperty("is_safe_mode").equals("true");
        ADAPTER_PATH = prop.getProperty("adapterPath");

        if (IS_SAFE_MODE) {
            AES_KEY = prop.getProperty("encodingAesKey");
        } else {
            AES_KEY = null;
        }
        WX_ADAPTER_CLASSNAME = prop.getProperty("wxAdapterPath");
        if(StrUtil.isEmpty(WX_ADAPTER_CLASSNAME)) throw new WxException("weixin.properties文件中wxAdapterPath未赋值[WxAdapter实现类]");

        URI_ACCESSTOKEN_FIND = prop.getProperty("access_token_find");
        URI_IP_FIND = prop.getProperty("ip_find");

        URI_MENU_CREATE = prop.getProperty("menu_create");
        URI_MENU_DELETE = prop.getProperty("menu_delete");
        URI_MENU_FIND = prop.getProperty("menu_find");

        URI_KFA_INFO_FIND = prop.getProperty("kaf_info_find");

        URI_KFA_ACCOUNT_ADD = prop.getProperty("kaf_account_add");
        URI_KFA_ACCOUNT_UPDATE = prop.getProperty("kaf_account_update");
        URI_KFA_ACCOUNT_DELETE = prop.getProperty("kaf_account_delete");

        URI_KFA_SEND_MSG = prop.getProperty("kaf_send_msg");
        URI_KFA_SEND_TYPING = prop.getProperty("kaf_send_typing");

        URI_NEWS_UPLOAD_PIC= prop.getProperty("news_upload_pic");
        URI_NEWS_UPLOAD_NEWS= prop.getProperty("news_upload_news");
        URI_UPLOAD_VIDEO= prop.getProperty("upload_video");

        URI_MASS_SEND_TAB= prop.getProperty("mass_send_tag");
        URI_MASS_SEND_OPENID= prop.getProperty("mass_send_openid");
        URI_MASS_MSG_DELETE= prop.getProperty("mass_msg_delete");

        URI_MASS_MSG_FIND_STATUS= prop.getProperty("mass_msg_find_status");
        URI_MASS_GET_SPEED = prop.getProperty("mass_get_speed");
        URI_MASS_SET_SPEED = prop.getProperty("mass_set_speed");

        URI_TEMPLATE_SET_INDUSTRY = prop.getProperty("template_set_industry");
        URI_TEMPLATE_GET_INDUSTRY = prop.getProperty("template_get_industry");
        URI_TEMPLATE_GET_ID = prop.getProperty("template_get_id");
        URI_TEMPLATE_GET_LIST = prop.getProperty("template_get_list");
        URI_TEMPLATE_DELETE = prop.getProperty("template_delete");
        URI_TEMPLATE_SEND = prop.getProperty("template_send");

        URI_WJS_GET_TICKENT = prop.getProperty("wjs_get_ticket");

        LogUtils.log(APP_ID);
        LogUtils.log(APP_SECRET);
    }

    /**
     * @Author: tyz
     * @Description: 添加 URI ACCESS TOKEN参数
     * @Date 13:59 2017/12/22
     * @return 
     */
    public static String addUriAccessTokenParam(String uri){
        return uri + ACCESS_TOKEN_STR + WxUtils.getAccessToken().getAccess_token();
    }

    public static  AccessToken getAccessToken(){
        if((null!=token) && (tokenExpiresTime>System.currentTimeMillis()) ){
            return  token;
        }
        String uri = URI_ACCESSTOKEN_FIND + "&appid="+APP_ID+"&secret="+APP_SECRET;
        String content = HttpClientUtils.getInstance().httpGet(uri, null);
        AccessToken accessToken = null;
        try{
            accessToken = JsonUtils.str2Obj(content, AccessToken.class);
            tokenExpiresTime = System.currentTimeMillis() + accessToken.getExpires_in()*1000;

            LogUtils.debug("获取AccessToken:"+accessToken+"完成！");
        }catch (Exception e){
            tokenExpiresTime = 0L;
        }
        return accessToken;
    }

    /**
     * @Author: tyz
     * @Description: XML 字符串数据转换成实体对象
     * @Date 16:28 2017/12/21
     * @return
     */
    public static <E> E xml2Obj(Class<E> clz, String xml){
        if (null==clz || StrUtil.isEmpty(xml)) {
            return null;
        }
        E entity = null;
        try {
            entity = clz.newInstance();
        } catch (Exception e) {
            return entity;
        }
        Document document = null;
        try {
            // 将字符串转化为XML文档对象
            document = DocumentHelper.parseText(xml);
            // 获得文档的根节点
            Element root = document.getRootElement();
            // 遍历根节点下所有子节点
            Iterator<?> iter = root.elementIterator();

            List<Class<?>> allCls = new ArrayList<Class<?>>();
            Class<?> superCls = clz;
            while (null != superCls && Object.class != superCls){
                allCls.add(superCls);
                superCls = superCls.getSuperclass();
            }
            while(iter.hasNext())
            {
                try {
                    Element ele = (Element)iter.next();
                    for(Class c : allCls){
                        try {
                            Field field = c.getDeclaredField(ele.getName()); //获取对应的属性
                            field.setAccessible(true);
                            Class fieldTypeClass = field.getType();
                            field.set(entity, convertValType(ele.getText(), fieldTypeClass));
                            break;
                        }catch (Exception e){}
                    }
                } catch (Exception e) {
                    LogUtils.log(e.getMessage());
                }
            }

        } catch (Exception e) {
            LogUtils.log(e.getMessage());
        }finally {
            if(null != document)
                document.clone();
        }
        return entity;
    }

    /**
     * @Author: tyz
     * @Description: 将Object类型的值，转换成bean对象属性里对应的类型值
     ** @param value Object对象值
     * @param fieldTypeClass 属性的类型
     * @Date 15:09 2017/12/26
     * @return 转换后的值
     */
    public static Object convertValType(Object value, Class fieldTypeClass) {
        Object retVal = null;
        if(Long.class.getName().equals(fieldTypeClass.getName())
                || long.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Long.parseLong(value.toString());
        } else if(Integer.class.getName().equals(fieldTypeClass.getName())
                || int.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Integer.parseInt(value.toString());
        } else if(Float.class.getName().equals(fieldTypeClass.getName())
                || float.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Float.parseFloat(value.toString());
        } else if(Double.class.getName().equals(fieldTypeClass.getName())
                || double.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Double.parseDouble(value.toString());
        } else {
            retVal = value;
        }
        return retVal;
    }

    /**
     * @Author: tyz
     * @Description: xml输入流 转 String
     * @Date 16:56 2017/12/21
     * @return
     */
    public static String xmlInputStream2Str(InputStream is) {
        String xml = "";
        SAXReader sr = new SAXReader();
        Document doc = null;
        try {
            doc = sr.read(is);
            xml = doc.getRootElement().asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
        }finally {
            if(null != doc)
            doc.clone();
        }
        return xml;
    }

    /**
     * @Author: tyz
     * @Description: 将XML String 转换成Map对象
     * @Date 17:13 2017/12/21
     * @return
     */
    public static Map<String, String> xmlStr2Map(String xml) {
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();
        List<Element> elements = root.elements();
        Map<String, String> map = new HashMap<String, String>();
        for (Element element : elements) {
            map.put(element.getName(), element.getText());
        }
        if(null != doc)
            doc.clone();
        return map;
    }



    public static String formatXmlStr(String value, Class fieldTypeClass) {
        if(String.class.getName().equals(fieldTypeClass.getName())) {
            return "<![CDATA[" + value + "]]>";
        }else {
            return  value;
        }
    }
    /**
     * 对象转成XML格式字符串
     * @param obj
     * @return
     */
    public static String obj2XmlStr(Object obj){
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        try {
            List<Class<?>> allCls = new ArrayList<Class<?>>();
            Class<?> superCls = obj.getClass();
            while (null != superCls && Object.class != superCls){
                allCls.add(superCls);
                superCls = superCls.getSuperclass();
            }
            for (Class cls : allCls)
            {
                Field[] fields = cls.getDeclaredFields();
                for (int j = 0; j < fields.length; j++) {
                    Field field = fields[j];
                    field.setAccessible(true);
                    String name = field.getName();
                    sb.append("<"+name+">");
                    sb.append(formatXmlStr(field.get(obj).toString(), field.getType()));
                    sb.append("</"+name+">");
                }
            }
            sb.append("</xml>");
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @Author: tyz
     * @Description: 加密消息
     * @Date 17:03 2017/12/21
     * @return
     */
    public static String encryptMsg(String token, String encodingAesKey, String appId, String replyMsgXml,
                                    String timestamp, String nonce) throws AesException {
        WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
        return pc.encryptMsg(replyMsgXml, timestamp, nonce);

    }

    /**
     * @Author: tyz
     * @Description: 解密消息
     * @Date 17:03 2017/12/21
     * @return
     */
    public static String decryptMsg(String token, String encodingAesKey, String appId, String msgSignature,
                                    String timestamp, String nonce, String fromXML) throws AesException {
        WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
        return pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
    }

    /**
     * @Author: tyz
     * @Description: 获取微信服务器IP地址
     * @Date 11:23 2017/12/22
     * @return
     */
    public static String getIP(){
        String content = HttpClientUtils.getInstance().httpGet(addUriAccessTokenParam(URI_IP_FIND), null);
        JSONObject jsonObj = JSONObject.fromObject(content);
        try{
            return  jsonObj.getJSONArray("ip_list").toString();
        }catch (Exception e){
            return "";
        }
    }

    /**
     * @Author: tyz
     * @Description: 添加客服账号
     * @Date 11:23 2017/12/22
     * @return
     */
    public static ResultStatusMsg addKafAccount(KfaAccount account){
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_KFA_ACCOUNT_ADD), JsonUtils.objArr2Str(account));
        return (ResultStatusMsg)JSONObject.toBean(jsonObject);
    }

    /**
     * @Author: tyz
     * @Description: 修改客服账号
     * @Date 11:23 2017/12/22
     * @return
     */
    public static ResultStatusMsg updateKafAccount(KfaAccount account){
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_KFA_ACCOUNT_UPDATE), JsonUtils.objArr2Str(account));
        return (ResultStatusMsg)JSONObject.toBean(jsonObject);
    }

    /**
     * @Author: tyz
     * @Description: 删除客户账号
     * @Date 11:23 2017/12/22
     * @return
     */
    public static ResultStatusMsg deleteKafAccount(KfaAccount account){
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_KFA_ACCOUNT_DELETE), JsonUtils.objArr2Str(account));
        return (ResultStatusMsg)JSONObject.toBean(jsonObject);
    }

    /**
     * @Author: tyz
     * @Description: 获取所有客服信息
     * @Date 11:23 2017/12/22
     * @return
     */
    public static List<KafInfo> getAllKafInfo(){
        String content = HttpClientUtils.getInstance().httpGet(addUriAccessTokenParam(URI_KFA_INFO_FIND), null);
        JSONArray jsonArray = JSONObject.fromObject(content).getJSONArray("kf_list");
        return JsonUtils.str2ObjArr(jsonArray.toString(), KafInfo.class);
    }

    /**
     * @Author: tyz
     * @Description: 客服发送消息
     * @Date 11:23 2017/12/22
     * @return
     */
    public static ResultStatusMsg sendKafMsg(Msg msg){
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_KFA_SEND_MSG), JsonUtils.objArr2Str(msg));
        return (ResultStatusMsg)JSONObject.toBean(jsonObject);
    }

    /**
     * @Author: tyz
     * @Description: 发送客服输入状态消息给用户
     * @Date 11:23 2017/12/22
     * @return
     */
    public static ResultStatusMsg sendKafTyingCmd(CmdMsg msg){
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_KFA_SEND_TYPING), JsonUtils.objArr2Str(msg));
        return (ResultStatusMsg)JSONObject.toBean(jsonObject);
    }

    /**
     * @Author: tyz
     * @Description:
     * @param localFilePath 本地文件的路径
     * @Date 17:19 2017/12/25
     * @return 返回上传后图片的地址
     */
    public static String uploadNewsPic(String localFilePath){
        try {
            Map<String, String> uploadParams = new HashMap<String, String>();
            uploadParams.put("access_token", getAccessToken().getAccess_token());
            uploadParams.put("contentType", "sq.jpg");
            uploadParams.put("fileName", "media");
            String result = HttpClientUtils.getInstance().uploadFile(
                    addUriAccessTokenParam(URI_NEWS_UPLOAD_PIC), localFilePath,
                    "media", uploadParams);
            return JSONObject.fromObject(result).getString("url");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @Author: tyz
     * @Description: 上传图文素材列表
     * @param newsMaterials
     * @Date 17:19 2017/12/25
     */
    public static ResultMsg uploadNewsNews(NewsMaterial[] newsMaterials){
        JSONObject jobj = new JSONObject();
        jobj.put("articles", newsMaterials);
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_NEWS_UPLOAD_NEWS), jobj.toString());
        return (ResultMsg)JSONObject.toBean(jsonObject);
    }

    /**
     * @Author: tyz
     * @Description: 上传图视频
     * @param video
     * @Date 17:19 2017/12/25
     */
    public static ResultMsg uploadVideo(Video video){
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_UPLOAD_VIDEO), JsonUtils.obj2Str(video));
        return (ResultMsg)JSONObject.toBean(jsonObject);
    }

    /**
     * @Author: tyz
     * @Description: 根据标签进行群发
     * @param tagMsg 标签消息
     * @Date 17:19 2017/12/25
     */
    public static com.tyz.weixin.model.msg.mass.ResultMsg sendMassMsgByTag(TagMsg tagMsg){
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_MASS_SEND_TAB), JsonUtils.obj2Str(tagMsg));
        return (com.tyz.weixin.model.msg.mass.ResultMsg)JSONObject.toBean(jsonObject);
    }

    /**
     * @Author: tyz
     * @Description: 根据标OpenId行群发
     * @param openIdMsg
     * @Date 17:19 2017/12/25
     */
    public static com.tyz.weixin.model.msg.mass.ResultMsg sendMassMsgByTag(OpenIdMsg openIdMsg){
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_MASS_SEND_OPENID), JsonUtils.obj2Str(openIdMsg));
        return (com.tyz.weixin.model.msg.mass.ResultMsg)JSONObject.toBean(jsonObject);
    }

    /**
     * @Author: tyz
     * @Description: 删除群发消息
     * @param deleteMsg
     * @Date 17:19 2017/12/25
     */
    public static ResultStatusMsg deleteMassMsg(DeleteMsg deleteMsg){
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_MASS_MSG_DELETE), JsonUtils.obj2Str(deleteMsg));
        return (ResultStatusMsg)JSONObject.toBean(jsonObject);
    }

    /**
     * @Author: tyz
     * @Description: 查询群发消息发送状态
     * @param msgId
     * @Date 17:19 2017/12/25
     */
    public static ResultMsgStatus findMassMsgStatus(String msgId){
        JSONObject param = new JSONObject();
        param.put("msg_id", msgId);
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_MASS_MSG_FIND_STATUS), param.toString());
        return (ResultMsgStatus)JSONObject.toBean(jsonObject);
    }

    /**
     * @Author: tyz
     * @Description: 获取群发消息速度
     * @Date 17:19 2017/12/25
     */
    public static Speed getMassMsgSpeed(){
        String result = HttpClientUtils.getInstance().httpPost(addUriAccessTokenParam(URI_MASS_GET_SPEED), null, null);
        return JsonUtils.str2Obj(result, Speed.class);
    }

    /**
     * @Author: tyz
     * @Description: 设置群发消息速度
     * @Date 17:19 2017/12/25
     */
    public static ResultMsgStatus setMassMsgSpeed(Speed speed){
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_MASS_SET_SPEED), JsonUtils.obj2Str(speed));
        return (ResultMsgStatus)JSONObject.toBean(jsonObject);
    }

    /**
     * @Author: tyz
     * @Description: 设置所属行业
     * @Date 17:19 2017/12/25
     */
    public static ResultMsgStatus setTemplateIndustry(Industry id1, Industry id2){
        SettingIndustry sd = new SettingIndustry();
        sd.setIndustry_id1(id1.getId());
        sd.setIndustry_id2(id2.getId());
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_TEMPLATE_SET_INDUSTRY), JsonUtils.obj2Str(sd));
        return (ResultMsgStatus)JSONObject.toBean(jsonObject);
    }

    /**
     * @Author: tyz
     * @Description: 获取设置的行业信息
     * @Date 17:19 2017/12/25
     */
    public static IndustryInfo getTemplateIndustry(){
        String rstr = HttpClientUtils.getInstance().httpGet(addUriAccessTokenParam(URI_TEMPLATE_GET_INDUSTRY), null);
        return JsonUtils.str2Obj(rstr, IndustryInfo.class);
    }

    /**
     * @Author: tyz
     * @Description: 获取模板ID
     * @param templateNo 模板编号
     * @Date 17:19 2017/12/25
     */
    public static ResultTemplateStatus getTemplateId(String templateNo){
        Template template =  new Template();
        template.setTemplate_id_short(templateNo);
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_TEMPLATE_GET_ID), JsonUtils.obj2Str(template));
        return JsonUtils.json2Obj(jsonObject, ResultTemplateStatus.class);
    }

    /**
     * @Author: tyz
     * @Description: 获取模板列表
     * @Date 17:19 2017/12/25
     */
    public static List<Template> getTemplateList(){
        String str = HttpClientUtils.getInstance().httpGet(addUriAccessTokenParam(URI_TEMPLATE_GET_LIST), null);
        JSONObject jobj = JSONObject.fromObject(str);
        return JsonUtils.jsonArr2ObjArr(jobj.getJSONArray("template_list"), Template.class);
    }

    /**
     * @Author: tyz
     * @Description: 删除模板
     * @param templateId 模板ID
     * @Date 17:19 2017/12/25
     */
    public static ResultStatusMsg deleteTemplate(String templateId){
        Template template =  new Template();
        template.setTemplate_id(templateId);
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_TEMPLATE_DELETE), JsonUtils.obj2Str(template));
        return JsonUtils.json2Obj(jsonObject, ResultStatusMsg.class);
    }

    /**
     * @Author: tyz
     * @Description: 发送模板消息
     * @param msg 模板消息
     * @Date 17:19 2017/12/25
     */
    public static ResultTemplateMsg sendTemplateMsg(TemplateMsg msg){
        JSONObject jsonObject = HttpClientUtils.getInstance().httpPostJson(addUriAccessTokenParam(URI_TEMPLATE_SEND), JsonUtils.obj2Str(msg));
        return JsonUtils.json2Obj(jsonObject, ResultTemplateMsg.class);
    }

    /**
     * @Author: tyz
     * @Description: 获取js ticket
     * @Date 17:19 2017/12/25
     */
    public static AccessTicket wjs_getTicket(){
        String uri = addUriAccessTokenParam(URI_WJS_GET_TICKENT) + "&type=jsapi";
        String str = HttpClientUtils.getInstance().httpGet(uri, null);
        return JsonUtils.str2Obj(str, AccessTicket.class);
    }

    public static String wjs_urlSha1Signature(String noncestr, String timestamp, String url){
        AccessTicket accessTicket = wjs_getTicket();
        String str = "jsapi_ticket=" + accessTicket.getTicket() +
                "&noncestr=" + noncestr +
                "&timestamp=" + timestamp +
                "&url=" + url;
        //sb.append("&url=" + URLEncoder.encode(url));
        LogUtils.debug(str);
        return SHA1.getSha1(str);
    }

}