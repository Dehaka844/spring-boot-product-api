package com.ejemplo.productapi.controller;

import com.ejemplo.productapi.model.Product;
import com.ejemplo.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Combina @Controller y @ResponseBody, indicando que devolverá JSON
@RequestMapping("/api/products" ) // Prefijo de URL para todos los métodos en esta clase
public class ProductController {

    @Autowired // Inyección de dependencias: Spring nos proporciona una instancia de ProductRepository
    private ProductRepository productRepository;

    // --- GET /api/products -> Obtener todos los productos ---
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // --- GET /api/products/{id} -> Obtener un producto por ID ---
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        // Si el producto existe, lo devuelve con un 200 OK. Si no, devuelve un 404 Not Found.
        return product.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // --- POST /api/products -> Crear un nuevo producto ---
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED); // Devuelve 201 Created
    }

    // --- PUT /api/products/{id} -> Actualizar un producto existente ---
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(productDetails.getName());
            existingProduct.setPrice(productDetails.getPrice());
            Product updatedProduct = productRepository.save(existingProduct);
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // --- DELETE /api/products/{id} -> Eliminar un producto ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
