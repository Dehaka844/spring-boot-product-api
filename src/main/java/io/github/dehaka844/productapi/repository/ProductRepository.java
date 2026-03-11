package com.ejemplo.productapi.repository;

import com.ejemplo.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Le indica a Spring que esta es una interfaz de acceso a datos
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Al extender JpaRepository<Product, Long>, Spring automáticamente nos provee métodos como:
    // - save(Product product) -> para crear y actualizar
    // - findAll() -> para obtener todos
    // - findById(Long id) -> para obtener uno por su ID
    // - deleteById(Long id) -> para borrar
    // ¡Y no necesitamos escribir ninguna implementación!
}
