package com.dev.app.bookstorerestapi.repositories;

import com.dev.app.bookstorerestapi.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherInterface extends JpaRepository<Publisher, Long> {
}
