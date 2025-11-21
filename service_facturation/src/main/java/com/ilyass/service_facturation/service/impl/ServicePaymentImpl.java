package com.ilyass.service_facturation.service.impl;

import com.ilyass.service_facturation.domaine.entity.Payment;
import com.ilyass.service_facturation.repository.PaymentRepository;
import com.ilyass.service_facturation.service.IServicePayment;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServicePaymentImpl implements IServicePayment {

    private final ServicePaymentImpl servicePayment;
    private final PaymentRepository paymentRepository;

    @Autowired
    public ServicePaymentImpl(ServicePaymentImpl servicePayment, PaymentRepository paymentRepository) {
        this.servicePayment = servicePayment;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void deletePayment(Payment payment) {
        servicePayment.deletePayment(payment);
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        if (paymentRepository.existsById(payment.getId())) {
            Payment oldPayment = paymentRepository.findById(payment.getId()).get();
            oldPayment.setAmount(payment.getAmount());
            oldPayment.setPaymentDate(payment.getPaymentDate());
            oldPayment.setInvoice(payment.getInvoice());
            oldPayment.setMethod(payment.getMethod());
            return paymentRepository.save(oldPayment);
        } else throw new EntityNotFoundException("Payment not found" + payment.getId());
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).get();
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

}
