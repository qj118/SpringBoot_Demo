package org.demon.mybatis_plus.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.demon.mybatis_plus.entity.Book;
import org.demon.mybatis_plus.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public Page<Book> getCurrentPage(@RequestParam("pn") int pageNum){

        Page<Book> bookPage = new Page<>(pageNum, 2); // 分页规则
        Page<Book> result = bookService.page(bookPage); // 按分页查询结果
        
        return result;
    }
}
