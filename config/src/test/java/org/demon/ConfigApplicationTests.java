package org.demon;

import org.demon.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ConfigApplicationTests {

    @Autowired
    private User user;
    @Autowired
    private ApplicationContext ioc;

    @Test
    public void testYaml(){
        System.out.println(user);
    }

    @Test
    public void contextLoads(){
        boolean b = ioc.containsBean("userService");
        System.out.println("userService ? " + b);
        b = ioc.containsBean("accountService");
        System.out.println("accountService ? " + b);
    }

}
