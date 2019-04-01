package com.shanghaiyudao.config;


import com.shanghaiyudao.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySpringMvcConfigurer {
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//        return new WebMvcConfigurer() {
//            //添加视图控制器
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("main/login");
//                registry.addViewController("/login.html").setViewName("main/login");
//                registry.addViewController("/main.html").setViewName("main/index");
//            }

//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                //将自定义拦截器添加到容器加载
//                registry.addInterceptor(new LoginHandlerInterceptor())
//                        //添加拦截规则
//                        .addPathPatterns("/**")
//                        .excludePathPatterns("/","/login","/index.html")
//                        //springboot2+静态文件需要手动排除
//                        .excludePathPatterns("/css/*","/js/*","/img/*");
//            }
//        };
//    }

}
