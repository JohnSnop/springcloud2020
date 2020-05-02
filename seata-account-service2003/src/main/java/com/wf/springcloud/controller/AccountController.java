package com.wf.springcloud.controller;

import com.wf.springcloud.domain.CommonResult;
import com.wf.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author wf
 * @create 2020-05-02 16:17
 * @desc
 **/
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult decrease(Long userId, BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减金额成功");
    }
}
