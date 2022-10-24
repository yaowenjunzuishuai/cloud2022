package com.ywj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author YaoWenJun
 * @date 2022/9/15 16:24
 */
@SpringBootApplication
@EnableDiscoveryClient
/* name 访问的服务名称，configuration 配置的负载均衡规则
 @RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)*/
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
