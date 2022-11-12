package com.ozu.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozu.exam.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
	public List<Book> findByTitleOrAuthor(String title, String author);
}
