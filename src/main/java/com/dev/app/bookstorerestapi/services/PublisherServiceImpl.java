package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.domain.Publisher;
import com.dev.app.bookstorerestapi.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Book> getAllBooksByPublisher(Long id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);

        if(!publisher.isPresent()){
            throw new RuntimeException();
        }

        List<Book> books = publisher.get().getBooks();
        return books;
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id).orElse(null);
    }

    @Override
    public Publisher create(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Long id, Publisher publisher) {
        publisher.setId(id);
        Publisher updatedPublisher = publisherRepository.save(publisher);
        return updatedPublisher;
    }

    @Override
    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }
}
