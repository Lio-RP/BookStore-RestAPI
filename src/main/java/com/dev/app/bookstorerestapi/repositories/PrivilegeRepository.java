package com.dev.app.bookstorerestapi.repositories;

import com.dev.app.bookstorerestapi.domain.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
