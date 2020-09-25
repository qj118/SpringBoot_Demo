package org.demon.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    /**
     * 注册监控 Servlet
     * 对应的 druid 的 servlet：StatViewServlet
     * 参照 StatViewServlet 类中的参数构建即可
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        // druid 可以访问监控页面
        ServletRegistrationBean bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();
        // 为监控设置登录的用户名和密码
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "1234567");
        initParams.put("allow", "");

        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     * 配置监控的 Filter
     * 对应的 druid 的 filter：WebStatFilter
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());

        Map<String, String> initParams = new HashMap<>();
        // 配置不需要监控的请求
        initParams.put("exclusions", "*.js, *.css, /druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
