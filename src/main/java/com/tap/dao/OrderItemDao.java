
package com.tap.dao;

import com.tap.model.OrderItem;
import java.util.List;

public interface OrderItemDao {
    void addOrderItem(OrderItem orderItem);
    void updateOrderItem(OrderItem orderItem);
    void deleteOrderItem(int orderItemId);
    OrderItem getOrderItemById(int orderItemId);
    List<OrderItem> getAllOrderItems();
}
