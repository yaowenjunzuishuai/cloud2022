package com.ywj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author YaoWenJun
 * @date 2022/9/14 16:41
 */

@SpringBootApplication
@EnableEurekaClient
public class ApplicationMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain8002.class, args);
    }
}
