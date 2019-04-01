package com.shanghaiyudao;

import com.alibaba.fastjson.JSONObject;
import com.shanghaiyudao.http.JsessionService;
import com.shanghaiyudao.http.imp.LocationServiceImp;
import com.shanghaiyudao.user.dao.UserInfoDao;
import com.shanghaiyudao.user.module.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarInterconnectionDeployApplicationTests {
    @Autowired
    UserInfoDao userInfoDao;
    @Autowired
    RedisTemplate jsonRedisTemplate;
    @Autowired
    JsessionService jsessionService;
    @Autowired
    LocationServiceImp locationServiceImp;
    @Test
    public void location(){
        String jsession = jsessionService.getJsession("shyd", "000000");
        JSONObject jsonObject = locationServiceImp.getLocation(jsession, "013300372728", 2);
        System.out.println(jsonObject);
    }
//    @Test
//    public void json(){
//        String json="{\"result\":0,\"jsession\":\"f01aea97-b06b-428f-b463-6ad903c44991\",\"account_name\":\"上海舆道\",\"JSESSIONID\":\"f01aea97-b06b-428f-b463-6ad903c44991\"}";
//        JSONObject jsonObject = JSONObject.parseObject(json);
//        String jsession = jsonObject.getString("jsession");
//        System.out.println("jsession"+jsession);
//    }
//    @Test
//    public void http2(){
//        System.out.println(jsessionService);
//        String jsession = jsessionService.getJsession("shyd", "000000");
//        System.out.println(jsession);
//    }
//    @Test
//    public void http(){
//        //创建默认的Httpclient实例
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        //创建post请求
//        HttpPost post = new HttpPost("http://39.108.194.249/StandardApiAction_login.action");
//        //创建参数队列
//        List params = new ArrayList<>();
//        params.add(new BasicNameValuePair("account", "shyd"));
//        params.add(new BasicNameValuePair("password", "000000"));
//        UrlEncodedFormEntity entity;
//        try {
//        //设置参数的编码方式
//            entity = new UrlEncodedFormEntity(params,"UTF-8");
//            post.setEntity(entity);
//            System.out.println("url:"+post.getURI());
//            try {
//                // 执行post请求
//                CloseableHttpResponse response = httpclient.execute(post);
//                //获取响应实体
//                HttpEntity etity = response.getEntity();
//                if(etity != null){
//                    JSONObject jsonObject = JSONObject.parseObject(EntityUtils.toString(etity, "UTF-8"));
//                    System.out.println(jsonObject);
//                    String jsessionid = jsonObject.getString("JSESSIONID");
//                    System.out.println(jsessionid);
//                    //打印响应内容
//                //System.out.println("Response content: " + EntityUtils.toString(etity, "UTF-8"));
//                }
//                response.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            httpclient.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void redis(){
//        //操作字符串
//        UserInfo userInfo = userInfoDao.selectUserInfoByUsername("root");
//        jsonRedisTemplate.opsForValue().set("user",userInfo);
//        System.out.println(jsonRedisTemplate.toString());
//        jsonRedisTemplate.opsForValue().set("name2","qiangzi");
//        jsonRedisTemplate.opsForValue().append("name2", "hah");
//        System.out.println("String:"+jsonRedisTemplate.opsForValue().get("name2"));//qiangzi
//        //操作map
//        jsonRedisTemplate.opsForHash().put("myhash","name1","jinhan1");
//        System.out.println("myhash:"+jsonRedisTemplate.opsForHash().get("myhash","name1"));
//        //redisTemplate.opsForHash().delete("myhash","name");
//        System.out.println("myhash:"+jsonRedisTemplate.opsForHash().get("myhash","name1"));
//    }
//    @Test
//    public void contextLoads() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("username","root");
//        List<UserInfo> infoList = userInfoDao.selectByMap(map);
//        log.info(infoList.toString());
//    }


}
