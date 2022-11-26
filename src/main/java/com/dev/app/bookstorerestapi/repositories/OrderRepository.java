package com.dev.app.bookstorerestapi.repositories;

import com.dev.app.bookstorerestapi.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
