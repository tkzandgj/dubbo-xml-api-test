package com.gome.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.gome.consumer.service.StuService;
import com.gomeplus.gax.bean.proto.StrategyRequestProto.StrategyRequest;

public class ConsumerAPI {

    public static void apiTest(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-consumer");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183");
        registryConfig.setProtocol("zookeeper");

        ReferenceConfig<StuService> referenceConfig = new ReferenceConfig<StuService>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(StuService.class);

        StuService stuService = referenceConfig.get();
        StrategyRequest.Builder str = StrategyRequest.newBuilder();
        str.setId("1002");
        str.setName("dsadas");
        str.setAge(122);
        System.out.println(stuService.sayHello(str.build()));
    }

    public static void main(String[] args){
        apiTest();
    }
}
