package com.ilyass.service_facturation.service;

import com.ilyass.service_facturation.domaine.entity.Invoice;

import java.util.List;

public interface IServiceInvoice {
    public Invoice getInvoiceById(Long id);

    public List<Invoice> getAllInvoice();

    public Invoice updateInvoice(Invoice invoice);

    public void deleteInvoice(Invoice invoice);

    public Invoice createInvoice(Invoice invoice);
}
