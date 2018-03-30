package com.tyz.weixin.model.event;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 上报地理位置事件
 * @Date: 2017/12/21.
 * @Modified: tyz
 */
public class LocEvent extends Event{
    private String Latitude; //地理位置纬度
    private String Longitude; //地理位置经度
    private String Precision; //地理位置精度

    public LocEvent() {
        super();
    }


    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }
}
