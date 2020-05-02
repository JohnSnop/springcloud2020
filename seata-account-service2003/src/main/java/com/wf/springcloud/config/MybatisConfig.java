package com.wf.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wf
 * @create 2020-05-02 15:16
 * @desc
 **/
@Configuration
@MapperScan({"com.wf.springcloud.dao"})
public class MybatisConfig {

}
