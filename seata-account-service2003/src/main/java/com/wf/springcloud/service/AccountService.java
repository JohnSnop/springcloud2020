package com.wf.springcloud.service;

import java.math.BigDecimal;

/**
 * @author wf
 * @create 2020-05-02 16:08
 * @desc
 **/
public interface AccountService {

    void decrease(Long userId, BigDecimal money);
}
