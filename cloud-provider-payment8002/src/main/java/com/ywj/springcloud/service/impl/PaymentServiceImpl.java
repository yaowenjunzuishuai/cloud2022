package com.ywj.springcloud.service.impl;

import com.ywj.springcloud.dao.PaymentDao;
import com.ywj.springcloud.entities.Payment;
import com.ywj.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author YaoWenJun
 * @date 2022/9/14 16:33
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentByid(long id) {
        return paymentDao.getPaymentByid(id);
    }

}
