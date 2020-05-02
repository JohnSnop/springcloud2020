package com.wf.springcloud.controller;

import com.wf.springcloud.domain.CommonResult;
import com.wf.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-05-02 15:59
 * @desc
 **/
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功");
    }
}
