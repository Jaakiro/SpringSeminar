package ru.axe.hw8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.axe.hw8.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
}
