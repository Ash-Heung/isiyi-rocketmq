package com.isiyi.mq.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 定时消费的案例
 */
@Data
@Accessors(chain = true)
public class Demo03Message {
    public static final String TOPIC = "DEMO_03";

    /**
     * 编号
     */
    private Integer id;
}
