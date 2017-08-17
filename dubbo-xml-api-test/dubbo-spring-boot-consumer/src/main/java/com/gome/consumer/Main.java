package com.gome.consumer;


import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import com.gomeplus.gax.bean.proto.StrategyRequestProto.StrategyRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDubboConfiguration
public class Main {

    public static void main(String[] args){
        ConfigurableApplicationContext bean = SpringApplication.run(Main.class, args);
        ConsumerService consumerService = bean.getBean(ConsumerService.class);

        StrategyRequest.Builder str = StrategyRequest.newBuilder();
        str.setId("1002");
        str.setName("dsadas");
        str.setAge(122);
        System.out.println(consumerService.stuService.sayHello(str.build()));
    }
}
