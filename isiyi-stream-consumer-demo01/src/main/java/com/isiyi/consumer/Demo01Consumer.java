package com.isiyi.consumer;

import com.isiyi.message.Demo01Message;
import com.isiyi.message.MySink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author: Xiang.pf
 * @time: 2020/10/16 14:56
 */
@Slf4j
@Component
public class Demo01Consumer {


    @StreamListener(MySink.DEMO01_INPUT)
    public void onMessage(@Payload Demo01Message message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}
