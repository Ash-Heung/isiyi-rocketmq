package com.isiyi.controller;

import com.isiyi.message.Demo01Message;
import com.isiyi.message.MySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author: Xiang.pf
 * @time: 2020/10/16 14:31
 */

@RestController
@RequestMapping("/demo01")
public class Demo01Controller {

    @Autowired
    private MySource mySource;

    @GetMapping("/send")
    public boolean send() {
        // <1> 创建 Message
        Demo01Message message = new Demo01Message(new Random().nextInt());
        // <2> 创建 Spring Message 对象 使用 MessageBuilder 创建 Spring Message 对象，并设置消息内容为 Demo01Message 对象。
        Message<Demo01Message> springMessage = MessageBuilder.withPayload(message)
                .build();
        // <3> 发送消息
        return mySource.demo01Output().send(springMessage);
    }

}
