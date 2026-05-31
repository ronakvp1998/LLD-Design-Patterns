package com.ashishprataplldproblems.fooddeliveryservice.search;

import com.ashishprataplldproblems.fooddeliveryservice.entity.Restaurant;

import java.util.List;

public interface RestaurantSearchStrategy {
    List<Restaurant> filter(List<Restaurant> allRestaurants);
}
