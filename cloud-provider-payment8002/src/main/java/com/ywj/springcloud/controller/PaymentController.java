package com.ywj.springcloud.controller;

import com.ywj.springcloud.entities.CommonResult;
import com.ywj.springcloud.entities.Payment;
import com.ywj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author YaoWenJun
 * @date 2022/9/14 16:45
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("******插入结果*****：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功", result);
        } else {
            return new CommonResult(201, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentByid(@PathVariable("id") long id) {
        Payment payment = paymentService.getPaymentByid(id);
        log.info("******查询结果*****：" + payment);
        log.info("我是傻逼");
        if (payment != null) {
            return new CommonResult(200, "查询数据成功", payment);
        } else {
            return new CommonResult(201, "查询数据失败查询id为：" + id, null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getport(){
        return serverPort;
    }
}
