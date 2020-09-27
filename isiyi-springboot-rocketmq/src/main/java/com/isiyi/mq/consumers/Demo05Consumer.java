package com.isiyi.mq.consumers;

import com.isiyi.mq.entity.Demo05Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(
        topic = Demo05Message.TOPIC,
        consumerGroup = "demo05-consumer-group-" + Demo05Message.TOPIC,
        messageModel = MessageModel.BROADCASTING // 设置为广播消费
)
public class Demo05Consumer implements RocketMQListener<Demo05Message> {

    @Override
    public void onMessage(Demo05Message message) {
        log.info("[Demo05Consumer:::onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}
