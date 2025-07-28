package com.LLD.LLDProblems.fooddeliveryapp.Tomato.factories;

import java.util.List;
import com.LLD.LLDProblems.fooddeliveryapp.Tomato.models.*;
import com.LLD.LLDProblems.fooddeliveryapp.Tomato.strategies.*;
import com.LLD.LLDProblems.fooddeliveryapp.Tomato.utils.TimeUtils;

public class NowOrderFactory implements OrderFactory {
    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                             PaymentStrategy paymentStrategy, double totalCost, String orderType) {
        Order order = null;

        if (orderType.equals("Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(TimeUtils.getCurrentTime());
        order.setTotal(totalCost);
        return order;
    }
}
