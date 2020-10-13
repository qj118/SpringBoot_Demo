package org.demon.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/buy")
    public String buyTicket(String name){
        // url 处只需提供 application name + 服务请求即可
        String s = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
        return name + " 购买了 " + s;
    }

}
