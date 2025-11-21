package com.ilyass.service_catalogue.domaine.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ✅ Utiliser Long pour rester cohérent avec Product

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    // ✅ Relation OneToMany : une catégorie peut avoir plusieurs produits
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    // ✅ Constructeur vide requis par JPA
    public Category() {
    }

    // ✅ Constructeur complet
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // ✅ Getters et Setters
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
