package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.domain.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    List<Book> getAllBooksByCategory(Long categoryId);

    Category getCategoryById(Long id);

    Category create(Category category);

    Category update(Long id, Category category);

    void deleteById(Long id);
}
