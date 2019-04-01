package com.shanghaiyudao.http;

public interface JsessionService{
    /**
     *根据根据账户和密码获得jsession
     */
    String getJsession(String account,String password);
}
