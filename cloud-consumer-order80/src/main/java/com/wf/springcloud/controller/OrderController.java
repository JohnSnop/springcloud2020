package com.wf.springcloud.controller;

import com.wf.springcloud.domain.CommonResult;
import com.wf.springcloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-04-16 20:43
 * @desc
 **/
@RestController
@Slf4j
public class OrderController {

    private static final String URL = "http://localhost:8001/payment/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL + "/get/" + id, CommonResult.class);
    }

    @RequestMapping("/consumer/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(URL + "/create", payment, CommonResult.class);
    }
}
