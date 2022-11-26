package com.dev.app.bookstorerestapi.repositories;

import com.dev.app.bookstorerestapi.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
