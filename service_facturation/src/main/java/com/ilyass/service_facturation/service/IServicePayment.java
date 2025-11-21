package com.ilyass.service_facturation.service;

import com.ilyass.service_facturation.domaine.entity.Payment;

import java.util.List;

public interface IServicePayment {
    public Payment getPaymentById(Long id);

    public Payment createPayment(Payment payment);

    public Payment updatePayment(Payment payment);

    public void deletePayment(Payment payment);

    public List<Payment> getAllPayments();
}
