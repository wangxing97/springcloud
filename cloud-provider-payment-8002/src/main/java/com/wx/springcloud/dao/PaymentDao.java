package com.wx.springcloud.dao;

import com.wx.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/5/20
 */
@Mapper
public interface PaymentDao {

    int createPayment(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
