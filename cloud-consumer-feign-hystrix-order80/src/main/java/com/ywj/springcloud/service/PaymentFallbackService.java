package com.ywj.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author YaoWenJun
 * @date 2022/10/11 15:37
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "------PaymentFallbackService fall paymentInfo_ok,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "------PaymentFallbackService fall paymentInfo_Timeout,o(╥﹏╥)o";
    }
}
