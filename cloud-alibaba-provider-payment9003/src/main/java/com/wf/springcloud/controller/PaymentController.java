package com.wf.springcloud.controller;

import com.wf.springcloud.domain.CommonResult;
import com.wf.springcloud.domain.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wf
 * @create 2020-05-01 18:17
 * @desc
 **/
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static Map<String, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put("1", new Payment(1L, "aaa"));
        hashMap.put("2", new Payment(2L, "bbb"));
        hashMap.put("3", new Payment(3L, "ccc"));
    }

    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") String id) {

        return new CommonResult<>(200, "serverPort:" + serverPort, hashMap.get(id));
    }
}
