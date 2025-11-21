package com.ilyass.service_facturation.service.impl;

import com.ilyass.service_facturation.domaine.entity.Invoice;
import com.ilyass.service_facturation.repository.InvoiceRepository;
import com.ilyass.service_facturation.service.IServiceInvoice;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceInvoiceImpl implements IServiceInvoice {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public ServiceInvoiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new
                EntityNotFoundException("Invoice Item not found" + id));
    }

    @Override
    public void deleteInvoice(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }

    @Override
    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        if (invoiceRepository.existsById(invoice.getId())) {
            Invoice oldInvoice = invoiceRepository.findById(invoice.getId()).get();
            oldInvoice.setInvoiceDate(invoice.getInvoiceDate());
            oldInvoice.setInvoiceNumber(invoice.getInvoiceNumber());
            oldInvoice.setAmount(invoice.getAmount());
            oldInvoice.setStatus(invoice.getStatus());
            oldInvoice.setDueDate(invoice.getDueDate());
            oldInvoice.setDueDate(invoice.getDueDate());
            oldInvoice.setPayments(invoice.getPayments());
            oldInvoice.setOrderId(invoice.getOrderId());
            return invoiceRepository.save(oldInvoice);
        } else throw new EntityNotFoundException("Invoice not found" + invoice.getId());
    }
}

