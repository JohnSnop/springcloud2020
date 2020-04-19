package com.wf.springcloud.service.impl;

import com.wf.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * @author wf
 * @create 2020-04-19 20:35
 * @desc
 **/
@Service
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String payment_ok(Integer id) {
        return "--PaymentFallbackService--paymentInfo_OK";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "--PaymentFallbackService--payment_timeout";
    }
}
