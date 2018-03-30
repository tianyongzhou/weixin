package com.tyz.weixin.model.msg.mass;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 群发速度
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class Speed {
    public static final int SPEED_LEVEL_1ST = 0; //80w/分钟
    public static final int SPEED_LEVEL_2ED = 1; //60w/分钟
    public static final int SPEED_LEVEL_3RD = 2; //45w/分钟
    public static final int SPEED_LEVEL_4TH = 3; //30w/分钟
    public static final int SPEED_LEVEL_5TH = 4; //10w/分钟

    private int speed; //群发速度的级别
    private int realspeed; //群发速度的真实值 单位：万/分钟

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRealspeed() {
        return realspeed;
    }

    public void setRealspeed(int realspeed) {
        this.realspeed = realspeed;
    }
}
