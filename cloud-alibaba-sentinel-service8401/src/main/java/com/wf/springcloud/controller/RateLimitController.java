package com.wf.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wf.springcloud.domain.CommonResult;
import com.wf.springcloud.domain.Payment;
import com.wf.springcloud.handler.ConsumerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wf
 * @create 2020-05-01 16:56
 * @desc
 **/
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "资源名称限流测试", new Payment(2020L, "Hello"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(400, "服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "/rateLimit/byUrl", new Payment(2020L, "Hello"));
    }

    @GetMapping("/rateLimit/consumerBlockHandler")
    @SentinelResource(value = "consumerBlockHandler", blockHandlerClass = ConsumerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult consumerBlockHandler() {
        return new CommonResult(200, "资源Url限流测试", new Payment(2020L, "Hello"));
    }
}
