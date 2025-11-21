package com.ilyass.service_commande.service;

import com.ilyass.service_commande.domaine.entity.OrderItem;

import java.util.List;

public interface IServiceOrderItem {
    public OrderItem createOrderItem(OrderItem orderItem);

    public void delete(OrderItem orderItem);

    public List<OrderItem> getOrderItems();

    public OrderItem getOrderItemById(Long id);

    public OrderItem updateOrderItem(OrderItem orderItem);
}
