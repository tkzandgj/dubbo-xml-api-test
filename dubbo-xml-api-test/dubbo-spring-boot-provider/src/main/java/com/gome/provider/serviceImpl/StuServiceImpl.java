package com.gome.provider.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gome.provider.service.StuService;
import com.gomeplus.gax.bean.proto.StrategyRequestProto.StrategyRequest;
import com.gomeplus.gax.bean.proto.StrategyResponseProto.StrategyResponse;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = StuService.class)
public class StuServiceImpl implements StuService {

    @Override
    public StrategyResponse sayHello(StrategyRequest stuName) {
        StrategyResponse.Builder strategyResponse = StrategyResponse.newBuilder();
        strategyResponse.setId("0101");
        strategyResponse.setName("zhangsan");
        strategyResponse.setAge(10);
        return strategyResponse.build();
    }
}
