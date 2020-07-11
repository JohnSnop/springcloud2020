package com.wf.springcloud;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-04-25 18:31
 * @desc
 **/
@RunWith(SpringRunner.class)
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
        String mysqlOriginPswd = environment.getProperty("spring.datasource.password");
        String mysqlEncryptedPswd = encrypt(mysqlOriginPswd);
        System.out.println("MySQL原始明文密码加密后的结果为：" + mysqlEncryptedPswd);

        String decrypt = decrypt(mysqlEncryptedPswd);
        System.out.println("MySQL原始明文密码为：" + decrypt);
    }

    private String encrypt(String originPassord) {
        return stringEncryptor.encrypt(originPassord);
    }

    private String decrypt(String encryptedPassword) {
        return stringEncryptor.decrypt(encryptedPassword);
    }
}
