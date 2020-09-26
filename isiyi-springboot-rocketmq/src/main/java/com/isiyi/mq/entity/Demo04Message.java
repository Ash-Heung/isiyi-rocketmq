package com.isiyi.mq.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 消费重试
 */
@Data
@Accessors(chain = true)
public class Demo04Message {

        public static final String TOPIC = "DEMO_04";

        /**
         * 编号
         */
        private Integer id;
}
