package com.wf.springcloud.controller;

import com.wf.springcloud.domain.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-04-18 16:56
 * @desc
 **/
@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    private static final String URL = "http://cloud-payment-service";

    @GetMapping("/consumer/consul")
    public CommonResult consul() {
        String string = restTemplate.getForObject(URL + "/payment/consul", String.class);
        return new CommonResult(200, "success", string);
    }
}
