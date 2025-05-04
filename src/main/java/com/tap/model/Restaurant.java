package com.tap.model;



public class Restaurant {
    private int restaurantId;
    private String name;
    private String cuisineType;
    private String deliveryTime;
    private String address;
    private int adminUserId;
    private String rating;
    private String isActive;
    private String imagePath;
   

    
    // Constructors
    public Restaurant() {
    	
    }


    
    public Restaurant(int restaurantId, String name, String cuisineType, String deliveryTime,
    		String address, int adminUserId, String rating, String isActive, String imagePath) {
    	this.restaurantId = restaurantId;
    	this.name = name;
    	this.cuisineType = cuisineType;
    	this.deliveryTime = deliveryTime;
    	this.address = address;
    	this.adminUserId = adminUserId;
    	this.rating = rating;
    	this.isActive = isActive;
    	this.imagePath = imagePath;
    }


    
    @Override
    public String toString() {
        return "Restaurant [restaurantId=" + restaurantId +
               ", name=" + name +
               ", cuisineType=" + cuisineType +
               ", deliveryTime=" + deliveryTime +
               ", address=" + address +
               ", adminUserId=" + adminUserId +
               ", rating=" + rating +
               ", isActive=" + isActive +
               ", imagePath=" + imagePath + "]";
    }

    
    
    
    
    // Getters and Setters
    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(int adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    
}


