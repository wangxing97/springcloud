package com.wx.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * Author:逗你妹
 * Date:2020/6/16
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAntIncrement(){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while(!atomicInteger.compareAndSet(current, next));
        System.out.println("****next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int next = getAntIncrement();
        next %= serviceInstances.size();
        ServiceInstance instance = serviceInstances.get(next);
        return instance;
    }
}
