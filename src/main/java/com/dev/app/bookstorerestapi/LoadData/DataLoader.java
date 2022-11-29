package com.dev.app.bookstorerestapi.LoadData;

import com.dev.app.bookstorerestapi.domain.Author;
import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.domain.Category;
import com.dev.app.bookstorerestapi.domain.Publisher;
import com.dev.app.bookstorerestapi.repositories.AuthorRepository;
import com.dev.app.bookstorerestapi.repositories.BookRepository;
import com.dev.app.bookstorerestapi.repositories.CategoryRepository;
import com.dev.app.bookstorerestapi.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public DataLoader(BookRepository bookRepository,
                      CategoryRepository categoryRepository,
                      AuthorRepository authorRepository,
                      PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    public void loadData(){

        System.out.println("Bootstrap data started!");

        Publisher publisher = new Publisher();
        publisher.setName("SVG publishing");
        publisher.setCity("Vladimir");
        publisher.setState("Vladimir state");
        publisher.setAddressLine1("Stroiteley avenue 7G");
        publisher.setZip("600001");

        publisherRepository.save(publisher);

        Book book1 = new Book();
        book1.setBookName("Android Studio 3.0 Development Essentials, Android 8 Edition by Neil Smyth");
        book1.setIsbn(new BigInteger(String.valueOf(1234567890)));
        book1.setEdition("Android 8 Edition");
        book1.setPublisher(publisher);

        Book book2 = new Book();
        book2.setBookName("Android Cookbook_ Problems and Solutions for Android Developers");
        book2.setIsbn(new BigInteger(String.valueOf(123456784)));
        book2.setEdition("Android 8 Edition");
        book2.setPublisher(publisher);

        Book book3 = new Book();
        book3.setBookName("Head-First-Android-Development-A-Brain-Friendly-Guide");
        book3.setIsbn(new BigInteger(String.valueOf(1234523450)));
        book3.setEdition("Android 8 Edition");
        book3.setPublisher(publisher);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        publisher.setBooks(Arrays.asList(book1, book2, book3));

        Category category = new Category();
        category.setCatName("Programming");
        category.getBooks().add(book1);
        category.getBooks().add(book2);
        category.getBooks().add(book3);

        book1.setCategory(category);
        book2.setCategory(category);
        book3.setCategory(category);

        Author author1 = new Author();
        author1.setFirstName("Liban");
        author1.setLastName("Abdullahi");
        author1.setPhoneNumber("+79964426139");
        author1.setEmail("libanr4243@gmail.com");
        author1.getBooks().add(book1);
        author1.getBooks().add(book2);
        author1.getBooks().add(book3);

        book1.getAuthors().add(author1);
        book2.getAuthors().add(author1);
        book3.getAuthors().add(author1);

        categoryRepository.save(category);
        authorRepository.save(author1);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
    }
}
