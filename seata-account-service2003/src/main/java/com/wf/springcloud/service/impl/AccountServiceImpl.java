package com.wf.springcloud.service.impl;

import com.wf.springcloud.dao.AccountMapper;
import com.wf.springcloud.domain.Account;
import com.wf.springcloud.domain.AccountExample;
import com.wf.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author wf
 * @create 2020-05-02 16:09
 * @desc
 **/
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("AccountService--->>>扣减金额开始");

        // 模拟超时异常
        /*try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andUserIdEqualTo(userId);
        List<Account> accountList = accountMapper.selectByExample(accountExample);
        if (accountList != null && accountList.size() > 0) {
            for (Account account : accountList) {
                account.setUsed(account.getUsed().add(money));
                account.setResidue(account.getResidue().subtract(money));
                accountMapper.updateByPrimaryKeySelective(account);
            }
        }

        log.info("AccountService--->>>扣减金额结束");
    }
}
