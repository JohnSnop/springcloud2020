package com.wf.springcloud;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-04-25 20:05
 * @desc
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EncryptorTest {

    @Resource
    private ApplicationContext applicationContext;
    @Resource(name = "wfEncryptorBean")
    private StringEncryptor stringEncryptor;

    @Test
    public void run() throws Exception {
        Environment environment = applicationContext.getBean(Environment.class);

        // 首先获取配置文件里的原始明文信息
        String mysqlOriginPswd = environment.getProperty("spring.cloud.stream.binders.defaultRabbit.environment.spring.rabbitmq.password");
        String mysqlEncryptedPswd = encrypt(mysqlOriginPswd);
        System.out.println("MySQL原始明文密码加密后的结果为：" + mysqlEncryptedPswd);
    }

    private String encrypt(String originPassord) {
        return stringEncryptor.encrypt(originPassord);
    }

    private String decrypt(String encryptedPassword) {
        return stringEncryptor.decrypt(encryptedPassword);
    }
}
