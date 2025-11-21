package com.ilyass.service_facturation.domaine.entity;

import com.ilyass.service_facturation.domaine.enums.Payment_method;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date paymentDate = new Date();

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Payment_method method;

    // ✅ Relation : plusieurs paiements peuvent appartenir à une seule facture
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    // ✅ Constructeur vide obligatoire pour JPA
    public Payment() {
    }

    // ✅ Constructeur complet (optionnel)
    public Payment(Long id, Date paymentDate, Double amount, Payment_method method, Invoice invoice) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.method = method;
        this.invoice = invoice;
    }

    // ✅ Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Payment_method getMethod() {
        return method;
    }

    public void setMethod(Payment_method method) {
        this.method = method;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
