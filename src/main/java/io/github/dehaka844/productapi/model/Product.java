package com.ejemplo.productapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Le dice a JPA que esta clase es una tabla en la BD
public class Product {

    @Id // Marca este campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Le dice a la BD que genere el ID automáticamente
    private Long id;

    private String name;
    private double price;

    // --- Constructores, Getters y Setters ---
    // Son necesarios para que el framework pueda crear y acceder a las propiedades del objeto.

    public Product() {
        // Constructor vacío requerido por JPA
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
