package com.wf.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wf
 * @create 2020-04-28 21:29
 * @desc
 **/
@RestController
public class SentinelController {
    @GetMapping("/testA")
    public String getA() {
        return "Test--A";
    }

    @GetMapping("/testB")
    public String getB() {
        return "Test--B";
    }

    @GetMapping("/testD")
    public String getD() {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        int age = 1 / 0;
        return "Test--D";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p1", required = false) String p2) {
        return "Test--testHotKey";
    }

    public String deal_testHotKey(@RequestParam(value = "p1", required = false) String p1,
                                  @RequestParam(value = "p1", required = false) String p2,
                                  BlockException exception) {
        return "Test--deal_testHotKey";
    }
}
