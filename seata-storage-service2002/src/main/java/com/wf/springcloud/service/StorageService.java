package com.wf.springcloud.service;

/**
 * @author wf
 * @create 2020-05-02 15:49
 * @desc
 **/
public interface StorageService {

    void decrease(Long productId, Integer count);
}
