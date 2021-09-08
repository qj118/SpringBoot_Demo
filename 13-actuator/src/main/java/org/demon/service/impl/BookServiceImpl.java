package org.demon.service.impl;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.demon.entity.Book;
import org.demon.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    Counter counter;

    public BookServiceImpl(MeterRegistry meterRegistry){
        // 监控项的名称
        counter = meterRegistry.counter("actuator.book.gl.counter");
    }

    @Override
    public Book getGLBook() {
        counter.increment();
        return new Book("《一世清欢》", "无心谈笑");
    }
}
