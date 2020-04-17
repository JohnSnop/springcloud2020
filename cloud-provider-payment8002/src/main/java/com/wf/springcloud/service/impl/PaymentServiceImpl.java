package com.wf.springcloud.service.impl;

import com.wf.springcloud.dao.PaymentMapper;
import com.wf.springcloud.domain.Payment;
import com.wf.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wf
 * @create 2020-04-15 22:15
 * @desc
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int insert(Payment record) {
        return paymentMapper.insert(record);
    }

    @Override
    public Payment selectByPrimaryKey(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }
}
