package com.wf.springcloud.controller;

import com.wf.springcloud.service.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-04-25 15:17
 * @desc
 **/
@RestController
public class MessageSendController {
    @Resource
    private MessageProvider messageProvider;

    @GetMapping("/sendMsg")
    public String sendMsg() {
        return messageProvider.send();
    }

}
