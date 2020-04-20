package com.wf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author wf
 * @create 2020-04-20 21:32
 * @desc
 **/
@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayMain9022 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayMain9022.class, args);
    }
}
