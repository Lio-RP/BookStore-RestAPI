package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Customer;
import com.dev.app.bookstorerestapi.domain.User;
import com.dev.app.bookstorerestapi.repositories.CustomerRepository;
import com.dev.app.bookstorerestapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Customer create(Customer customer, User user) {
        customer.setUser(user);
        Customer savedCustomer = customerRepository.save(customer);
        user.setCustomer(savedCustomer);
        userRepository.save(user);
        return savedCustomer;
    }
}
