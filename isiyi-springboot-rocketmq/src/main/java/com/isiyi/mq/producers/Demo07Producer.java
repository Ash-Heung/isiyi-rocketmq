package com.isiyi.mq.producers;

import com.isiyi.mq.entity.Demo07Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class Demo07Producer {

    /**
     * 事务消息的生产者分组。
     * 因为 RocketMQ 是回查（请求）指定指定生产分组下的 Producer ，从而获得事务消息的状态，所以一定要正确设置
     */
    private static final String TX_PRODUCER_GROUP = "demo07-producer-group";

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public TransactionSendResult sendMessageInTransaction(Integer id) {
        // <1> 创建 Demo07Message 消息
        Message message = MessageBuilder.withPayload(new Demo07Message().setId(id))
                .build();
        // <2> 发送事务消息
        return rocketMQTemplate.sendMessageInTransaction(TX_PRODUCER_GROUP, Demo07Message.TOPIC, message, id);
    }

    @RocketMQTransactionListener(txProducerGroup = TX_PRODUCER_GROUP)
    class TransactionListenerImpl implements RocketMQLocalTransactionListener {


        @Override
        public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
            // ... local transaction process, return rollback, commit or unknown
            System.out.println("[executeLocalTransaction][执行本地事务，消息："+msg+" arg："+ arg);
            return RocketMQLocalTransactionState.UNKNOWN;
        }

        @Override
        public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
            // ... check transaction status and return rollback, commit or unknown
            System.out.println("[checkLocalTransaction][回查消息："+ msg);
            return RocketMQLocalTransactionState.COMMIT;
        }

    }
}

