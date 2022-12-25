package com.dev.app.bookstorerestapi.conroller.v1;

import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.domain.Category;
import com.dev.app.bookstorerestapi.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Category Controller")
@RequestMapping("/api/v1/categories")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Get All Categories")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @Operation(summary = "Get All Books by Category")
    @GetMapping("/{id}/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooksByCategory(@PathVariable Long id){
        return categoryService.getAllBooksByCategory(id);
    }

    @Operation(summary = "Get Category By Id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @Operation(summary = "Create new Category")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @Operation(summary = "Update an existing Category")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public Category update(@PathVariable Long id, @RequestBody Category category){
        return categoryService.update(id, category);
    }

    @Operation(summary = "Delete Category By Id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
    }
}
