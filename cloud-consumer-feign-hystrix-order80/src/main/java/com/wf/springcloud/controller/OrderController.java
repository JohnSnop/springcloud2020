package com.wf.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wf.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-04-19 19:41
 * @desc
 **/
@RestController
@Slf4j
// 也可以配置外部类，defaultFallback--类的全路径
@DefaultProperties(defaultFallback = "payment_global_fallback")
public class OrderController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id) {
        return paymentHystrixService.payment_ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String payment_timeout(@PathVariable("id") Integer id) {
        return paymentHystrixService.payment_timeout(id);
    }

    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id) {
        return "80消费者调用接口超时或者异常，\t" ;
    }

    public String payment_global_fallback(@PathVariable("id") Integer id) {
        return "80消费者调用接口超时或者异常，\t" ;
    }
}
