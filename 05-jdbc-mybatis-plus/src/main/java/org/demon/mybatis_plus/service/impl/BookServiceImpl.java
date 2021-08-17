package org.demon.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.demon.mybatis_plus.entity.Book;
import org.demon.mybatis_plus.mapper.BookMapper;
import org.demon.mybatis_plus.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
