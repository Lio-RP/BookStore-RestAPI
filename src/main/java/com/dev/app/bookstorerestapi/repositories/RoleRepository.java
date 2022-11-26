package com.dev.app.bookstorerestapi.repositories;

import com.dev.app.bookstorerestapi.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
