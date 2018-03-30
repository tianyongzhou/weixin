package com.tyz.weixin.model.event;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 菜单事件
 * @Date: 2018/2/1.
 * @Modified: tyz
 */
public class MenuEvent {
    /**
     * @Version 1.0
     * @Author: tyz
     * @Description: 点击 菜单事件
     * @Date: 2017/12/21.
     * @Modified: tyz
     */
    public class MenuClickEvent extends ClickEvent{
    }

    /**
     * @Version 1.0
     * @Author: tyz
     * @Description: 弹出地理位置选择器的事件推送  location_select
     * @Date: 2017/12/21.
     * @Modified: tyz
     */
    public class MenuLocSelectEvent extends MenuClickEvent {
        private String SendLocationInfo; //发送的位置信息
        private String Location_X; //X坐标信息
        private String Location_Y; //Y坐标信息
        private String Scale; //精度，可理解为精度或者比例尺、越精细的话 scale越高
        private String Label; //地理位置的字符串信息
        private String Poiname; //朋友圈POI的名字，可能为空

        public String getSendLocationInfo() {
            return SendLocationInfo;
        }

        public void setSendLocationInfo(String sendLocationInfo) {
            SendLocationInfo = sendLocationInfo;
        }

        public String getLocation_X() {
            return Location_X;
        }

        public void setLocation_X(String location_X) {
            Location_X = location_X;
        }

        public String getLocation_Y() {
            return Location_Y;
        }

        public void setLocation_Y(String location_Y) {
            Location_Y = location_Y;
        }

        public String getScale() {
            return Scale;
        }

        public void setScale(String scale) {
            Scale = scale;
        }

        public String getLabel() {
            return Label;
        }

        public void setLabel(String label) {
            Label = label;
        }

        public String getPoiname() {
            return Poiname;
        }

        public void setPoiname(String poiname) {
            Poiname = poiname;
        }
    }

    /**
     * @Version 1.0
     * @Author: tyz
     * @Description: 拍照发图的事件事件 pic_sysphoto pic_photo_or_album pic_weixin
     * @Date: 2017/12/21.
     * @Modified: tyz
     */
    public class MenuPicEvent extends MenuClickEvent{
        private String SendPicsInfo; //	发送的图片信息
        private String Count; //	发送的图片数量
        private String PicList; //	图片列表
        private String PicMd5Sum; //图片的MD5值，开发者若需要，可用于验证接收到图片

        public String getSendPicsInfo() {
            return SendPicsInfo;
        }

        public void setSendPicsInfo(String sendPicsInfo) {
            SendPicsInfo = sendPicsInfo;
        }

        public String getCount() {
            return Count;
        }

        public void setCount(String count) {
            Count = count;
        }

        public String getPicList() {
            return PicList;
        }

        public void setPicList(String picList) {
            PicList = picList;
        }

        public String getPicMd5Sum() {
            return PicMd5Sum;
        }

        public void setPicMd5Sum(String picMd5Sum) {
            PicMd5Sum = picMd5Sum;
        }
    }

    /**
     * @Version 1.0
     * @Author: tyz
     * @Description: 扫码推事件的事件推送 scancode_push & scancode_waitmsg
     * @Date: 2017/12/21.
     * @Modified: tyz
     */
    public class MenuScanCodeEvent extends MenuClickEvent{
        private String ScanCodeInfo; //扫描信息
        private String ScanType; //扫描类型，一般是qrcode
        private String ScanResult; //扫描结果，即二维码对应的字符串信息

        public String getScanCodeInfo() {
            return ScanCodeInfo;
        }

        public void setScanCodeInfo(String scanCodeInfo) {
            ScanCodeInfo = scanCodeInfo;
        }

        public String getScanType() {
            return ScanType;
        }

        public void setScanType(String scanType) {
            ScanType = scanType;
        }

        public String getScanResult() {
            return ScanResult;
        }

        public void setScanResult(String scanResult) {
            ScanResult = scanResult;
        }
    }

    /**
     * @Version 1.0
     * @Author: tyz
     * @Description: 点击菜单跳转链接事件
     * @Date: 2017/12/21.
     * @Modified: tyz
     */
    public class MenuViewEvent extends MenuClickEvent{
        private String MenuID;

        public String getMenuID() {
            return MenuID;
        }

        public void setMenuID(String menuID) {
            MenuID = menuID;
        }

    }
}
