package com.tap.dao;

import com.tap.model.Restaurant;
import java.util.List;

public interface RestaurantDao {
    void addRestaurant(Restaurant restaurant);
    void updateRestaurant(Restaurant restaurant);
    void deleteRestaurant(int restaurantId);
    Restaurant getRestaurantById(int restaurantId);
    List<Restaurant> getAllRestaurants();
}

