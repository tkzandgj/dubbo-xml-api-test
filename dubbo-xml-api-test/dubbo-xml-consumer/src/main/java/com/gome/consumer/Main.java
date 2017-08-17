package com.gome.consumer;

import com.gome.provider.service.StuService;
import com.gomeplus.gax.bean.proto.StrategyRequestProto.StrategyRequest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"consumer.xml"});
        context.start();
        StuService stuService = (StuService) context.getBean("stuService");

        StrategyRequest.Builder str = StrategyRequest.newBuilder();
        str.setId("1002");
        str.setName("dsadas");
        str.setAge(122);

        System.out.println(stuService.sayHello(str.build()));
    }
}
