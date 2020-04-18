package com.wf.springcloud.controller;

import com.wf.springcloud.domain.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-04-18 16:14
 * @desc
 **/
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String URL = "http://cloud-consumer-service";

    @GetMapping("/consumer/zookeeper")
    public CommonResult zookeeper() {
        String string = restTemplate.getForObject(URL + "/payment/zk", String.class);
        return new CommonResult(200, "success", string);
    }

}
