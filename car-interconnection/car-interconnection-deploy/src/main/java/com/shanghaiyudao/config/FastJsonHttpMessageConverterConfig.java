package com.shanghaiyudao.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.google.common.collect.ImmutableList;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.nio.charset.Charset;

@Configuration
@ConditionalOnClass({FastJsonHttpMessageConverter4.class})
@ConditionalOnProperty(name = {"spring.http.converters.preferred-json-mapper"},havingValue = "fastjson",matchIfMissing = true)
public class FastJsonHttpMessageConverterConfig {

    public FastJsonHttpMessageConverterConfig() {
    }

    @Bean
    @ConditionalOnMissingBean({FastJsonHttpMessageConverter4.class})
    public FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter4(){
        FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
        converter.setSupportedMediaTypes(ImmutableList.of(MediaType.APPLICATION_JSON_UTF8,MediaType.APPLICATION_JSON,MediaType.APPLICATION_FORM_URLENCODED,MediaType.IMAGE_GIF,MediaType.IMAGE_JPEG,MediaType.IMAGE_PNG));
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastJsonConfig.setSerializerFeatures(new SerializerFeature[]{SerializerFeature.QuoteFieldNames,SerializerFeature.WriteDateUseDateFormat,SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.PrettyFormat,SerializerFeature.SkipTransientField});
        converter.setFastJsonConfig(fastJsonConfig);
        return converter;
    }
}