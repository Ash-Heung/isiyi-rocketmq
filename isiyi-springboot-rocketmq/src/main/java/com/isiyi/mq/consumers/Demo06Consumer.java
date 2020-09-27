package com.isiyi.mq.consumers;

import com.isiyi.mq.entity.Demo06Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(
        topic = Demo06Message.TOPIC,
        consumerGroup = "demo06-consumer-group-" + Demo06Message.TOPIC,
        consumeMode = ConsumeMode.ORDERLY // 设置为顺序消费
)
public class Demo06Consumer implements RocketMQListener<Demo06Message> {

    @Override
    public void onMessage(Demo06Message message) {
        log.info("[Demo06Consumer:::onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);

        // sleep 2 秒，用于查看顺序消费的效果
        try {
            Thread.sleep(2 * 1000L);
        } catch (InterruptedException ignore) {
        }
    }

}
