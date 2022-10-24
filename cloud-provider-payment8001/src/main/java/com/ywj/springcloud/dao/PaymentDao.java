package com.ywj.springcloud.dao;

import com.ywj.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author YaoWenJun
 * @date 2022/9/14 16:09
 */
@Mapper
public interface PaymentDao {
    /**
     * 创建支付
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 查询支付
     * @param id
     * @return
     */
    public Payment getPaymentByid(@Param("id") long id);
}
