package com.ilyass.service_commande.service.impl;

import com.ilyass.service_commande.domaine.entity.Order;
import com.ilyass.service_commande.repository.OrderRepository;
import com.ilyass.service_commande.service.IServiceOrder;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceOrderImpl implements IServiceOrder {

    private final OrderRepository orderRepository;

    @Autowired
    public ServiceOrderImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new
                EntityNotFoundException("Order not found" + id));
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public Order update(Order order) {
        if (orderRepository.existsById(order.getId())) {
            Order oldOrder = orderRepository.findById(order.getId()).get();
            oldOrder.setOrderDate(order.getOrderDate());
            oldOrder.setPrice(order.getPrice());
            oldOrder.setCustomer(order.getCustomer());
            oldOrder.setStatus_commande(order.getStatus_commande());
            return orderRepository.save(oldOrder);
        } else throw new EntityNotFoundException("Order not found" + order.getId());
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

}
