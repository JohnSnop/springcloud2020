package com.wf.springcloud.controller;

import com.wf.springcloud.domain.CommonResult;
import com.wf.springcloud.domain.Order;
import com.wf.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-05-02 15:13
 * @desc
 **/
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.insert(order);
        return new CommonResult(200, "创建订单完成");
    }
}
