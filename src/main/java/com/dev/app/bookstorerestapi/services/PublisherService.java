package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.domain.Publisher;

import java.util.List;

public interface PublisherService {

    List<Publisher> getAllPublishers();

    List<Book> getAllBooksByPublisher(Long id);

    Publisher getPublisherById(Long id);

    Publisher create(Publisher publisher);

    Publisher update(Long id, Publisher publisher);

    void deleteById(Long id);
}
