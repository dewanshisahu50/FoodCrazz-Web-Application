package com.tap.daoimpl;
import com.tap.dao.userDao;
import com.tap.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class userDaoimpl implements userDao {	  
		
	String url = "jdbc:mysql://localhost:3306/foodcrazz";
	String username = "root";
	String password = "seedit";
	
	
	private static final String INSERT_QUERY= "INSERT into `user`(`userId`, `name`, `password`, `email`, `address`, `role`, `phone`)"
			+ " values (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_USER_BY_ID = "SELECT * from `user` WHERE `userId` = ?";
	private static final String UPDATE_USER_QUERY ="UPDATE  `user` SET `name` =? , `password` =?, `address` =?, `role` = ? ,`phone`=? WHERE `userId` = ?";
	private static final String DELETE_USER_QUERY = "DELETE from `user` WHERE `userID` = ?";
	private static final String GET_ALL_USER = "SELECT * from `user`";
	

	@Override
	public void addUser(User user) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con= DriverManager.getConnection(url,username,password);
		    
		    PreparedStatement stmt = con.prepareStatement(INSERT_QUERY);
		
		    stmt.setInt(1, user.getUserId());
		    stmt.setString(2, user.getUsername());
		    stmt.setString(3, user.getPassword());
		    stmt.setString(4, user.getEmail());
		    stmt.setString(5, user.getAddress());
		    stmt.setString(6, user.getRole());
		    stmt.setString(7, user.getPhone());
		    
			
			int i= stmt.executeUpdate();
			System.out.println(i);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public User getUserById(int userId) {
		
		User u = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con= DriverManager.getConnection(url,username,password);
		    
		    PreparedStatement stmt = con.prepareStatement(GET_USER_BY_ID);
		
		    stmt.setInt(1, userId);
		    
		    ResultSet res = stmt.executeQuery();
				
		    if (res.next()) {
		    
		        u = extractUser(res);
		        
		    } else {
		        System.out.println("No user found with ID: " + userId);
		    }
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
		
	}

	
	
	
	@Override
	public void updateUser(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con= DriverManager.getConnection(url,username,password);
		    
		    PreparedStatement stmt = con.prepareStatement(UPDATE_USER_QUERY);
		    
		    
		    stmt.setString(1, user.getUsername());
		    stmt.setString(2, user.getPassword());
		    stmt.setString(3, user.getAddress());
		    stmt.setString(4, user.getRole());
		    stmt.setString(5, user.getPhone());
		    
		    stmt.setInt(6, user.getUserId());

		    int i= stmt.executeUpdate();
		    System.out.print(i);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	@Override
	public void deleteUser(int userId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con= DriverManager.getConnection(url,username,password);
		    
		    PreparedStatement stmt = con.prepareStatement(DELETE_USER_QUERY);
		
		    stmt.setInt(1, userId);
		    		    
		    int i= stmt.executeUpdate();
		    System.out.print(i);		    

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public List<User> getAllUsers() {

		ArrayList<User>usersList = new ArrayList<User>();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con= DriverManager.getConnection(url,username,password);
		    
		    Statement stmt1 = con.createStatement();

			ResultSet res = stmt1.executeQuery(GET_ALL_USER);
		    
			while(res.next()) {
				
				User u = extractUser(res);
		        usersList.add(u);
		        
			}		    

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	
	User extractUser(ResultSet res) throws SQLException{
		int id = res.getInt(1);
        String name = res.getString(2);
        String password = res.getString(3);
        String email = res.getString(4);
        String address = res.getString(5);
        String role = res.getString(6);
        String phone = res.getString(7);
           
        User u = new User(id, name, password, email, address, role, phone);
        
        return u;
	}
	
	


	
	

}
