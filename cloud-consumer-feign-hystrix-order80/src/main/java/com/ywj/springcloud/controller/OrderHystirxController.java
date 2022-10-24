package com.ywj.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ywj.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author YaoWenJun
 * @date 2022/10/9 16:44
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystirxController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        String s = paymentHystrixService.paymentInfo_ok(id);
        return s;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")

//            (fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
//    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        String s = paymentHystrixService.paymentInfo_Timeout(id);
        return s;
    }

//    public String paymentInfo_TimeoutHandler(@PathVariable("id") Integer id){
//        String s = "消费80，请求服务端服务繁忙，请10分钟后重试";
//        return s;
//    }
//
//    public String payment_Global_FallbackMethod(){
//        String s = "消费80，请求服务端服务繁忙，请10分钟后重试,我是默认方发哟~~~~~~(*^▽^*)";
//        return s;
//    }
}
