package org.demon.config;

import org.demon.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 指定当前类是一个配置类，即代替 spring 的配置文件。
 */
@Configuration
public class MyAppConfig {

    // 将方法的返回值添加到容器中，容器中这个组件的默认id就是该方法的名字
    @Bean
    public AccountService accountService(){
        return new AccountService();
    }
}
