package com.wf.springcloud.controller;

import com.wf.springcloud.domain.CommonResult;
import com.wf.springcloud.domain.Payment;
import com.wf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-04-15 21:20
 * @desc
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult<Payment> insert(@RequestBody Payment payment) {
        int insert = paymentService.insert(payment);
        if (insert > 0) {
            return new CommonResult(200, "插入数据成功，端口号:" + serverPort, payment);
        } else {
            return new CommonResult(400, "插入数据失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.selectByPrimaryKey(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功，端口号:" + serverPort, payment);
        } else {
            return new CommonResult(400, "查询失败", null);
        }
    }
}
