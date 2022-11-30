package com.ozu.exam;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ozu.exam.model.Book;
import com.ozu.exam.repository.BookRepository;

@SpringBootTest
class BookRepoTests {
	@Autowired
	BookRepository repo;

	@Test
	void testBookRepo() {
		Book book1 = new Book("6054898019", "Eclipse ile Java", "Esma Meral", "Dikey Eksen");
		Book book4 = new Book("6054898022", "Spring Framework", "Esma Meral", "Dikey Eksen");
		Book book2 = new Book("1234567981", "Introduction to Java Programming", "Daniel Liang", "Pearson");
		Book book3 = new Book("12", "Introduction to Java Programming", "", "");
		repo.save(book1);
		repo.save(book2);
		repo.save(book3);
		repo.save(book4);
		List<Book> books = repo.findByTitleOrAuthor("Eclipse ile Java", "Daniel Liang");
		for (Book book : books) {
			System.out.println(book);
		}
		List<Book> books1 = repo.findByPriceGreaterThanEqualAndPriceLessThanEqual(0,100);
		for (Book book : books1) {
			System.out.println(book);
		}
	}

}
