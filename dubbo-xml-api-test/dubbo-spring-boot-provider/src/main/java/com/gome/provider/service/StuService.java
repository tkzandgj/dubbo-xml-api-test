package com.gome.provider.service;

import com.gomeplus.gax.bean.proto.StrategyRequestProto.StrategyRequest;
import com.gomeplus.gax.bean.proto.StrategyResponseProto.StrategyResponse;

public interface StuService {

    public StrategyResponse sayHello(StrategyRequest stuName);
}
