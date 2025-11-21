package com.ilyass.service_commande.service;


import com.ilyass.service_commande.domaine.entity.Order;

import java.util.List;

public interface IServiceOrder {
    public Order findById(Long id);

    public List<Order> findAll();

    public void delete(Order order);

    public Order update(Order order);

    public Order createOrder(Order order);
}



