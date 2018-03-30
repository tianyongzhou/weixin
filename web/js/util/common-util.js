/**
 * Created by GZXS on 2016/6/24.
 */
define([], function () {
    return SQ;
});

//常用工具类
SQ = {};
SQ.CommonUtil = {
    debug:true
};

SQ.CommonUtil.log = function(info){
    if(SQ.CommonUtil.debug){
        console.log("-------------------------------");
        console.log(info);
        console.log("===============================");
    }
}

/**
 * 在窗口窗口中添加加载条标签
 * @param jParentEle 父jquery元素
 * @param idTag 加载条的ID标签值
 */
SQ.CommonUtil.loadProgressCircleTag = function (jParentEle, idTag){
    var loaderTag = '<div id="'+idTag+'" class="sq_load_container">'+
        '<div class="sq_l_spinner">'+
        '<div class="sq_l_spinner-container sq_l_container1">'+
        '<div class="sq_l_circle1"></div>'+
        '<div class="sq_l_circle2"></div>'+
        '<div class="sq_l_circle3"></div>'+
        '<div class="sq_l_circle4"></div>'+
        '</div>'+
        '<div class="sq_l_spinner-container sq_l_container2">'+
        '<div class="sq_l_circle1"></div>'+
        '<div class="sq_l_circle2"></div>'+
        '<div class="sq_l_circle3"></div>'+
        '<div class="sq_l_circle4"></div>'+
        '</div>'+
        '<div class="sq_l_spinner-container sq_l_container3">'+
        '<div class="sq_l_circle1"></div>'+
        '<div class="sq_l_circle2"></div>'+
        '<div class="sq_l_circle3"></div>'+
        '<div class="sq_l_circle4"></div>'+
        '</div>'+
        '</div>'+
        '</div>';
    jParentEle.append(loaderTag);
}

//-------------------------------------------------------------------------------
SQ.CommonUtil.isStrEmpty = function(str){
    if(str==null || str==''|| str=="undefined" || ((str+'').replace(/(^\s*)|(\s*$)/g,'')=='') || ((str+'').replace(/[\r\n]/g, '')=='')){ //去掉前后空格、换行
        return true;
    }
    return false;
}

//显示模糊进度UI
SQ.CommonUtil.showLoader = function(){
    $("#sq_load_container").css({
        "display":"block"
    });
}

//隐藏模糊进度UI
SQ.CommonUtil.hideLoader = function(){
    $("#sq_load_container").css({
        "display":"none"
    });
}

//ajax请求数据
SQ.CommonUtil.ajaxJsonHttpReq = function(url, method, data, succCallback, failCallback){
    $.ajax({
        type: method,
        async: true,
        timeout:100*1000,
        url: url,
        dataType: "json",
        data:data,
        success: succCallback,
        error:failCallback
    });
}

//ajax请求数据
SQ.CommonUtil.ajaxJsonPHttpReq = function(url, action, data, succCallback, failCallback){
    $.ajax({
        type: "post",
        async: true,
        timeout:100*1000,
        url: url + "/" + action+ "?jsoncallback=?",
        dataType: "jsonp",
        data:data,
        success: succCallback,
        error: failCallback
    });
}

/**
 * 格式化数字，用逗号分隔
 * @param s 数字字符串
 * @param n 保留小数位数
 * @returns {string}
 */
SQ.CommonUtil.formatNumber = function(s, n){
    n = n > 0 && n <= 20 ? n : 2;
    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
    var l = s.split(".")[0].split("").reverse(),
        r = s.split(".")[1];
    t = "";
    for(i = 0; i < l.length; i ++ )
    {
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
    }
    return t.split("").reverse().join("") + "." + r;
}

/**
 * 格式化字符串格式化为数字
 * @param s
 * @returns {*}
 */
SQ.CommonUtil.rformatNumber = function(s){
    return parseFloat(s.replace(/[^\d\.-]/g, ""));
}

// 获取范围内的随机数
// min - 范围下限
// max - 范围上限
// decimalNum - 返回结果的小数位数。如果为 0，返回整数。
SQ.CommonUtil.getRandomNumber = function (min, max, decimalNum){
    var rNum = min+Math.random()*(max-min);
    return parseFloat(rNum).toFixed(decimalNum);
}

/**
 * 打开Dialog
 * @param title
 * @param iconCls
 * @param content
 * @param closeCallback
 * @param cancelCallback
 */
SQ.CommonUtil.openConfigDialog = function(title, content,okCallback, cancelCallback){
    SQ.CommonUtil.closeDialog('sq_main_config_dialog');
    var fcon = '<div style="text-align: center;color: #ee8286;vertical-align: middle;box-sizing: border-box;padding-top: 30px;font-size: 18px;">'+content+'</div>';
    SQ.CommonUtil.closeDialog("sq_main_config_dialog");
    var divTag = "<div id='sq_main_config_dialog'></div>";
    $("#sq_main").append(divTag);
    var $_dl = $('#sq_main_config_dialog');
    $_dl.dialog({
        title: SQ.CommonUtil.strIsEmpty(title)?"确认框":title,
        width: 400,
        height: 200,
        closed: true,
        modal:true,
        shadow:false,
        cache: false,
        content:fcon,
        buttons: [{
            text:'&nbsp;&nbsp;&nbsp;&nbsp;确认&nbsp;&nbsp;&nbsp;&nbsp;',
           /* iconCls:'icon-ok',*/
            handler:function(){
                SQ.CommonUtil.closeDialog("sq_main_config_dialog");
                if(okCallback){
                    okCallback();
                }
            }
        },{
            text:'&nbsp;&nbsp;&nbsp;&nbsp;取消&nbsp;&nbsp;&nbsp;&nbsp;',
            handler:function(){
                SQ.CommonUtil.closeDialog("sq_main_config_dialog");
                if(cancelCallback){
                    cancelCallback();
                }
            }
        }]
    }).dialog('open');
}

/**
 * 打开Dialog
 * @param id
 * @param title
 * @param iconCls
 * @param content
 * @param width
 * @param height
 * @param left
 * @param top
 * @param closeCallback
 */
SQ.CommonUtil.openDialog = function(id, title, iconCls, content, resizable, maximizable, modal, width, height, left, top, closeCallback, maximizeCallback, minimizeCallback,restoreCallback, maximized,noclosed,noclosable){
    SQ.CommonUtil.closeDialog(id);
    var divTag = "<div id="+id+"></div>";
    $("#sq_main").append(divTag);
    var $_dl = $('#' + id);
    $_dl.dialog({
        title: title,
        width: width,
        height: height,
        left:left,
        top:top,
        closed: noclosed?false:true,
        closable: noclosable?false:true,
        maximized:maximized?true:false,
        maximizable:maximizable,
        onRestore:restoreCallback,
        modal:modal,
        shadow:false,
        resizable:resizable,
        iconCls:iconCls,
        cache: false,
        content:content,
        onClose:closeCallback,
        onMaximize:maximizeCallback,
        onMinimize:minimizeCallback
    }).dialog('open');
}

/**
 * 关闭窗口
 * @param id
 */
SQ.CommonUtil.closeDialog = function(id){
    if(document.getElementById(id)){
        try{
            $('#'+id).dialog("destroy");
        }catch (e){};
        $('#'+id).parent().remove();
    }
}

//弹出信息
SQ.CommonUtil.showMsgDialog = function(title, content,timeout){
    $.messager.show({
        title:SQ.CommonUtil.isStrEmpty(title)?"温馨提示":title,
        closable: false,
        msg:content,
        timeout:timeout==null?1200:timeout,
        showType:'fade',
         style:{
             right:'',
             bottom:''
         }
    });
}

/**
 * 日期格式化 yyyy-MM-dd格式日期
 * @param date
 * @returns {string}
 */
SQ.CommonUtil.dateFormatStr = function (date){
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}

/**
 * 获取当前年份
 * @returns {number}
 */
SQ.CommonUtil.getCurYear = function (){
    return new Date().getFullYear();
}

/**
 * 日期解析器 yyyy-MM-dd格式日期
 * @param s
 * @returns {Date}
 */
SQ.CommonUtil.strParserDate = function(s){
    if (!s) return null;
    var ss = s.split('-');
    var y = parseInt(ss[0],10);
    var m = parseInt(ss[1],10);
    var d = parseInt(ss[2],10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
        return new Date(y,m-1,d);
    } else {
        return null;
    }
}

SQ.CommonUtil.getAgeByBirthday = function (birthday) {
    if(SQ.CommonUtil.strIsEmpty(birthday)){
        return null;
    }
    var bYear = birthday.getYear();
    var bMonth = birthday.getMonth() + 1;
    var bDay = birthday.getDate();

    var d = new Date();
    var nYear = d.getYear();
    var nMonth = d.getMonth() + 1;
    var nDay = d.getDate();

    if(nYear == bYear){
        return 0;
    }
    var ageDiff = nYear - bYear;
    if(ageDiff < 0) {
        return null;
    }
    if (nMonth == bMonth){
        var dayDiff = nDay - bDay;
        if (dayDiff < 0) {
            return ageDiff - 1;
        }
        return ageDiff;
    }
    var monthDiff = nMonth - bMonth;
    if (monthDiff < 0) {
        return ageDiff - 1;
    }
    return ageDiff;
}

/**
 *  日期字符串格式验证
 * @param strDate
 * @returns {boolean}
 */
SQ.CommonUtil.dateStrValidator = function (strDate) {
    var date = strDate;
    var result = date.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
    if (result == null){
        return false;
    }
    var d = new Date(result[1], result[3] - 1, result[4]);
    return (d.getFullYear() == result[1] && (d.getMonth() + 1) == result[3] && d.getDate() == result[4]);
}

/**
 * Long类型 转化为 yyyy-MM-dd格式日期
 */
SQ.CommonUtil.longDate2DateStr = function(longDate){
    var date = new Date();
    date.setTime(longDate);
     return SQ.CommonUtil.dateFormatStr(date);
}

//判断字符串是是否为空
SQ.CommonUtil.strIsEmpty = function(rawData){
    if(null==rawData || ""==rawData || ""==((""+rawData).trim()) || "undefined"==rawData){
        return true;
    }
    return false;
}

//处理字符串两边的空格
SQ.CommonUtil.strTrim = function(rawData){
    if(null==rawData || "undefined"==rawData){
        return "";
    }
    return (rawData + "").trim();
}