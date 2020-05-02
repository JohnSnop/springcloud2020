package com.wf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wf
 * @create 2020-05-02 15:38
 * @desc
 **/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SeataStorageMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMain2002.class, args);
    }
}
