package com.shanghaiyudao.http.imp;

import com.alibaba.fastjson.JSONObject;
import com.shanghaiyudao.http.LocationService;
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
public class LocationServiceImp implements LocationService {
    @Override
    public JSONObject getLocation(String jsession, String vehiIdno, Number toMap) {
        System.out.println("开始调用定位车辆的minieye接口----------------------------------------------");
        //创建默认的httpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post请求对象
        HttpPost post = new HttpPost("http://39.108.194.249/StandardApiAction_vehicleStatus.action");
        //创建参数集合
        List params = new ArrayList<>();
        params.add(new BasicNameValuePair("jsession",jsession));
        params.add(new BasicNameValuePair("vehiIdno",vehiIdno));
        params.add(new BasicNameValuePair("toMap",toMap.toString()));
        UrlEncodedFormEntity entity;
        try {
            entity = new UrlEncodedFormEntity(params, "UTF-8");
            post.setEntity(entity);
            CloseableHttpResponse response = httpClient.execute(post);
            HttpEntity responseEntity = response.getEntity();

            if (responseEntity != null){
                JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(responseEntity));
                return jsonObject;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
