package com.dev.app.bookstorerestapi.repositories;

import com.dev.app.bookstorerestapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
