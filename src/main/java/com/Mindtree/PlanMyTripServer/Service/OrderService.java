package com.Mindtree.PlanMyTripServer.Service;

import com.Mindtree.PlanMyTripServer.Model.OrderEntity;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
@Service
public interface OrderService {
    public OrderEntity createOrder(OrderEntity order) throws MessagingException;
    public OrderEntity updateOrder(OrderEntity updateorder);
    OrderEntity getOrder(long pid);
    public List<OrderEntity> getOrders();
    public void deleteOrder(long pid);
}
