package com.ywj.springcloud.config;

import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YaoWenJun
 * @date 2022/9/30 15:35
 */
@Configuration
public class FeignConfig {

    // 设置日志等级
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options options(){
        return new Request.Options(5000,10000);
    }
}
