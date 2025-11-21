package com.ilyass.service_commande.service.impl;


import com.ilyass.service_commande.domaine.entity.OrderItem;
import com.ilyass.service_commande.repository.OrderItemRepository;
import com.ilyass.service_commande.service.IServiceOrderItem;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceOrderItemImpl implements IServiceOrderItem {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public ServiceOrderItemImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void delete(OrderItem orderItem) {
        orderItemRepository.delete(orderItem);
    }

    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElseThrow(() -> new
                EntityNotFoundException("Order Item not found" + id));
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        if (orderItemRepository.existsById(orderItem.getId())) {
            OrderItem oldOrderItem = orderItemRepository.findById(orderItem.getId()).get();
            oldOrderItem.setOrder(orderItem.getOrder());
            oldOrderItem.setQuantity(orderItem.getQuantity());
            oldOrderItem.setSubtotal(orderItem.getSubtotal());
            oldOrderItem.setUnitPrice(orderItem.getUnitPrice());
            oldOrderItem.setProductId(orderItem.getProductId());
            oldOrderItem.setProductName(orderItem.getProductName());
            return orderItemRepository.save(oldOrderItem);
        } else throw new EntityNotFoundException("OrderItem not found" + orderItem.getId());
    }

    @Override
    public List<OrderItem> getOrderItems() {
        return orderItemRepository.findAll();
    }
}
