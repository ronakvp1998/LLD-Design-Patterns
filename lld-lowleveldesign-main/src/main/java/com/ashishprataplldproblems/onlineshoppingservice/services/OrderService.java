package com.ashishprataplldproblems.onlineshoppingservice.services;

import com.ashishprataplldproblems.onlineshoppingservice.models.Customer;
import com.ashishprataplldproblems.onlineshoppingservice.models.Order;
import com.ashishprataplldproblems.onlineshoppingservice.models.OrderLineItem;
import com.ashishprataplldproblems.onlineshoppingservice.models.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final InventoryService inventoryService;

    public OrderService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public Order createOrder(Customer customer, ShoppingCart cart) {
        List<OrderLineItem> result = new ArrayList<>();
        cart.getItems().values().stream()
            .map(cartItem -> new OrderLineItem(
                    cartItem.getProduct().getId(),
                    cartItem.getProduct().getName(),
                    cartItem.getQuantity(),
                    cartItem.getProduct().getPrice()))
            .forEach(result::add);

        inventoryService.updateStockForOrder(result);

        return new Order(customer, result, customer.getShippingAddress(), cart.calculateTotal());
    }
}
