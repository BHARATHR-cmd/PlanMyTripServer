package com.Mindtree.PlanMyTripServer.Repository;

import com.Mindtree.PlanMyTripServer.Model.OrderEntity;
import com.Mindtree.PlanMyTripServer.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<OrderEntity,Long> {
}
