package com.wf.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wf.springcloud.domain.CommonResult;
import com.wf.springcloud.domain.Payment;
import com.wf.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-05-01 20:23
 * @desc
 **/
@RestController
public class CircuitBreakerController {

    @Resource
    private PaymentService paymentService;

    @RequestMapping("/consumer/feign/{id}")
    public CommonResult<Payment> paymentFeign(@PathVariable("id") String id) {
        return paymentService.paymentSql(id);
    }

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @RequestMapping("/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback")
    // @SentinelResource(value = "fallback", fallback = "handlerFallback")//只配置fallback,处理业务异常
    // @SentinelResource(value = "fallback", blockHandler = "blockHandler")//只配置blockHandler,处理sentinel控制台的配置项
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")
    public CommonResult<Payment> fallback(@PathVariable("id") String id) {

        CommonResult result = restTemplate.getForObject(serverURL + "/paymentSql/" + id, CommonResult.class);
        if ("4".equals(id)) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,没有对应的记录");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable("id") String id, Throwable e) {
        return new CommonResult<>(400, "handlerFallback," + e.getMessage(),
                new Payment(Long.valueOf(id), null));
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") String id, BlockException e) {
        return new CommonResult<>(400, "blockHandler-sentinel:" + e.getMessage(),
                new Payment(Long.valueOf(id), null));
    }
}
