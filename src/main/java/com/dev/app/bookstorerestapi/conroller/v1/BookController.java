package com.dev.app.bookstorerestapi.conroller.v1;

import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Book Controller")
@RequestMapping("/api/v1/books")
@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Get All Books")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @Operation(summary = "Get Book By Id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @Operation(summary = "Create new Book")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public Book create(@RequestBody Book book){
        return bookService.create(book);
    }

    @Operation(summary = "Update an existing Book")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public Book update(@PathVariable Long id, @RequestBody Book book){
        return bookService.update(id, book);
    }

    @Operation(summary = "Delete Book By id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable Long id){
        bookService.deleteById(id);
    }
}
