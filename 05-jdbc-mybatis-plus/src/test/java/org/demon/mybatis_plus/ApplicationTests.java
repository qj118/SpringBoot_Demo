package org.demon.mybatis_plus;

import lombok.extern.slf4j.Slf4j;
import org.demon.mybatis_plus.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
        log.info("所有图书: {}",bookService.list());
    }

}
