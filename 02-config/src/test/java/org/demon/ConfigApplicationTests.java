package org.demon;

import org.demon.bean.User;
import org.demon.utils.MyDateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.Map;

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

    @Test
    public void testDateUtils(){
        /*Map<String, String> map = MyDateUtils.monthMap(true);
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
        System.out.println("去年");
        Map<String, String> map_1 = MyDateUtils.monthMap(false);
        for(Map.Entry<String, String> entry : map_1.entrySet()){
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }*/
        Map<Integer, Map<Date, Date>> map = MyDateUtils.getQuarterMonth();
        System.out.println(map);
    }



}
