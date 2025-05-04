package com.tap.model;

//import com.tap.daoimpl.userDaoimpl;
//import java.util.Date;

public class User {
     
	private int userId;
	private String username;
	private String password;
	private String email;
	private String address;
	private String role;   //user , delivery person , restaurant admin, main admin
	private String phone;
	
//	private Date createdDate;
//	private Date lastLoginDate;

	
	public User() {
		
	}
	
	@Override
	public String toString() {
	    return "User [userId=" + userId +
	           ", username=" + username +
	           ", password=" + password +
	           ", email=" + email +
	           ", address=" + address +
	           ", role=" + role +
	           ", phone=" + phone + "]";
	}



	public User(int userId, String username, String password, String email, String address, String role, String phone) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
		this.phone = phone;
	}






	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	 
	
}
