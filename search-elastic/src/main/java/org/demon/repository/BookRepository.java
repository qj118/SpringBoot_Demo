package org.demon.repository;

import org.demon.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    // reference to https://docs.spring.io/spring-data/elasticsearch/docs/4.0.4.RELEASE/reference/html/#elasticsearch.query-methods.criterions
    List<Book> findByBookNameLike(String bookName);
}
