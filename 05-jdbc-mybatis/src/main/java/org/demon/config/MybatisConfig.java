package org.demon.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    /**
     * 根据自动配置类 MybatisAutoConfiguration 中的 ConfigurationCustomizer
     * 可以看出可以通过写配置类来自定义 Mybatis 配置
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                // 启用驼峰命名法，使类中的 departmentName 可以和数据库中 department_name 相匹配
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
