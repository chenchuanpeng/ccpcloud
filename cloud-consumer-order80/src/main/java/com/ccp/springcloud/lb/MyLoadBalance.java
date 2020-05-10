package com.ccp.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLoadBalance implements LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int incrementAndGet(){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current,next));
        log.info("当前访问次数为："+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> instances) {
        final int index = incrementAndGet() % instances.size();
        return instances.get(index);
    }
}
