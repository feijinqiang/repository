package com.shanghaiyudao.http;


import com.alibaba.fastjson.JSONObject;

/**
 * 获取车辆位置接口
 */
public interface LocationService {
    JSONObject getLocation(String jsession, String vehiIdno, Number toMap);
}
