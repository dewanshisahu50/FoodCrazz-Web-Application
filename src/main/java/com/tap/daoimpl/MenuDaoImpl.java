package com.tap.daoimpl;

import java.sql.*;
import java.util.*;
import com.tap.dao.MenuDao;
import com.tap.model.Menu;

public class MenuDaoImpl implements MenuDao {

    String url = "jdbc:mysql://localhost:3306/foodcrazz";
    String username = "root";
    String password = "seedit";

    private static final String INSERT = "INSERT INTO menu (menuId, restaurantId, itemName, description, price, isAvailable, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?)";
    //private static final String SELECT_ALL = "SELECT * FROM menu";
    private static final String SELECT_BY_ID = "SELECT * FROM menu WHERE menuId = ?";
    private static final String SELECT_ALL_BY_RESTAURANT = "SELECT * FROM menu WHERE restaurantId = ?";
    private static final String UPDATE = "UPDATE menu SET restaurantId=?, itemName=?, description=?, price=?, isAvailable=?, imagePath=? WHERE menuId=?";
    private static final String DELETE = "DELETE FROM menu WHERE menuId=?";

    
    
    @Override
    public void addMenu(Menu menu) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(INSERT)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            stmt.setInt(1, menu.getMenuId());
            stmt.setInt(2, menu.getRestaurantId());
            stmt.setString(3, menu.getItemName());
            stmt.setString(4, menu.getDescription());
            stmt.setInt(5, menu.getPrice());
            stmt.setString(6, menu.getIsAvailable());
            stmt.setString(7, menu.getImagePath());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    
    @Override
    public void updateMenu(Menu menu) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(UPDATE)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            stmt.setInt(1, menu.getRestaurantId());
            stmt.setString(2, menu.getItemName());
            stmt.setString(3, menu.getDescription());
            stmt.setInt(4, menu.getPrice());
            stmt.setString(5, menu.getIsAvailable());
            stmt.setString(6, menu.getImagePath());
            stmt.setInt(7, menu.getMenuId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    
    @Override
    public void deleteMenu(int menuId) {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(DELETE)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            stmt.setInt(1, menuId);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    
    @Override
    public Menu getMenuById(int menuId) {
        Menu menu = null;
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            stmt.setInt(1, menuId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                menu = new Menu(
                    rs.getInt("menuId"),
                    rs.getInt("restaurantId"),
                    rs.getString("itemName"),
                    rs.getString("description"),
                    rs.getInt("price"),
                    rs.getString("isAvailable"),
                    rs.getString("imagePath")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return menu;
    }

    
    
    
    
    
    

    @Override
    public List<Menu> getAllMenus(int resId) {
        List<Menu> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = con.prepareStatement(SELECT_ALL_BY_RESTAURANT)) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            stmt.setInt(1, resId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Menu m = new Menu(
                    rs.getInt("menuId"),
                    rs.getInt("restaurantId"),
                    rs.getString("itemName"),
                    rs.getString("description"),
                    rs.getInt("price"),
                    rs.getString("isAvailable"),
                    rs.getString("imagePath")
                );
                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    

}
