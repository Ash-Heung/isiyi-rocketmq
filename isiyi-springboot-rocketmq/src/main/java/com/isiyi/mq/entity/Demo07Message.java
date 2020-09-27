package com.isiyi.mq.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 事务消息
 */
@Data
@Accessors(chain = true)
public class Demo07Message {

        public static final String TOPIC = "DEMO_07";

        /**
         * 编号
         */
        private Integer id;

}
