package com.shanghaiyudao.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther: fjq
 * @2019/3/27 15:48
 * @description: druid配置类(引入druid数据源、配置后台管理Servlet、配置后台请求过滤器)
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
    /**
     * @auther: fjq
     * @2019/3/29 9:08
     * @description: 配置druid后台管理Servlet和拦截请求过滤器
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //配置初始化参数
        Map<String,String> paramsMap = new HashMap<>();
        paramsMap.put(StatViewServlet.PARAM_NAME_USERNAME,"shyd");
        paramsMap.put(StatViewServlet.PARAM_NAME_PASSWORD,"shyd");
        paramsMap.put(StatViewServlet.PARAM_NAME_ALLOW,"");//""标识允许所有ip访问
        paramsMap.put(StatViewServlet.PARAM_NAME_DENY,"192.168.10.1");
        bean.setInitParameters(paramsMap);
        return bean;
    }
    /**
     * @auther: fjq
     * @2019/3/29 9:22
     * @description: 配置一个后台请求的过滤器
     */
    @Bean
    public FilterRegistrationBean filter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        //设置初始化请求参数
        Map<String,String> paramsMap=new HashMap();
        paramsMap.put(WebStatFilter.PARAM_NAME_EXCLUSIONS,"*.js,*.css,/druid/*");
        bean.setInitParameters(paramsMap);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
