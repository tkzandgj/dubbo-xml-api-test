package com.gome.consumer;

import com.alibaba.boot.dubbo.annotation.DubboConsumer;
import com.gome.provider.service.StuService;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

    @DubboConsumer
    public StuService stuService;
}
