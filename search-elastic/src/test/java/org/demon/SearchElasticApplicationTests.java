package org.demon;

import org.demon.bean.Book;
import org.demon.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SearchElasticApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	void testSave() {
		Book book = new Book(1,"漫长的告别", "雷德蒙·钱德勒");
		bookRepository.save(book);
	}

	@Test
	void testQuery(){
		Optional<Book> book = bookRepository.findById(1);
		System.out.println(book);

		// 注意：elasticSearch 中的 book 对象需要使完整的，如果不是完整的可能会导致类型转化错误
		for(Book b: bookRepository.findByBookNameLike("的")){
			System.out.println(b);
		}
	}

	@Test
	void testDelete(){
		bookRepository.deleteAll();
	}

}
