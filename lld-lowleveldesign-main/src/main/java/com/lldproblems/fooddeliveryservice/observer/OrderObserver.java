package com.lldproblems.fooddeliveryservice.observer;

import com.lldproblems.fooddeliveryservice.order.Order;

public interface OrderObserver {
    void onUpdate(Order order);
}
