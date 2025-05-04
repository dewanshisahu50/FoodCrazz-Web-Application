package com.tap.dao;

import com.tap.model.Order;
import java.util.List;

public interface OrderDao {
    void addOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(int orderId);
    Order getOrderById(int orderId);
    List<Order> getAllOrders();
}
