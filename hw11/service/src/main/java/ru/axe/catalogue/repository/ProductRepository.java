package ru.axe.catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.axe.catalogue.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
}
