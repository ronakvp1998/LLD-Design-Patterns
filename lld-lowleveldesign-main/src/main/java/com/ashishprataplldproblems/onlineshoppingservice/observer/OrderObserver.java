package com.ashishprataplldproblems.onlineshoppingservice.observer;

import com.ashishprataplldproblems.onlineshoppingservice.models.Order;

public interface OrderObserver {
    void update(Order order);
}
