package org.demon.controller;

import org.demon.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * 可根据 MediaType 不同返回 json 或者 xml，
     * 也可以返回 MediaType 为 xxx-demon 的自定义类型，返回格式为 生如逆旅-酒暖春深
     * @return
     */
    @ResponseBody
    @GetMapping("/book")
    public Book testResponseBody(){
        return new Book("生如逆旅", "酒暖春深");
    }
}
