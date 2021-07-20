package org.demon.controller;

import org.demon.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * 测试自定义 Converter: http://localhost:8087/crud/book?book=生如逆旅,酒暖春深
     * @param book
     * @return
     */
    @ResponseBody
    @PostMapping("/book")
    public String testPOJO(Book book){
        System.out.println(book);
        return book.toString();
    }
}
