package com.icwd.electronic.store.repository;

import com.icwd.electronic.store.entity.Product;
import com.icwd.electronic.store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product , String> {

}
