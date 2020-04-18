package com.wf.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author wf
 * @create 2020-04-18 20:36
 * @desc
 **/
public interface LoadBalancer {

    ServiceInstance INSTANCE(List<ServiceInstance> instances);
}