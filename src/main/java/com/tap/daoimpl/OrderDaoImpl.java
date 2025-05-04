
package com.tap.daoimpl;

import com.tap.dao.OrderDao;
import com.tap.model.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    String url = "jdbc:mysql://localhost:3306/foodcrazz";
    String username = "root";
    String password = "seedit";

    private static final String INSERT = "INSERT INTO `order` (orderId, userId, restaurantId, orderDate, totalAmount, status, paymentMode) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE `order` SET userId=?, restaurantId=?, orderDate=?, totalAmount=?, status=?, paymentMode=? WHERE orderId=?";
    private static final String DELETE = "DELETE FROM `order` WHERE orderId=?";
    private static final String SELECT_BY_ID = "SELECT * FROM `order` WHERE orderId=?";
    private static final String SELECT_ALL = "SELECT * FROM `order`";

    @Override
    public void addOrder(Order order) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(INSERT)) {
            stmt.setInt(1, order.getOrderId());
            stmt.setInt(2, order.getUserId());
            stmt.setInt(3, order.getRestaurantId());
            stmt.setString(4, order.getOrderDate());
            stmt.setDouble(5, order.getTotalAmount());
            stmt.setString(6, order.getStatus());
            stmt.setString(7, order.getPaymentMode());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    @Override
    public void updateOrder(Order order) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(UPDATE)) {
            stmt.setInt(1, order.getUserId());
            stmt.setInt(2, order.getRestaurantId());
            stmt.setString(3, order.getOrderDate());
            stmt.setDouble(4, order.getTotalAmount());
            stmt.setString(5, order.getStatus());
            stmt.setString(6, order.getPaymentMode());
            stmt.setInt(7, order.getOrderId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    @Override
    public void deleteOrder(int orderId) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(DELETE)) {
            stmt.setInt(1, orderId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    
    @Override
    public Order getOrderById(int orderId) {
        Order order = null;
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                order = new Order(
                    rs.getInt("orderId"),
                    rs.getInt("userId"),
                    rs.getInt("restaurantId"),
                    rs.getString("orderDate"),
                    rs.getDouble("totalAmount"),
                    rs.getString("status"),
                    rs.getString("paymentMode")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    
    
    
    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                orders.add(new Order(
                    rs.getInt("orderId"),
                    rs.getInt("userId"),
                    rs.getInt("restaurantId"),
                    rs.getString("orderDate"),
                    rs.getDouble("totalAmount"),
                    rs.getString("status"),
                    rs.getString("paymentMode")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
}
