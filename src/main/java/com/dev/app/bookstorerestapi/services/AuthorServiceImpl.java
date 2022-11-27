package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Author;
import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Book> getAllBooksByAuthor(Long authorId) {

        Optional<Author> author = authorRepository.findById(authorId);

        if(!author.isPresent()){
            throw new RuntimeException();
        }

        List<Book> books = author.get().getBooks();

        return books;
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Long id, Author author) {
        author.setId(id);
        Author savedAuthor = authorRepository.save(author);
        return savedAuthor;
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
