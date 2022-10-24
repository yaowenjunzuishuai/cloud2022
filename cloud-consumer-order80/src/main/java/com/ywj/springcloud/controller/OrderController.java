package com.ywj.springcloud.controller;


import com.ywj.springcloud.entities.CommonResult;
import com.ywj.springcloud.entities.Payment;
import com.ywj.springcloud.ribbon.LoadBalancer;
import com.ywj.springcloud.ribbon.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author YaoWenJun
 * @date 2022/9/15 16:27
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMNET_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMNET_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMNET_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get1/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMNET_URL + "/payment/get/" + id, CommonResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return new CommonResult(201,"错误");
        }
    }

    @GetMapping(value = "payment/discovery")
    public Object discovery(){
        // 获得所有eureka服务列表
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("service::----------"+service);
        }
        // 通过key获取服务
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping(value = "/consumer/payment/getport")
    public String getport(){

        // 获取注册在euraka上面
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances.size() == 0 || instances == null){
            return null;
        }
        // 自定义轮询选择服务器
        ServiceInstance instances1 = loadBalancer.instances(instances);
        URI uri = instances1.getUri();
        System.out.println(uri);
        return restTemplate.getForObject(uri+"/payment/getport",String.class);
    }
}
