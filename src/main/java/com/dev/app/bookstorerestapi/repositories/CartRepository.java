package com.dev.app.bookstorerestapi.repositories;

import com.dev.app.bookstorerestapi.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
