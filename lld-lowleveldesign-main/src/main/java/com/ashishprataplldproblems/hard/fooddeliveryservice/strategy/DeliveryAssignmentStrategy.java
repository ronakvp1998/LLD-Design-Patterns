package com.ashishprataplldproblems.hard.fooddeliveryservice.strategy;

import com.ashishprataplldproblems.hard.fooddeliveryservice.entity.DeliveryAgent;
import com.ashishprataplldproblems.hard.fooddeliveryservice.order.Order;

import java.util.List;
import java.util.Optional;

public interface DeliveryAssignmentStrategy {
    Optional<DeliveryAgent> findAgent(Order order, List<DeliveryAgent> agents);
}
