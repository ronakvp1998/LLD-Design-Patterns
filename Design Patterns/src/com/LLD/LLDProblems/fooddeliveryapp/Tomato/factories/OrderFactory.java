package com.LLD.LLDProblems.fooddeliveryapp.Tomato.factories;

import java.util.List;
import com.LLD.LLDProblems.fooddeliveryapp.Tomato.models.*;
import com.LLD.LLDProblems.fooddeliveryapp.Tomato.strategies.*;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy, double totalCost, String orderType);
}