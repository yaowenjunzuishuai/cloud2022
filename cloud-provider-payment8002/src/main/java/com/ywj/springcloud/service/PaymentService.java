package com.ywj.springcloud.service;

import com.ywj.springcloud.entities.Payment;

/**
 * @author YaoWenJun
 * @date 2022/9/14 16:33
 */

public interface PaymentService {
    /**
     * 创建支付
     *
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 查询支付
     *
     * @param id
     * @return
     */
    public Payment getPaymentByid(long id);
}
