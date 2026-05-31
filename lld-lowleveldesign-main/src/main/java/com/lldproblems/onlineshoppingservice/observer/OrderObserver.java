package com.lldproblems.onlineshoppingservice.observer;

import com.lldproblems.onlineshoppingservice.models.Order;

public interface OrderObserver {
    void update(Order order);
}
