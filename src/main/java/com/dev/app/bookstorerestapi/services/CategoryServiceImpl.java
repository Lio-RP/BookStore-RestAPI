package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.domain.Category;
import com.dev.app.bookstorerestapi.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Book> getAllBooksByCategory(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);

        if(!category.isPresent()){
            throw new RuntimeException();
        }
        List<Book> books = category.get().getBooks();
        return books;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        category.setId(id);
        Category savedCategory = categoryRepository.save(category);
        return savedCategory;
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
