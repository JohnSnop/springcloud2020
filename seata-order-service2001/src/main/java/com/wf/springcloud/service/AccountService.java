package com.wf.springcloud.service;

import com.wf.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author wf
 * @create 2020-05-02 11:02
 * @desc
 **/
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
