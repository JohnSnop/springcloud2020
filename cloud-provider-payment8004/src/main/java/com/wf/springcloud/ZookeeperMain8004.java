package com.wf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wf
 * @create 2020-04-18 15:44
 * @desc
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperMain8004.class, args);
    }
}
