<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover">
<link rel="icon" type="image/png" href="<%=basePath%>/img/logo_ico.png">
<title>微信测试网站</title>
<link rel="stylesheet" href="<%=basePath%>/css/jquery-weui.css"/>
<script src="<%=basePath%>/js/lib/jquery-2.1.4.js"></script>
<script src="<%=basePath%>/js/lib/jquery-weui.js"></script>
<script src="<%=basePath%>/js/lib/fastclick.js"></script>
<script src="<%=basePath%>/js/lib/jweixin-1.2.0.js"></script>
<script src="<%=basePath%>/js/lib/CommonUtil.js"></script>
<style>
  body{
    padding: 5px;
  }
</style>
<body>
<button id="onMenuShareTimeline" style="width: 100px; height: 30px; background-color: #0BB20C;">分享到朋友圈</button>
<button id="scanQRCode" style="width: 100px; height: 30px; background-color: #0BB20C;">扫一扫</button>
<button id="chooseImage" style="width: 100px; height: 30px; background-color: #0BB20C;">选图</button>
<button id="previewImage" style="width: 100px; height: 30px; background-color: #0BB20C;">预览图片</button>
<button id="uploadImage" style="width: 100px; height: 30px; background-color: #0BB20C;">上传图片</button>
<button id="downloadImage" style="width: 100px; height: 30px; background-color: #0BB20C;">图片下载</button>
<button id="getLocalImgData" style="width: 100px; height: 30px; background-color: #0BB20C;">获取本地图片</button>

<button id="startRecord" style="width: 100px; height: 30px; background-color: #0BB20C;">开始录音</button>
<button id="stopRecord" style="width: 100px; height: 30px; background-color: #0BB20C;">停止录音</button>
<button id="getNetworkType" style="width: 100px; height: 30px; background-color: #0BB20C;">获取网络状态</button>

<button id="getLocation" style="width: 100px; height: 30px; background-color: #0BB20C;">获取地理位置</button>
<button id="openLocation" style="width: 100px; height: 30px; background-color: #0BB20C;">查看位置</button>

<button id="startSearchBeacons" style="width: 100px; height: 30px; background-color: #0BB20C;">查找周边ibeacon设备</button>
<button id="stopSearchBeacons" style="width: 100px; height: 30px; background-color: #0BB20C;">关闭ibeacon设备</button>
<button id="openProductSpecificView" style="width: 100px; height: 30px; background-color: #0BB20C;">跳转微信商品页</button>

<img id="img_downloadImage">
</body>
<script>
  var locImglocalId = "";
  var _location = {
      latitude:null,// 纬度，浮点数，范围为90 ~ -90
      longitude:null, // 经度，浮点数，范围为180 ~ -180。
      speed:null, // 速度，以米/每秒计
      accuracy:null // 位置精度
  };
    $(function ()
    {
        var data = {url:"http://b5618ccd.ngrok.io/"};
        var jsonStr = JSON.stringify(data);
        SQ.CommonUtil.ajaxJsonHttpReq("/js_signature.sq","post", jsonStr, function (data)
        {
            wx.config({
                debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId: 'wx1ce718cd5ed65b66', // 必填，公众号的唯一标识
                timestamp: data.timestamp, // 必填，生成签名的时间戳
                nonceStr: data.noncestr, // 必填，生成签名的随机串
                signature: data.sig,// 必填，签名，见附录1
                jsApiList: [
                    'onMenuShareTimeline', 'scanQRCode','chooseImage','previewImage','uploadImage','downloadImage','getLocalImgData',
                    'startRecord','stopRecord','onVoiceRecordEnd','playVoice','pauseVoice','stopVoice','onVoicePlayEnd','uploadVoice','downloadVoice','translateVoice',
                    'getNetworkType','openLocation','getLocation','startSearchBeacons','stopSearchBeacons','onSearchBeacons','openProductSpecificView'
                ]
            });
            wx.error(function(res){
                console.log(res);
            });
            wx.ready(function(msg){
            });
        },function (e) {
            console.log(e);
        });

        //分享到朋友圈, 当点击 分享到朋友圈 按钮后需要设置的内容所以最好是提前设置，可在wx.ready中设置，其他：onMenuShareAppMessage onMenuShareQQ
        $("#onMenuShareTimeline").click(function () {
            wx.onMenuShareTimeline({
                title: '测试', // 分享标题
                link: 'http://f4239eeb.ngrok.io/hello.jsp', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
                imgUrl: 'http://f4239eeb.ngrok.io/img/logo_ico.png', // 分享图标，应该是一个绝对地址
                success: function (msg) {
                    alert(msg);
                    // 用户确认分享后执行的回调函数
                },
                cancel: function (msg) {
                    // 用户取消分享后执行的回调函数
                    alert(msg);
                }
            });
        });

        //扫一扫
        $("#scanQRCode").click(function () {
            wx.scanQRCode({
                needResult: 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
                scanType: ["qrCode","barCode"], // 可以指定扫二维码还是一维码，默认二者都有
                success: function (res) {
                    var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
                    alert(result);
                }
            });
        });

        //选图
        $("#chooseImage").click(function () {
            wx.chooseImage({
                count: 1, // 默认9
                sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
                sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
                success: function (res) {
                    var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
                    locImglocalId = res.localIds[0].toString();
                    alert(res);
                }
            });
        });

        //预览图片
        //https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3407784717,2395060724&fm=27&gp=0.jpg
        //https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1518576106&di=0a6d2a8debc3968c4fa6120d086c0d0a&imgtype=jpg&er=1&src=http%3A%2F%2Fpic39.nipic.com%2F20140326%2F11601387_113222906000_2.jpg
        $("#previewImage").click(function () {
            wx.previewImage({
                current: 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3407784717,2395060724&fm=27&gp=0.jpg', // 当前显示图片的http链接
                urls: ['https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3407784717,2395060724&fm=27&gp=0.jpg','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2086448113,3001896517&fm=27&gp=0.jpg'] // 需要预览的图片http链接列表
            });
        });

        //上传图片
        $("#uploadImage").click(function () {
            wx.chooseImage({
                count: 1, // 默认9
                sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
                sourceType: ['album'], // 可以指定来源是相册还是相机，默认二者都有
                success: function (res) {
                    //var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
                    var localId = res.localIds[0].toString();
                    wx.uploadImage({
                        localId: localId+"", // 需要上传的图片的本地ID，由chooseImage接口获得
                        isShowProgressTips: 1, // 默认为1，显示进度提示
                        success: function (res) {
                            var serverId = res.serverId; //返回图片的服务器端ID
                            alert(serverId);
                            //$(".myimg").attr("src", localIds);
                        },
                        fail:function (msg) {
                            alert(msg);
                        }
                    });
                }
            });
        });

        //图片下载
        $("#downloadImage").click(function () {
            wx.chooseImage({
                count: 1, // 默认9
                sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
                sourceType: ['album'], // 可以指定来源是相册还是相机，默认二者都有
                success: function (res) {
                    //var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
                    var localId = res.localIds[0].toString();
                    wx.uploadImage({
                        localId: localId+"", // 需要上传的图片的本地ID，由chooseImage接口获得
                        isShowProgressTips: 1, // 默认为1，显示进度提示
                        success: function (res) {
                            var serverId = res.serverId; //返回图片的服务器端ID
                            wx.downloadImage({
                                serverId: serverId, // 需要下载的图片的服务器端ID，由uploadImage接口获得
                                isShowProgressTips: 1, // 默认为1，显示进度提示
                                success: function (res) {
                                    var localId = res.localId; // 返回图片下载后的本地ID
                                    $("#img_downloadImage").attr("src", localId);
                                    $("#img_downloadImage").css({
                                        'width':'300px',
                                        'height':'100px'
                                    });
                                    alert(localId);
                                }
                            });
                        },
                        fail:function (msg) {
                            alert(msg);
                        }
                    });
                }
            });
        });

        //获取本地图片
        $("#getLocalImgData").click(function () {
            if(locImglocalId=="" || locImglocalId==null){
                alert("请先选择图片");
                return;
            }
            wx.getLocalImgData({
                localId: locImglocalId, // 图片的localID
                success: function (res) {
                    var localData = res.localData; // localData是图片的base64数据，可以用img标签显示
                    $("#img_downloadImage").attr("src", localData);
                    $("#img_downloadImage").css({
                        'width':'300px',
                        'height':'100px'
                    });
                    alert(localData);
                }
            });
        });

        //开始录音
        $("#startRecord").click(function () {
            wx.startRecord();

            wx.onVoiceRecordEnd({
                // 录音时间超过一分钟没有停止的时候会执行 complete 回调
                complete: function (res) {
                    var localId = res.localId;
                    wx.playVoice({
                        localId: localId // 需要播放的音频的本地ID，由stopRecord接口获得
                    });
                }
            });
        });

        //停止录音
        $("#stopRecord").click(function () {
            wx.stopRecord({
                success: function (res)
                {
                    var localId = res.localId;
                    wx.uploadVoice({
                        localId: localId, // 需要上传的音频的本地ID，由stopRecord接口获得
                        isShowProgressTips: 1, // 默认为1，显示进度提示
                        success: function (sres) {
                            var serverId = sres.serverId; // 返回音频的服务器端ID
                            alert("录音上传成功:"+serverId);
                            wx.playVoice({
                                localId: localId
                            });
                        }
                    });
                }
            });
        });

        //获取网络状态
        $("#getNetworkType").click(function () {
            wx.getNetworkType({
                success: function (res) {
                    var networkType = res.networkType; // 返回网络类型2g，3g，4g，wifi
                    alert(networkType);
                }
            });
        });

        $("#getLocation").click(function () {
            wx.getLocation({
                type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
                success: function (res) {
                    _location.latitude =res.latitude;// 纬度，浮点数，范围为90 ~ -90
                    _location.longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
                    _location.speed = res.speed; // 速度，以米/每秒计
                    _location.accuracy = res.accuracy; // 位置精度

                    alert(JSON.stringify(res));
                }
            });
        });

        $("#openLocation").click(function () {
            if(_location.latitude == null){
                alert("先点击获取地理位置");
                return;
            }
            wx.openLocation({
                latitude: _location.latitude, // 纬度，浮点数，范围为90 ~ -90
                longitude: _location.longitude, // 经度，浮点数，范围为180 ~ -180。
                name: '测试位置', // 位置名
                address: "测试详细地址", // 地址详情说明
                scale: 1, // 地图缩放级别,整形值,范围从1~28。默认为最大
                infoUrl: 'http://www.baidu.com' // 在查看位置界面底部显示的超链接,可点击跳转
            });
        });

        $("#startSearchBeacons").click(function () {
            wx.onSearchBeacons({
                complete:function(argv){
                    //回调函数，可以数组形式取得该商家注册的在周边的相关设备列表
                    alert(JSON.stringify(argv));
                }
            });
            wx.startSearchBeacons({
                ticket:"http://www.baidu.com",  //摇周边的业务ticket, 系统自动添加在摇出来的页面链接后面
                complete:function(argv){
                    //开启查找完成后的回调函数
                    alert(JSON.stringify(argv));
                }
            });
        });

        $("#stopSearchBeacons").click(function () {
            wx.stopSearchBeacons({
                complete:function(res){
                  //关闭查找完成后的回调函数
                    alert(JSON.stringify(res));
                }
            });
        });

        $("#openProductSpecificView").click(function () {
            wx.openProductSpecificView({
                productId: '53', // 商品id
                viewType: '1' // 0.默认值，普通商品详情页1.扫一扫商品详情页2.小店商品详情页
            });
        });
    });
</script>
