package com.wf.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wf
 * @create 2020-04-18 20:02
 * @desc
 **/
@Configuration
public class MyRule {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
