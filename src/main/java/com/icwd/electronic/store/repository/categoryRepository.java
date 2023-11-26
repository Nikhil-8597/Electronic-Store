package com.icwd.electronic.store.repository;

import com.icwd.electronic.store.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends JpaRepository<Category, String> {
}
