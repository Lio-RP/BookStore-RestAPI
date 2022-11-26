package com.dev.app.bookstorerestapi.conroller.v1;

import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.services.BookService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static com.dev.app.bookstorerestapi.conroller.v1.AbstractRestController.asJsonString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookControllerTest {

    @InjectMocks
    BookController bookController;

    @Mock
    BookService bookService;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void getAllBooks() throws Exception {
        List<Book> books = Arrays.asList(new Book(), new Book());

        when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(get("/api/v1/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(bookService, times(1)).getAllBooks();
    }

    @Test
    public void getBookById() throws Exception {
        Book book = new Book();
        book.setBookName("android");

        when(bookService.getBookById(anyLong())).thenReturn(book);

        mockMvc.perform(get("/api/v1/books/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookName", equalTo("android")));

        verify(bookService, times(1)).getBookById(anyLong());
    }

    @Test
    public void create() throws Exception {
        Book book = new Book();
        book.setId(1L);
        book.setBookName("android");

        when(bookService.create(any())).thenReturn(book);

        mockMvc.perform(post("/api/v1/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(book)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.bookName", equalTo("android")));

        verify(bookService, times(1)).create(any());
    }

    @Test
    public void update() throws Exception {
        Long id = 1L;
        Book book = new Book();
        book.setBookName("android");

        when(bookService.update(anyLong(), any())).thenReturn(book);

        mockMvc.perform(put("/api/v1/books/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(book)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookName", equalTo("android")));

        verify(bookService, times(1)).update(anyLong(), any());
    }

    @Test
    public void deleteById() throws Exception {

        mockMvc.perform(delete("/api/v1/books/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(bookService, times(1)).deleteById(anyLong());
    }
}