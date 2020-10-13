package org.demon.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    // 定制授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 为访问路径添加访问权限（角色）
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        /**
         * 开启自动配置的登录功能
         * 前端发送 /login 请求，自动生成登录页面
         */
        // http.formLogin();

        /**
         * 定制登录页面
         *      usernameParameter 和 passwordParameter 用来设置表单上用户名和密码两个表单项的 name
         *      loginPage 指定登录页面的请求地址
         *  如果定制自己的页面，那么 loginPage 的 post 请求就是登录请求
         *      即表单的 action 与 loginPage 的值是一样的，方法为 post 即可实现验证登录
         */
        http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin");
        http.rememberMe().rememberMeParameter("remember");

        /**
         * 开启自动配置的注销功能，前端发送 /logout 请求自动注销
         * 注销成功会返回 /login?logout 页面 （自动生成）
         * 可以通过 logoutSuccessUrl 指定跳转页面。
         */
        http.logout().logoutSuccessUrl("/");

        /**
         * 开启记住我功能
         * 登录成功后，将名为 remember-me 的 cookie 发给浏览器保存，以后访问页面会带上这个 cookie
         * 注销会删除该 cookie
         */
        //http.rememberMe();
    }

    // 定制认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("demon").password(new BCryptPasswordEncoder().encode("1234567")).roles("VIP1", "VIP2", "VIP3")
                .and()
                .withUser("FEI").password(new BCryptPasswordEncoder().encode("fei")).roles("VIP1")
                .and()
                .withUser("JIA").password(new BCryptPasswordEncoder().encode("jia")).roles("VIP3");
    }
}
