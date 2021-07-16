package org.demon.config;

import org.demon.resolver.MyLocaleResolver;
import org.demon.resolver.MyViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration
public class MyMvcConfigurer implements WebMvcConfigurer {
    /**
     * 扩展 SpringMVC 配置
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /demon 请求，对应页面为 success.html
        registry.addViewController("/demon").setViewName("demon");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        WebMvcConfigurer configurer = new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry){

                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            /*@Override
            public void addInterceptors(InterceptorRegistry registry) {
                // 拦截除了登录页面，登录请求的所有请求
                registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                                                               .excludePathPatterns("/index.html", "/", "/user/login");
            }*/

            // 开启矩阵变量的支持
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // url 不移除分号
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
        return configurer;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }
}
