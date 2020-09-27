package com.isiyi.mq.entity;


import lombok.Data;

/**
 * 广播消费
 */
@Data
public class Demo05Message {

    public static final String TOPIC = "DEMO_05";

    /**
     * 编号
     */
    private Integer id;
}
