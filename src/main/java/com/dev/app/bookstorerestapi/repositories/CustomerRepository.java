package com.dev.app.bookstorerestapi.repositories;

import com.dev.app.bookstorerestapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
