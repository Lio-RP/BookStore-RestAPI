package com.dev.app.bookstorerestapi.conroller.v1;

import com.dev.app.bookstorerestapi.domain.Author;
import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.services.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Author Controller")
@RequestMapping("/api/v1/authors")
@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Operation(summary = "Get All Authors")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @Operation(summary = "Get All Books By Author")
    @GetMapping("/{id}/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooksByAuthor(@PathVariable Long id){
        return authorService.getAllBooksByAuthor(id);
    }

    @Operation(summary = "Get Author By his Id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @Operation(summary = "Create new Author")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author){
        return authorService.create(author);
    }

    @Operation(summary = "Update an existing Author")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author update(@PathVariable Long id, @RequestBody Author author){
        return authorService.update(id, author);
    }

    @Operation(summary = "Delete Author By Id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        authorService.deleteById(id);
    }
}
