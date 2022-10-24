package com.ywj.springcloud.service;

import com.ywj.springcloud.entities.CommonResult;
import com.ywj.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author YaoWenJun
 * @date 2022/9/29 16:01
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 获取详细信息
     *
     * @param id 编号
     * @return 对应编号的详细信息
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentByid(@PathVariable("id") long id);


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
