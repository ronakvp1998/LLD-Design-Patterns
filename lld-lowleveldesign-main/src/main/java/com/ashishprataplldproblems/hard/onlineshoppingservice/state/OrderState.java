package com.ashishprataplldproblems.hard.onlineshoppingservice.state;

import com.ashishprataplldproblems.hard.onlineshoppingservice.models.Order;

public interface OrderState {
    void ship(Order order);
    void deliver(Order order);
    void cancel(Order order);
}
