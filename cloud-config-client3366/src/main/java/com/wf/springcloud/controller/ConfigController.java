package com.wf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wf
 * @create 2020-04-25 13:49
 * @desc
 **/
@RestController
@Slf4j
@RefreshScope
public class ConfigController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return "serverPort：" + serverPort + "\t" + configInfo;
    }
}
