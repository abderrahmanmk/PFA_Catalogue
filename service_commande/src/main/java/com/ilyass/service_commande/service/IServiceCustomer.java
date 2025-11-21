package com.ilyass.service_commande.service;

import com.ilyass.service_commande.domaine.entity.Customer;

import java.util.List;

public interface IServiceCustomer {
    public Customer getCustomerByName(String name);

    public Customer getCustomerById(Long id);

    public List<Customer> getCustomers();

    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public void deleteCustomer(Long id);
}
