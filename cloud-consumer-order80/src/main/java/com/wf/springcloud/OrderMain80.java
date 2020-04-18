package com.wf.springcloud;

import com.wf.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author wf
 * @create 2020-04-16 20:40
 * @desc
 **/
@SpringBootApplication
//@RibbonClient(name = "cloud-payment-service", configuration = MyRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
