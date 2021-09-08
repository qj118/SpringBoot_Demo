package org.demon.controller;

import org.demon.entity.Book;
import org.demon.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("gl")
    public Book getGLBook(){
        return bookService.getGLBook();
    }
}
