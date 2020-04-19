package com.wf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * @author wf
 * @create 2020-04-19 11:29
 * @desc
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderFeignMain80 {

    @PostConstruct
    void start() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    public static void main(String[] args) {
//        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
