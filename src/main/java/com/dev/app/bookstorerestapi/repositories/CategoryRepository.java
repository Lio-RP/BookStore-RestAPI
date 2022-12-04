package com.dev.app.bookstorerestapi.repositories;

import com.dev.app.bookstorerestapi.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByCatName(String catName);
}
