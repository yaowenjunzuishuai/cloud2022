package com.ywj.springcloud.ribbon;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author YaoWenJun
 * @date 2022/9/24 15:24
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     *  获取当前请求次数
     * @return
     */
    public final int getAndInstance() {
        int current;
        int next = 0;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("next值~~~~~~~~" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndInstance() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
