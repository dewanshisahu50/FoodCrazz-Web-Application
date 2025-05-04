package com.tap.daoimpl;
import com.tap.dao.RestaurantDao;
import com.tap.model.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDaoImpl implements RestaurantDao {

    String url = "jdbc:mysql://localhost:3306/foodcrazz";
    String username = "root";
    String password = "seedit";

    private static final String INSERT_QUERY = "INSERT INTO restaurant (restaurantId, name, cuisineType, deliveryTime, address, adminUserId, rating, isActive, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE restaurant SET name = ?, cuisineType = ?, deliveryTime = ?, address = ?, adminUserId = ?, rating = ?, isActive = ?, imagePath = ? WHERE restaurantId = ?";
    private static final String DELETE_QUERY = "DELETE FROM restaurant WHERE restaurantId = ?";
    

    
    
    
    @Override
    public void addRestaurant(Restaurant r) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(INSERT_QUERY)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            stmt.setInt(1, r.getRestaurantId());
            stmt.setString(2, r.getName());
            stmt.setString(3, r.getCuisineType());
            stmt.setString(4, r.getDeliveryTime());
            stmt.setString(5, r.getAddress());
            stmt.setInt(6, r.getAdminUserId());
            stmt.setString(7, r.getRating());
            stmt.setString(8, r.getIsActive());
            stmt.setString(9, r.getImagePath());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    

    @Override
    public void updateRestaurant(Restaurant r) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(UPDATE_QUERY)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            stmt.setString(1, r.getName());
            stmt.setString(2, r.getCuisineType());
            stmt.setString(3, r.getDeliveryTime());
            stmt.setString(4, r.getAddress());
            stmt.setInt(5, r.getAdminUserId());
            stmt.setString(6, r.getRating());
            stmt.setString(7, r.getIsActive());
            stmt.setString(8, r.getImagePath());
            stmt.setInt(9, r.getRestaurantId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    

    @Override
    public void deleteRestaurant(int id) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(DELETE_QUERY)) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    @Override
    public Restaurant getRestaurantById(int id) {
        Restaurant r = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM restaurant WHERE restaurantId = ?");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                r = new Restaurant(
                    rs.getInt("restaurantId"),
                    rs.getString("name"),
                    rs.getString("cuisineType"),
                    rs.getString("deliveryTime"),
                    rs.getString("address"),
                    rs.getInt("adminUserId"),
                    rs.getString("rating"),
                    rs.getString("isActive"),
                    rs.getString("imagePath")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return r;
    }

    
   
    
    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM restaurant");

            while (rs.next()) {
                Restaurant r = new Restaurant(
                    rs.getInt("restaurantId"),
                    rs.getString("name"),
                    rs.getString("cuisineType"),
                    rs.getString("deliveryTime"),
                    rs.getString("address"),
                    rs.getInt("adminUserId"),
                    rs.getString("rating"),
                    rs.getString("isActive"),
                    rs.getString("imagePath")
                );

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
    
    
    
    
    
}
