package com.ilyass.service_facturation.domaine.entity;

import com.ilyass.service_facturation.domaine.enums.Invoice_status;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 30)
    private String invoiceNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date invoiceDate = new Date();

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dueDate;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Invoice_status status;

    // ✅ Relation optionnelle avec une commande (ou un autre service)
    @Column(name = "order_id")
    private Long orderId;

    // ✅ Relation OneToMany avec Payment
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments;

    // ✅ Constructeur vide (obligatoire pour JPA)
    public Invoice() {
    }

    // ✅ Constructeur complet
    public Invoice(Long id, String invoiceNumber, Date invoiceDate, Date dueDate,
                   Double amount, Invoice_status status, Long orderId, List<Payment> payments) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.amount = amount;
        this.status = status;
        this.orderId = orderId;
        this.payments = payments;
    }

    // ✅ Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Invoice_status getStatus() {
        return status;
    }

    public void setStatus(Invoice_status status) {
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
