package org.demon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Map<String, Object> map){
        map.put("success", "Demon");
        return "success";
    }
}
