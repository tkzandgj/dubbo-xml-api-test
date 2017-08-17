package com.gome.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.gome.consumer.service.StuService;
import com.gome.consumer.serviceImpl.StuServiceImpl;

import java.io.IOException;

public class ProviderAPI {

    public static void apiTest(){
        StuService stuService = new StuServiceImpl();

        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-provider");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183");
        registryConfig.setProtocol("zookeeper");

        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(12345);
        protocolConfig.setThreads(200);
        protocolConfig.setSerialization("protobuf");

        ServiceConfig<StuService> service = new ServiceConfig<StuService>();
        service.setApplication(applicationConfig);
        service.setRegistry(registryConfig);
        service.setProtocol(protocolConfig);
        service.setInterface(StuService.class);
        service.setRef(stuService);

        service.export();
    }

    public static void main(String[] args){
        apiTest();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
