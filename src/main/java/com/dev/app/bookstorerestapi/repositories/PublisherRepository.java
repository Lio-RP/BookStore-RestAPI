package com.dev.app.bookstorerestapi.repositories;

import com.dev.app.bookstorerestapi.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
