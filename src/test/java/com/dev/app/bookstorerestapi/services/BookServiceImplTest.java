package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Author;
import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.repositories.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceImplTest {

    BookServiceImpl bookService;

    @Mock
    BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    public void getAllBooks() {

        //Given
        Book book1 = new Book();
        book1.setId(1L);
        book1.setBookName("Android 3.0");

        Book book2 = new Book();
        book2.setId(2L);
        book2.setBookName("Android 3.0");

        Author liban = new Author();
        liban.setId(1L);
        liban.setFirstName("Liban");
        liban.setLastName("Abdullahi");

        book1.setAuthors(Arrays.asList(liban));
        book2.setAuthors(Arrays.asList(liban));

        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        //when
        List<Book> books = bookService.getAllBooks();

        //then
        assertEquals(2, books.size());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    public void getBookById() {

        //Given
        Book book1 = new Book();
        book1.setId(1L);
        book1.setBookName("Android 3.0");

        Author liban = new Author();
        liban.setId(1L);
        liban.setFirstName("Liban");
        liban.setLastName("Abdullahi");

        book1.setAuthors(Arrays.asList(liban));

        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(book1));

        //when
        Book foundedBook = bookService.getBookById(1L);

        //then
        assertEquals(Long.valueOf(1L), foundedBook.getId());
        assertEquals(1, foundedBook.getAuthors().size());
        assertEquals(book1.getBookName(), foundedBook.getBookName());
        verify(bookRepository, times(1)).findById(anyLong());
    }

    @Test
    public void create() {
        //Given
        Long id = 1L;

        Book book1 = new Book();
        book1.setId(id);
        book1.setBookName("Android 3.0");

        Author liban = new Author();
        liban.setId(1L);
        liban.setFirstName("Liban");
        liban.setLastName("Abdullahi");

        book1.setAuthors(Arrays.asList(liban));

        when(bookRepository.save(any())).thenReturn(book1);

        //when
        Book savedBook = bookService.create(book1);

        assertEquals(Long.valueOf(1L), savedBook.getId());
        assertEquals(1, savedBook.getAuthors().size());
        assertEquals(book1.getBookName(), savedBook.getBookName());
        verify(bookRepository, times(1)).save(any());
    }

    @Test
    public void update() {
        //Given
        Long id = 1L;

        Book book1 = new Book();
        book1.setBookName("Android 3.0");

        Author liban = new Author();
        liban.setId(1L);
        liban.setFirstName("Liban");
        liban.setLastName("Abdullahi");

        book1.setAuthors(Arrays.asList(liban));

        when(bookRepository.save(any())).thenReturn(book1);

        //when
        Book updatedBook = bookService.update(id, book1);

        assertEquals(Long.valueOf(id), updatedBook.getId());
        assertEquals(book1.getBookName(), updatedBook.getBookName());
        verify(bookRepository, times(1)).save(any());
    }

    @Test
    public void deleteById() {

        bookService.deleteById(1L);

        verify(bookRepository, times(1)).deleteById(anyLong());
    }
}