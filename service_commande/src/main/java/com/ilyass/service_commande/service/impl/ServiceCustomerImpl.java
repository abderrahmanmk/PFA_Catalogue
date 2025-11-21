package com.ilyass.service_commande.service.impl;

import com.ilyass.service_commande.domaine.entity.Customer;
import com.ilyass.service_commande.repository.CustomerRepository;
import com.ilyass.service_commande.service.IServiceCustomer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceCustomerImpl implements IServiceCustomer {

    private final CustomerRepository customerRepository;

    @Autowired
    public ServiceCustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerByName(String name) {
        return customerRepository.findByName(name).orElseThrow(() -> new
                EntityNotFoundException("Customer not found" + name));
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new
                EntityNotFoundException("Customer not found" + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getId())) {
            Customer oldCustomer = customerRepository.findById(customer.getId()).get();
            oldCustomer.setName(customer.getName());
            oldCustomer.setAddress(customer.getAddress());
            oldCustomer.setPhone(customer.getPhone());
            oldCustomer.setEmail(customer.getEmail());
            if (customer.getOrders() != null) {
                oldCustomer.setOrders(customer.getOrders());
            }
            return customerRepository.save(oldCustomer);
        } else throw new EntityNotFoundException("Role not found" + customer.getId());
    }

    @Override
    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else throw new EntityNotFoundException("Customer not found" + id);
    }


}





