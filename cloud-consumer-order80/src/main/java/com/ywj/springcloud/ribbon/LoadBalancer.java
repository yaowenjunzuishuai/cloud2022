package com.ywj.springcloud.ribbon;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author YaoWenJun
 * @date 2022/9/24 15:18
 */
public interface LoadBalancer {
    /**
     * 负载均衡计算
     * @param serviceInstances 响应集群服务器实例
     * @return 用于计算出此次负载均衡请求的服务器地址
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
