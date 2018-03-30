package test;

import com.tyz.weixin.model.menu.*;
import com.tyz.weixin.utils.JsonUtils;
import com.tyz.weixin.utils.LogUtils;
import com.tyz.weixin.utils.WxUtils;
import net.sf.json.JSONArray;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description:
 * @Date: 2017/12/8.
 * @Modified: tyz
 */
public class Test1 {

    @Test
    public void main1() throws Exception {
      //  String token = WxUtils.getToken(ConfPUtils.getProperty("appID"), ConfPUtils.getProperty("appsecret"));
     //   String token1 = WxUtils.getToken(ConfPUtils.getProperty("appID"), ConfPUtils.getProperty("appsecret"));
       // String token = "0k1HwXs4BMkHb3Ktw-Ml_YFfaeOHscsnbYJAB79IQB_uzKpX5gQOedR23mXoZ2VSkwTQ3ekZ8q_z2wAvmnh8aW1letfAkfZtcTAhssNrSWJji3Gbg-hp5lw1i3cDj2_1OHPaABAJCK";
        //WxUtils.getShortUri(token, "https://search.jikexueyuan.com/course/?q=%E5%BE%AE%E4%BF%A1&page=2")
        String menuStr = "{\n" +
                "     \"button\":[\n" +
                "     {    \n" +
                "          \"type\":\"click\",\n" +
                "          \"name\":\"今日歌曲\",\n" +
                "          \"key\":\"V1001_TODAY_MUSIC\"\n" +
                "      },\n" +
                "      {\n" +
                "           \"name\":\"菜单\",\n" +
                "           \"sub_button\":[\n" +
                "           {    \n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"体能体测\",\n" +
                "               \"url\":\"http://spcms.sjcqcs.com:90/\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"type\":\"click\",\n" +
                "               \"name\":\"赞一下我们\",\n" +
                "               \"key\":\"V1001_GOOD\"\n" +
                "            }]\n" +
                "       }]\n" +
                " }";

       // menuStr = new String(menuStr.getBytes("utf-8"), "gbk");
      //  System.out.println(WxUtils.createMenu(menuStr, token));
     //   System.out.println(menuStr);

        Button b1 = new ClickButton("dd", "V1001_TODAY_MUSIC");
        Button b21 = new ViewButton("aa","http://4b96ecca.ngrok.io");
        Button b23 = new ClickButton("bb","V1001_GOOD");
        List<Button> b2subs = new ArrayList<>();
        b2subs.add(b21);
        b2subs.add(b23);
        Button b2 = new Button("菜单2", b2subs);
        List<Button> menuBtns = new ArrayList<>();
        menuBtns.add(b1);
        menuBtns.add(b2);
        Menu menu = new Menu();
        menu.setButton(menuBtns);

        /*JSONObject menuJobj = JSONObject.fromObject(menu);
        JSONArray btnJArr = menuJobj.getJSONArray("button");
        btnJArr.getJSONObject(0).remove("sub_button");
        btnJArr.getJSONObject(1).getJSONArray("sub_button").getJSONObject(0).remove("sub_button");
        btnJArr.getJSONObject(1).getJSONArray("sub_button").getJSONObject(1).remove("sub_button");*/


        LogUtils.debug(JsonUtils.obj2Str(menu));

       MenuHandler.createMenu(menu);
    }

    @Test
    public void testMsg2Xml() throws Exception{
        StringBuilder str = new StringBuilder();
        str.append("<xml>");
        str.append("<name>");
        str.append("<![CDATA[aaaaaaaa]>");
        str.append("</name>");
        str.append("<age>");
        str.append(10);
        str.append("</age>");
        str.append("</xml>");

        String s = "<xml>\n" +
                "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                "<CreateTime>123456789</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[CLICK]]></Event>\n" +
                "<EventKey><![CDATA[EVENTKEY]]></EventKey>\n" +
                "</xml>";
        //Assert.assertTrue(User.class.getSuperclass() == Object.class);
        System.out.println(WxUtils.xml2Obj(Boy.class, s));
    }

    @Test
    public void testJsonUtil() throws Exception{
        /*Industry id1 = new Industry();
        id1.setFirst_class("aaa");
        id1.setSecond_class("bbb");

        Industry id2 = new Industry();
        id2.setFirst_class("aaaaaa");
        id2.setSecond_class("bbbbbb");

        IndustryInfo info = new IndustryInfo();
        info.setPrimary_industry(id1);
        info.setSecondary_industry(id2);

        System.out.println(JsonUtils.obj2Str(info));
        IndustryInfo info1 = JsonUtils.str2Obj(JsonUtils.obj2Str(info), IndustryInfo.class);
        System.out.println(info1);*/

        int[] aa = new int[]{1, 2, 3, 4};
        System.out.println(JSONArray.fromObject(aa).toString());
    }

    @Test
    public void testURLEncode() throws Exception{
        try {

            // 将普通字符创转换成application/x-www-from-urlencoded字符串
            String urlString = URLEncoder.encode("http://4b96ecca.ngrok.io", "UTF-8");  //输出%C4%E3%BA%C3
            System.out.println(urlString);

            // 将application/x-www-from-urlencoded字符串转换成普通字符串
            String keyWord = URLDecoder.decode(urlString, "UTF-8");
            System.out.println(keyWord);  //输出你好

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testJsTicket() throws Exception{
        LogUtils.debug(WxUtils.wjs_getTicket());
    }

    @Test
    public void testArrSort() throws Exception{
        String[] array = new String[] { "url", "noncestr", "timestamp", "jsapi_ticket" };
        StringBuffer sb = new StringBuffer();
        // 字符串排序
        Arrays.sort(array);
        for(String str :array){
            LogUtils.debug(str);
        }
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    @Test
    public void testJsUrlSha1() throws Exception{
            LogUtils.debug(WxUtils.wjs_urlSha1Signature("45000", new Date().getTime()+"", "http://www.baidu.com"));
    }
}
