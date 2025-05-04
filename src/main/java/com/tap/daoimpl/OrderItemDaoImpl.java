package com.tap.daoimpl;

import com.tap.dao.OrderItemDao;
import com.tap.model.OrderItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoImpl implements OrderItemDao {
    String url = "jdbc:mysql://localhost:3306/foodcrazz";
    String username = "root";
    String password = "seedit";

    private static final String INSERT = "INSERT INTO orderitem (orderId, menuId, quantity, totalPrice) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE orderitem SET quantity=?, totalPrice=? WHERE orderItemId=?";
    private static final String DELETE = "DELETE FROM orderitem WHERE orderItemId=?";
    private static final String SELECT_BY_ID = "SELECT * FROM orderitem WHERE orderItemId=?";
    private static final String SELECT_ALL = "SELECT * FROM orderitem";

    
    
    
    @Override
    public void addOrderItem(OrderItem orderItem) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(INSERT)) {

            stmt.setInt(1, orderItem.getOrderId());
            stmt.setInt(2, orderItem.getMenuId());
            stmt.setInt(3, orderItem.getQuantity());
            stmt.setDouble(4, orderItem.getTotalPrice());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    
    @Override
    public void updateOrderItem(OrderItem orderItem) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(UPDATE)) {

            
            stmt.setInt(1, orderItem.getQuantity());
            stmt.setDouble(2, orderItem.getTotalPrice());
            stmt.setInt(3, orderItem.getOrderItemId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    @Override
    public void deleteOrderItem(int orderItemId) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(DELETE)) {

            stmt.setInt(1, orderItemId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    
    @Override
    public OrderItem getOrderItemById(int orderItemId) {
        OrderItem orderItem = null;
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID)) {

            stmt.setInt(1, orderItemId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                orderItem = new OrderItem();
                orderItem.setOrderItemId(rs.getInt("orderItemId"));
                orderItem.setOrderId(rs.getInt("orderId"));
                orderItem.setMenuId(rs.getInt("menuId"));
                orderItem.setQuantity(rs.getInt("quantity"));
                orderItem.setTotalPrice(rs.getDouble("totalPrice"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderItem;
    }

    
    
    
    @Override
    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> orderItems = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderItemId(rs.getInt("orderItemId"));
                orderItem.setOrderId(rs.getInt("orderId"));
                orderItem.setMenuId(rs.getInt("menuId"));
                orderItem.setQuantity(rs.getInt("quantity"));
                orderItem.setTotalPrice(rs.getDouble("totalPrice"));
                orderItems.add(orderItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderItems;
    }
}
