package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long bookId);

    Book create(Book book);

    Book update(Long bookId, Book book);

    Book patch(Book book);

    void deleteById(Long bookId);


}
