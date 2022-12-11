package com.dev.app.bookstorerestapi.LoadData;

import com.dev.app.bookstorerestapi.domain.*;
import com.dev.app.bookstorerestapi.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PrivilegeRepository privilegeRepository;

    public DataLoader(BookRepository bookRepository,
                      CategoryRepository categoryRepository,
                      AuthorRepository authorRepository,
                      PublisherRepository publisherRepository,
                      PasswordEncoder passwordEncoder,
                      CartRepository cartRepository,
                      OrderRepository orderRepository,
                      CustomerRepository customerRepository,
                      UserRepository userRepository,
                      RoleRepository roleRepository,
                      PrivilegeRepository privilegeRepository) {

        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.passwordEncoder = passwordEncoder;
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.privilegeRepository = privilegeRepository;
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
        book1.setPrice(25.5f);
        book1.setPages(665);

        Book book2 = new Book();
        book2.setBookName("Android Cookbook_ Problems and Solutions for Android Developers");
        book2.setIsbn(new BigInteger(String.valueOf(123456784)));
        book2.setEdition("Android 8 Edition");
        book2.setPublisher(publisher);
        book2.setPages(776);
        book2.setPrice(36.34f);

        Book book3 = new Book();
        book3.setBookName("Head-First-Android-Development-A-Brain-Friendly-Guide");
        book3.setIsbn(new BigInteger(String.valueOf(1234523450)));
        book3.setEdition("Android 8 Edition");
        book3.setPublisher(publisher);
        book3.setPages(876);
        book3.setPrice(45.99f);

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

        System.out.println("Load User Data!");

        User liban = new User();
        liban.setFirstName("liban");
        liban.setLastName("Abdullahi");
        liban.setUserName("liban");
        liban.setEmail("libanr4243@gmail.com");
        liban.setPassword(passwordEncoder.encode("liban123"));

        User customer_user = new User();
        customer_user.setFirstName("Customer name");
        customer_user.setLastName("Customer last name");
        customer_user.setUserName("customer");
        customer_user.setEmail("customer@gmail.com");
        customer_user.setPassword(passwordEncoder.encode("customer123"));

        userRepository.save(liban);
        userRepository.save(customer_user);

        Privilege book_read = new Privilege();
        book_read.setPrivilege("BOOK_READ");

        Privilege book_write = new Privilege();
        book_write.setPrivilege("BOOK_WRITE");

        Role customer_role = new Role();
        customer_role.setRole("CUSTOMER");
        customer_role.getUsers().add(customer_user);
        customer_role.setPrivileges(Arrays.asList(book_read));
        customer_user.setRoles(Arrays.asList(customer_role));

        Role admin_role = new Role();
        admin_role.setRole("ADMIN");
        admin_role.setUsers(Arrays.asList(liban));
        admin_role.setPrivileges(Arrays.asList(book_read, book_write));
        liban.setRoles(Arrays.asList(admin_role));

        privilegeRepository.save(book_write);
        privilegeRepository.save(book_read);

        roleRepository.save(customer_role);
        roleRepository.save(admin_role);

        userRepository.save(liban);
        userRepository.save(customer_user);

        System.out.println("Count Loaded Users: " + userRepository.count());
        System.out.println("Count Loaded Privileges: " + privilegeRepository.count());
        System.out.println("Count Loaded Roles: " + roleRepository.count());

        Cart cart1 = new Cart();
        cart1.setBook(book1);
        cart1.setUser(customer_user);
        cart1.setQuantity(1);
        cart1.setSubtotalPrice(book1.getPrice());
        cart1.setUser(customer_user);

        Cart cart2 = new Cart();
        cart2.setBook(book2);
        cart2.setUser(customer_user);
        cart2.setQuantity(1);
        cart2.setSubtotalPrice(book1.getPrice());
        cart2.setUser(customer_user);

        cartRepository.save(cart1);
        cartRepository.save(cart2);

        System.out.println("Count Loaded Carts: " + cartRepository.count());
    }
}
