package com.wf.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wf
 * @create 2020-04-18 20:26
 * @desc
 **/
@Component
@Slf4j
public class MyLB implements LoadBalancer {

    private AtomicInteger integer = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = integer.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!integer.compareAndSet(current, next));
        log.info("========next==={}", next);
        return next;
    }
    @Override
    public ServiceInstance INSTANCE(List<ServiceInstance> instances) {
        int count = getAndIncrement() % instances.size();

        return instances.get(count);
    }
}
