package org.demon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello springboot web";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        map.put("welcome", "Demon");

        map.put("hello", "<h1>偶像</h1>");
        map.put("idols", Arrays.asList("<strong>Jia</strong>", "Fei", "Miki"));
        return "success";
    }
}
