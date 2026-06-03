package com.ashishprataplldproblems.hard.fooddeliveryservice.search;

import com.ashishprataplldproblems.hard.fooddeliveryservice.entity.Restaurant;

import java.util.List;

public interface RestaurantSearchStrategy {
    List<Restaurant> filter(List<Restaurant> allRestaurants);
}
