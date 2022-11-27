package com.dev.app.bookstorerestapi.conroller.v1;

import com.dev.app.bookstorerestapi.domain.Author;
import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.services.AuthorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static com.dev.app.bookstorerestapi.conroller.v1.AbstractRestController.asJsonString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthorControllerTest {

    @InjectMocks
    AuthorController controller;

    @Mock
    AuthorService authorService;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllAuthors() throws Exception {

        when(authorService.getAllAuthors()).thenReturn(Arrays.asList(new Author(), new Author()));

        mockMvc.perform(get("/api/v1/authors/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(authorService, times(1)).getAllAuthors();
    }

    @Test
    public void getAllBooksByAuthor() throws Exception {
        Book book1 = new Book();
        book1.setId(1L);

        Author author = new Author();
        author.setId(1L);

        author.setBooks(Arrays.asList(book1, new Book(), new Book()));

        when(authorService.getAllBooksByAuthor(anyLong())).thenReturn(author.getBooks());

        mockMvc.perform(get("/api/v1/authors/1/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(authorService, times(1)).getAllBooksByAuthor(anyLong());
    }

    @Test
    public void getAuthorById() throws Exception {

        when(authorService.getAuthorById(anyLong())).thenReturn(new Author());

        mockMvc.perform(get("/api/v1/authors/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(authorService, times(1)).getAuthorById(anyLong());
    }

    @Test
    public void create() throws Exception {
        Author author = new Author();
        author.setId(1L);

        when(authorService.create(any())).thenReturn(author);

        mockMvc.perform(post("/api/v1/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(author)))
                .andExpect(status().isCreated());

        verify(authorService, times(1)).create(any());
    }

    @Test
    public void update() throws Exception {
        Author author = new Author();
        author.setId(1L);

        when(authorService.update(anyLong(), any())).thenReturn(author);

        mockMvc.perform(put("/api/v1/authors/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(author)))
                .andExpect(status().isOk());

        verify(authorService, times(1)).update(anyLong(), any());
    }

    @Test
    public void deleteById() throws Exception {

        mockMvc.perform(delete("/api/v1/authors/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(authorService, times(1)).deleteById(anyLong());
    }
}