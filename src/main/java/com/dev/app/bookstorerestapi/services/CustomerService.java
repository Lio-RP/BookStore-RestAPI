package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Customer;
import com.dev.app.bookstorerestapi.domain.User;

public interface CustomerService {

    Customer create(Customer customer, User user);
}
