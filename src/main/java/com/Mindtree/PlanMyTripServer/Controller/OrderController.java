package com.Mindtree.PlanMyTripServer.Controller;


import com.Mindtree.PlanMyTripServer.Model.OrderEntity;

import com.Mindtree.PlanMyTripServer.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public OrderEntity createorder(@RequestBody OrderEntity order) throws MessagingException {

        return this.orderService.createOrder(order);

    }
    @GetMapping("/{oid}")
    public OrderEntity getOrder(@PathVariable Long oid){
        return this.orderService.getOrder(oid);
    }
    @GetMapping("/")
    public List<OrderEntity> getPackages(){
        return this.orderService.getOrders();
    }

    @PutMapping("/")
    public OrderEntity updateOrder(@RequestBody OrderEntity updatedorder){

        return this.orderService.updateOrder(updatedorder);

    }

    @DeleteMapping("/{oid}")
    public void  deleteOrder(@PathVariable Long oid){
        this.orderService.deleteOrder(oid);
    }

}
