package com.dev.app.bookstorerestapi.repositories;

import com.dev.app.bookstorerestapi.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT role FROM Role role WHERE role.role=:role")
    Role findByRole(String role);
}
