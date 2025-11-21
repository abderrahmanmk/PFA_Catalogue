package com.ilyass.service_commande.domaine.entity;

import com.ilyass.commande_service.domaine.enums.Status_commande;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ⚠️ Recommandé d’utiliser Long au lieu de int

    @Temporal(TemporalType.TIMESTAMP) // ✅ Indique que c’est une date avec heure
    @Column(nullable = false)
    private Date orderDate;

    @Enumerated(EnumType.STRING) // ✅ Sauvegarde le nom du statut (ex: "EN_COURS")
    @Column(nullable = false)
    private Status_commande status_commande;

    @Column(nullable = false)
    private double price;

    // ✅ Relation : plusieurs commandes peuvent appartenir à un seul client
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // ✅ Relation : une commande contient plusieurs lignes (OrderItem)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    // ✅ Constructeur vide (obligatoire pour JPA)
    public Order() {
    }

    // ✅ Constructeur complet
    public Order(Long id, Date orderDate, Status_commande status_commande, double price,
                 Customer customer, List<OrderItem> orderItems) {
        this.id = id;
        this.orderDate = orderDate;
        this.status_commande = status_commande;
        this.price = price;
        this.customer = customer;
        this.orderItems = orderItems;
    }

    // ✅ Getters / Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Status_commande getStatus_commande() {
        return status_commande;
    }

    public void setStatus_commande(Status_commande status_commande) {
        this.status_commande = status_commande;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
