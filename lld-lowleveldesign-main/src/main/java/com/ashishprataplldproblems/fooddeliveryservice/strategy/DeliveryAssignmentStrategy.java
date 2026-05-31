package com.ashishprataplldproblems.fooddeliveryservice.strategy;

import com.ashishprataplldproblems.fooddeliveryservice.entity.DeliveryAgent;
import com.ashishprataplldproblems.fooddeliveryservice.order.Order;

import java.util.List;
import java.util.Optional;

public interface DeliveryAssignmentStrategy {
    Optional<DeliveryAgent> findAgent(Order order, List<DeliveryAgent> agents);
}
