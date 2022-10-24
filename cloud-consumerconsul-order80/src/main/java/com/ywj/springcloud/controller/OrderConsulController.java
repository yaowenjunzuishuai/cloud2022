package com.ywj.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author YaoWenJun
 * @date 2022/9/21 19:31
 */
@RestController
@Slf4j
public class OrderConsulController {
    public final static String INN_URL = "http://consul-provider-paymentaaa";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        String forObject = restTemplate.getForObject(INN_URL + "/payment/consul", String.class);

        return  forObject;
    }


}
