package com.lldproblems.fooddeliveryservice.strategy;

import com.lldproblems.fooddeliveryservice.entity.DeliveryAgent;
import com.lldproblems.fooddeliveryservice.order.Order;

import java.util.List;
import java.util.Optional;

public interface DeliveryAssignmentStrategy {
    Optional<DeliveryAgent> findAgent(Order order, List<DeliveryAgent> agents);
}
