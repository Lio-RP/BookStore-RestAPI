package com.dev.app.bookstorerestapi.conroller.v1;

import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.domain.Category;
import com.dev.app.bookstorerestapi.services.CategoryService;
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
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CategoryControllerTest {

    @InjectMocks
    CategoryController controller;

    @Mock
    CategoryService categoryService;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllCategories() throws Exception {

        when(categoryService.getAllCategories()).thenReturn(Arrays.asList(new Category(), new Category()));

        mockMvc.perform(get("/api/v1/categories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(categoryService, times(1)).getAllCategories();
    }

    @Test
    public void getAllBooksByCategory() throws Exception {

        when(categoryService.getAllBooksByCategory(anyLong())).thenReturn(Arrays.asList(new Book(), new Book()));

        mockMvc.perform(get("/api/v1/categories/1/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(categoryService, times(1)).getAllBooksByCategory(anyLong());
    }

    @Test
    public void getCategoryById() throws Exception {

        when(categoryService.getCategoryById(anyLong())).thenReturn(new Category());

        mockMvc.perform(get("/api/v1/categories/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(categoryService, times(1)).getCategoryById(anyLong());
    }

    @Test
    public void create() throws Exception {
        Category category = new Category();
        category.setId(1L);
        category.setCatName("Category one");

        category.setBooks(Arrays.asList(new Book(), new Book(), new Book()));

        when(categoryService.create(any())).thenReturn(category);

        mockMvc.perform(post("/api/v1/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(category)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.catName", equalTo("Category one")))
                .andExpect(jsonPath("$.books", hasSize(3)));

        verify(categoryService, times(1)).create(any());
    }

    @Test
    public void update() throws Exception {
        Long id = 1L;

        Category category = new Category();
        category.setCatName("Category one");

        category.setBooks(Arrays.asList(new Book(), new Book(), new Book()));

        when(categoryService.update(id, category)).thenReturn(category);

        mockMvc.perform(put("/api/v1/categories/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(category)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.catName", equalTo("Category one")))
                .andExpect(jsonPath("$.books", hasSize(3)));

        verify(categoryService, times(1)).update(anyLong(), any());
    }

    @Test
    public void deleteById() throws Exception {

        mockMvc.perform(delete("/api/v1/categories/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(categoryService, times(1)).deleteById(anyLong());
    }
}