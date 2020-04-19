package com.wf.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wf
 * @create 2020-04-19 14:11
 * @desc
 **/
@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level level() {
        return Logger.Level.FULL;
    }
}
