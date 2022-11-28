package com.Mindtree.PlanMyTripServer.Service.Impl;

import com.Mindtree.PlanMyTripServer.Model.OrderEntity;
import com.Mindtree.PlanMyTripServer.Repository.OrderRepository;
import com.Mindtree.PlanMyTripServer.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderEntity createOrder(OrderEntity order) {
        return this.orderRepository.save(order);
    }

    @Override
    public OrderEntity updateOrder(OrderEntity updateorder) {
        return this.orderRepository.save(updateorder);
    }

    @Override
    public OrderEntity getOrder(long oid) {
        return this.orderRepository.findById(oid).get();
    }

    @Override
    public List<OrderEntity> getOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public void deleteOrder(long oid) {
        this.orderRepository.deleteById(oid);
    }
}
