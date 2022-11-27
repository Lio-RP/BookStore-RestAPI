package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Author;
import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.repositories.AuthorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AuthorServiceTest {

    AuthorService authorService;

    @Mock
    AuthorRepository authorRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        authorService = new AuthorServiceImpl(authorRepository);
    }

    @Test
    public void getAllAuthors() {

        when(authorRepository.findAll()).thenReturn(Arrays.asList(new Author(), new Author()));

        //when
        List<Author> authors = authorService.getAllAuthors();

        //then
        assertEquals(2, authors.size());
        verify(authorRepository, times(1)).findAll();
    }

    @Test
    public void getAllBooksByAuthor() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setBookName("Book one");

        Book book2 = new Book();
        book2.setId(2L);
        book2.setBookName("Book two");

        Author author = new Author();
        author.setId(1L);
        author.setBooks(Arrays.asList(book1, book2));

        when(authorRepository.findById(anyLong())).thenReturn(Optional.of(author));

        //when
        List<Book> books = authorService.getAllBooksByAuthor(book1.getId());

        //then
        assertEquals(2, books.size());
        verify(authorRepository, times(1)).findById(anyLong());
    }

    @Test
    public void getAuthorById() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setBookName("Book one");

        Author author = new Author();
        author.setId(1L);
        author.setBooks(Arrays.asList(book1));

        when(authorRepository.findById(anyLong())).thenReturn(Optional.of(author));

        //when
        Author foundedAuthor = authorService.getAuthorById(1L);

        //then
        assertEquals(Long.valueOf(author.getId()), foundedAuthor.getId());
        assertEquals(author.getBooks().size(), foundedAuthor.getBooks().size());
        verify(authorRepository, times(1)).findById(anyLong());

    }

    @Test
    public void create() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setBookName("Book one");

        Author author = new Author();
        author.setId(1L);
        author.setBooks(Arrays.asList(book1));

        when(authorRepository.save(any())).thenReturn(author);

        //when
        Author savedAuthor = authorService.create(author);

        //then
        assertEquals(Long.valueOf(author.getId()), savedAuthor.getId());
        assertEquals(author.getBooks().size(), savedAuthor.getBooks().size());
        verify(authorRepository, times(1)).save(any());
    }

    @Test
    public void update() {
        Long id = 1L;

        Book book1 = new Book();
        book1.setId(1L);
        book1.setBookName("Book one");

        Author author = new Author();
        author.setBooks(Arrays.asList(book1));

        when(authorRepository.save(any())).thenReturn(author);

        //when
        Author savedAuthor = authorService.update(id, author);

        //then
        assertEquals(Long.valueOf(id), savedAuthor.getId());
        assertEquals(author.getBooks().size(), savedAuthor.getBooks().size());
        verify(authorRepository, times(1)).save(any());
    }

    @Test
    public void deleteById() {

        authorService.deleteById(1L);

        verify(authorRepository, times(1)).deleteById(anyLong());
    }
}