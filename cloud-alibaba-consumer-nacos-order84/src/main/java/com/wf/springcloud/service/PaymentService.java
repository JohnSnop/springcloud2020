package com.wf.springcloud.service;

import com.wf.springcloud.domain.CommonResult;
import com.wf.springcloud.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wf
 * @create 2020-05-01 20:51
 * @desc
 **/
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/paymentSql/{id}")
    CommonResult<Payment> paymentSql(@PathVariable("id") String id);

}
