package com.ilyass.service_catalogue.domaine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ✅ Utiliser Long pour rester cohérent avec Product

    @Column(nullable = false)
    private Integer quantity;

    // ✅ Relation OneToOne : chaque stock correspond à un seul produit
    @OneToOne
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;

    // ✅ Constructeur vide requis par JPA
    public Stock() {
    }

    // ✅ Constructeur complet
    public Stock(Long id, Integer quantity, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }

    // ✅ Getters / Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
