package com.wf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wf
 * @create 2020-05-02 16:15
 * @desc
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SeataAccountMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMain2003.class, args);
    }
}
