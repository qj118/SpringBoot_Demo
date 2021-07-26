package org.demon.config;

import org.demon.converter.DemonMessageConverter;
import org.demon.entity.Book;
import org.demon.resolver.MyLocaleResolver;
import org.demon.resolver.MyViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;
import org.thymeleaf.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Book>() {
                    @Override
                    public Book convert(String source) {
                        if(!StringUtils.isEmpty(source)){
                            Book book = new Book();
                            // source: 生如逆旅,酒暖春深
                            String[] split = source.split(",");
                            book.setBookName(split[0]);
                            book.setBookAuthor(split[1]);
                            return book;
                        }
                        return null;
                    }
                });
            }

            /**
             * 扩展 MessageConverter
             * @param converters
             */
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new DemonMessageConverter());
            }

            /**
             * 自定义内容协商策略
             * @param configurer
             */
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypes = new HashMap<>();
                mediaTypes.put("json", MediaType.APPLICATION_JSON);
                mediaTypes.put("xml", MediaType.APPLICATION_XML);
                mediaTypes.put("demon", MediaType.parseMediaType("application/xxx-demon"));
                // 基于请求参数的内容协商策略
                ParameterContentNegotiationStrategy parameterContentNegotiationStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
                // 基于请求头的内容协商策略
                HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();

                configurer.strategies(Arrays.asList(parameterContentNegotiationStrategy, headerContentNegotiationStrategy));

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
