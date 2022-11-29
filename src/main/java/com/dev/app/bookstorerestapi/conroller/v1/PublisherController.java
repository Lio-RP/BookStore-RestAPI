package com.dev.app.bookstorerestapi.conroller.v1;

import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.domain.Publisher;
import com.dev.app.bookstorerestapi.services.PublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Publisher Controller")
@RequestMapping("/api/v1/publisher")
@RestController
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Operation(summary = "Get All Publishers")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> getAllPublishers(){
        return publisherService.getAllPublishers();
    }

    @Operation(summary = "Get All Books By Publisher")
    @GetMapping("/{id}/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooksByPublisher(@PathVariable Long id){
        return publisherService.getAllBooksByPublisher(id);
    }

    @Operation(summary = "Get Publisher By Id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getPublisherById(@PathVariable Long id){
        return publisherService.getPublisherById(id);
    }

    @Operation(summary = "Create new Publisher")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(Publisher publisher){
        return publisherService.create(publisher);
    }

    @Operation(summary = "Update an existing Publisher")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher update(@PathVariable Long id, @RequestBody Publisher publisher){
        return publisherService.update(id, publisher);
    }

    @Operation(summary = "Delete an existing Publisher")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        publisherService.deleteById(id);
    }
}
