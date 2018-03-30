package com.tyz.weixin.vo;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description:
 * @Date: 2017/12/19.
 * @Modified: tyz
 */
public class AccessToken {
    private long expires_in;
    private String access_token;

    public AccessToken() {
    }

    public AccessToken(long expiresIn, String accessToken) {
        this.expires_in = expiresIn;
        this.access_token = accessToken;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

}
