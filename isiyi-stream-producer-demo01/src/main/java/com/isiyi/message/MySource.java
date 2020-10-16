package com.isiyi.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author: Xiang.pf
 * @time: 2020/10/16 14:30
 */
public interface MySource {

    @Output("demo01-output")
    MessageChannel demo01Output();

}

