package com.zeroone.star.cpp.fallback;

import com.zeroone.star.cpp.service.ISampleService;
import com.zeroone.star.cpp.service.impl.SampleServiceImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 描述：声明式服务接口异常工厂
 * </p>
 * <p>版权：&copy;01星球</p>
 * <p>地址：01星球总部</p>
 * @author 阿伟学长
 * @version 1.0.0
 */
@Component
public class CppServiceFallBack implements FallbackFactory<ISampleService> {
    @Override
    public ISampleService create(Throwable throwable) {
        return new SampleServiceImpl(throwable);
    }
}
