package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Author;
import com.dev.app.bookstorerestapi.domain.Book;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    List<Book> getAllBooksByAuthor(Long authorId);

    Author getAuthorById(Long id);

    Author create(Author author);

    Author update(Long id, Author author);

    void deleteById(Long id);
}
