package com.ashishprataplldproblems.hard.fooddeliveryservice.observer;

import com.ashishprataplldproblems.hard.fooddeliveryservice.order.Order;

public interface OrderObserver {
    void onUpdate(Order order);
}
