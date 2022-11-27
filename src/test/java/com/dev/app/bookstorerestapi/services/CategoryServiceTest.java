package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.domain.Category;
import com.dev.app.bookstorerestapi.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CategoryServiceTest {

    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        categoryService = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    public void getAllCategories() {

        when(categoryRepository.findAll()).thenReturn(Arrays.asList(new Category(), new Category(), new Category()));

        //when
        List<Category> categories = categoryService.getAllCategories();

        //then
        assertEquals(3, categories.size());
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    public void getAllBooksByCategory() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setBookName("Book one");

        Book book2 = new Book();
        book2.setId(2L);
        book2.setBookName("Book Two");

        Category category = new Category();
        category.setBooks(Arrays.asList(book1, book2));

        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category));

        //when
        List<Book> books = categoryService.getAllBooksByCategory(anyLong());

        //then
        assertEquals(2, books.size());
        verify(categoryRepository, times(1)).findById(anyLong());
    }

    @Test
    public void getCategoryById() {
        Category category = new Category();
        category.setId(1L);

        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category));

        //when
        Category category1 = categoryService.getCategoryById(anyLong());

        //then
        assertEquals(Long.valueOf(1L), category1.getId());
        verify(categoryRepository, times(1)).findById(anyLong());
    }

    @Test
    public void create() {
        Category category = new Category();
        category.setId(1L);
        category.setCatName("Category one");

        when(categoryRepository.save(any())).thenReturn(category);

        //when
        Category savedCategory = categoryService.create(any());

        //then
        assertEquals(category.getId(), savedCategory.getId());
        assertEquals(category.getCatName(), savedCategory.getCatName());
        verify(categoryRepository, times(1)).save(any());
    }

    @Test
    public void update() {
        Long id = 1L;

        Category category = new Category();
        category.setCatName("Category one");

        when(categoryRepository.save(any())).thenReturn(category);

        //when
        Category savedCategory = categoryService.update(id, category);

        //then
        assertEquals(Long.valueOf(id), savedCategory.getId());
        assertEquals(category.getCatName(), savedCategory.getCatName());
        verify(categoryRepository, times(1)).save(any());
    }

    @Test
    public void deleteById() {
        Long id = 1L;

        categoryService.deleteById(id);

        verify(categoryRepository, times(1)).deleteById(anyLong());
    }
}