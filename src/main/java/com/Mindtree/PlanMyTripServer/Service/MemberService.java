package com.Mindtree.PlanMyTripServer.Service;

import com.Mindtree.PlanMyTripServer.Model.OrderEntity;

import java.util.List;

public interface OrderService {
    public OrderEntity createOrder(OrderEntity order);
    public OrderEntity updateOrder(OrderEntity updateorder);
    OrderEntity getOrder(long pid);
    public List<OrderEntity> getOrders();
    public void deleteOrder(long pid);
}
