<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%--<%@ page import="com.tyz.weixin.utils.WxUtils" %>
<%@ page import="java.util.*" %>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<meta charset="UTF-8">
<%--<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover">--%>
<link rel="icon" type="image/png" href="<%=basePath%>/img/logo_ico.png">
<title>微信测试网站</title>
<link rel="stylesheet" href="<%=basePath%>/css/jquery-weui.css"/>
<script src="<%=basePath%>/js/lib/jquery-2.1.4.js"></script>
<script src="<%=basePath%>/js/lib/jquery-weui.js"></script>
<script src="<%=basePath%>/js/lib/fastclick.js"></script>
<script src="<%=basePath%>/js/lib/jweixin-1.2.0.js"></script>
<script src="<%=basePath%>/js/lib/CommonUtil.js"></script>
<style>
</style>
<body>
<button id="onMenuShareTimeline" style="width: 120px; height: 30px; background-color: #0BB20C;">分享到朋友圈</button>
</body>
<script>
    $(function ()
    {
        var data = {url:"http://f4239eeb.ngrok.io/test.jsp"};
        var jsonStr = JSON.stringify(data);
        SQ.CommonUtil.ajaxJsonHttpReq("/js_signature.sq","post", jsonStr, function (data)
        {
            wx.config({
                debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId: 'wx1ce718cd5ed65b66', // 必填，公众号的唯一标识
                timestamp: data.timestamp, // 必填，生成签名的时间戳
                nonceStr: data.noncestr, // 必填，生成签名的随机串
                signature: data.sig,// 必填，签名，见附录1
                jsApiList: ['scanQRCode','onMenuShareAppMessage','onMenuShareTimeline'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
            });
            wx.error(function(res){
                console.log(res);
            });
            wx.ready(function(msg){

            });
            $("#onMenuShareTimeline").click(function () {
                //分享接口
                wx.scanQRCode({
                    needResult: 0, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
                    scanType: ["qrCode","barCode"], // 可以指定扫二维码还是一维码，默认二者都有
                    success: function (res) {
                        var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
                        alert(result);
                    }
                });
            });
        },function (e) {
            console.log(e);
        });
    });
</script>
