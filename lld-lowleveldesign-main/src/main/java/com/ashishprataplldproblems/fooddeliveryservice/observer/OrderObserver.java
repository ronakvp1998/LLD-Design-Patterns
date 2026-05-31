package com.ashishprataplldproblems.fooddeliveryservice.observer;

import com.ashishprataplldproblems.fooddeliveryservice.order.Order;

public interface OrderObserver {
    void onUpdate(Order order);
}
