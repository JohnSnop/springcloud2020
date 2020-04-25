package com.wf.springcloud.service.impl;

import com.wf.springcloud.service.MessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author wf
 * @create 2020-04-25 15:09
 * @desc
 **/
@Slf4j
@EnableBinding(Source.class)//定义消息的推送管道
//@Service
public class MessageProviderImpl implements MessageProvider {

    @Resource
    private MessageChannel output;//消息发送管道
    
    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        log.info("uuid================={}", uuid);
        return uuid;
    }
}
