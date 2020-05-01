package com.wf.springcloud.service;

import com.wf.springcloud.domain.CommonResult;
import com.wf.springcloud.domain.Payment;
import org.springframework.stereotype.Component;

/**
 * @author wf
 * @create 2020-05-01 20:52
 * @desc
 **/
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSql(String id) {
        return new CommonResult<>(444, "服务降级，PaymentFallbackService");
    }
}
