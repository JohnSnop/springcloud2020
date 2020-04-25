package com.wf.springcloud.controller;

import com.wf.springcloud.domain.CommonResult;
import com.wf.springcloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

//    private static final String URL = "http://localhost:8001/payment/";
//    private static final String URL = "http://CLOUD-PAYMENT-SERVICE/";
    private static final String URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zipkin")
    public String payemntZipkin() {
        return restTemplate.getForObject(URL + "/payment/zipkin", String.class);
    }

    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL + "/payment/get/" + id, CommonResult.class);
    }

    @RequestMapping("/consumer/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/getForEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult<>(400, "查询失败");
        }
    }
}
