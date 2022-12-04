package com.dev.app.bookstorerestapi.repositories;

import com.dev.app.bookstorerestapi.domain.Cart;
import com.dev.app.bookstorerestapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT cart FROM Cart cart WHERE cart.user=:user")
    List<Cart> findCartsByUser(@Param("user") User user);
}
