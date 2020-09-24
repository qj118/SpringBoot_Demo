package org.demon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam String username, @RequestParam String password, Map<String, Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && StringUtils.equals("1234567", password)){
            // 提供给拦截器做判断
            session.setAttribute("username", username);
            // 防止表单重复提交，重定向到首页
            return "redirect:/main.html";
        }else{
            map.put("msg", "用户名或密码错误");
            return "login";
        }

    }
}
