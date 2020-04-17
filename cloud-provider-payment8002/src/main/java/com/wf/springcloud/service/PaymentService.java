package com.wf.springcloud.service;

import com.wf.springcloud.domain.Payment;

/**
 * @author wf
 * @create 2020-04-15 22:14
 * @desc
 **/
public interface PaymentService {

    int insert(Payment record);

    Payment selectByPrimaryKey(Long id);
}
