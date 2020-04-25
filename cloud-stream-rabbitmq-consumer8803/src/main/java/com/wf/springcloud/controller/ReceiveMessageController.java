package com.wf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wf
 * @create 2020-04-25 16:31
 * @desc
 **/
@RestController
@Slf4j
@EnableBinding(Sink.class)
public class ReceiveMessageController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("端口号==={}，接收到的消息==={}", serverPort, message.getPayload());
    }
}
