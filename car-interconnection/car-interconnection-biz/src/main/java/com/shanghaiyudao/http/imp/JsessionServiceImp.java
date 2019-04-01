package com.shanghaiyudao.http.imp;

import com.alibaba.fastjson.JSONObject;
import com.shanghaiyudao.http.JsessionService;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;
@Service
public class JsessionServiceImp implements JsessionService {

    @Override
    public String getJsession(String account, String password) {
        System.out.println("开始调用登陆minieye接口--------------------------------------------");
        //创建默认的Httpclient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post请求
        HttpPost post = new HttpPost("http://39.108.194.249/StandardApiAction_login.action");
        //创建参数列表
        List params = new ArrayList<>();
        params.add(new BasicNameValuePair("account",account));
        params.add(new BasicNameValuePair("password",password));
        UrlEncodedFormEntity entity;
        try {
            //设置参数的编码方式
            entity= new UrlEncodedFormEntity(params,"UTF-8");
            post.setEntity(entity);
            System.out.println("url:"+post.getURI());
            try {
                //执行post请求
                CloseableHttpResponse response = httpClient.execute(post);
                //获取响应实体
                HttpEntity responseEntity = response.getEntity();
                if(responseEntity != null){
                    JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(responseEntity));
                    System.out.println("调用接口完成，返回值为："+jsonObject);
                    return jsonObject.getString("jsession");
                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
