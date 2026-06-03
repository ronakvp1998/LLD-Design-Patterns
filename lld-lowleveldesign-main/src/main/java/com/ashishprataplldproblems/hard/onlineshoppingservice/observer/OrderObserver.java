package com.ashishprataplldproblems.hard.onlineshoppingservice.observer;

import com.ashishprataplldproblems.hard.onlineshoppingservice.models.Order;

public interface OrderObserver {
    void update(Order order);
}
