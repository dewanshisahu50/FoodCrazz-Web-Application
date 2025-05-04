package com.tap.launch;


import com.tap.daoimpl.userDaoimpl;
import com.tap.model.User;

import java.util.List;

import com.tap.daoimpl.MenuDaoImpl;
import com.tap.daoimpl.OrderDaoImpl;
import com.tap.daoimpl.OrderItemDaoImpl;
import com.tap.daoimpl.RestaurantDaoImpl;
import com.tap.model.Menu;
import com.tap.model.Order;
import com.tap.model.OrderItem;
import com.tap.model.Restaurant;

public class Launch {
	
	public static void main(String[] args) {
		
		
		
		userDaoimpl ud = new userDaoimpl();
		
//                                                 addUser
// 		User u=new User();
	
//		u.setUserId(7);
//		u.setUsername("Kisha");
//		u.setPassword("kish");
//		u.setEmail("kisha@gmail.com");
//		u.setAddress("Paris");
//		u.setRole("user");
//		u.setPhone("8766858747");
//		userDaoimpl ud = new userDaoimpl();
//		ud.addUser();
		
		
//                                               deleteUser

//		ud.deleteUser(2);

		
//                                               getUserByID

//      User u = ud.getUserById(1);
//      System.out.println(u);
		
		
		
//                                               udateUser

//		User u = new User();
//		u.setUsername("Krish");
//		u.setPassword("krishna");
//		u.setAddress("India");
//		u.setRole("user");
//		u.setPhone("8578357537");
//		u.setUserId(4);
//        ud.updateUser(u);
        
		
// -------------------------------------------------------------------------------------------------------------------------
		
		
        
        RestaurantDaoImpl dao = new RestaurantDaoImpl();
        
//                                           addRestaurants
        
//        Restaurant r = new Restaurant();
//        r.setRestaurantId(101);
//        r.setName("Spicy Bites");
//        r.setCuisineType("Indian");
//        r.setDeliveryTime("30 minutes");
//        r.setAddress("MG Road, Bangalore");
//        r.setAdminUserId(1); // assuming admin userId 1 exists
//        r.setRating("4.5");
//        r.setIsActive("Yes");
//        r.setImagePath("spicybites.jpg");
//
//        dao.addRestaurant(r);

//        Restaurant r1 = new Restaurant(102, "Pasta Palace", "Italian", "25 minutes", "Koramangala, Bangalore", 2, "4.2", "Yes", "pastapalace.jpg");
//        Restaurant r2 = new Restaurant(103, "Sushi Spot", "Japanese", "35 minutes", "HSR Layout, Bangalore", 3, "4.7", "Yes", "sushispot.jpg");
//        Restaurant r3 = new Restaurant(104, "Burger Barn", "American", "20 minutes", "Indiranagar, Bangalore", 4, "4.1", "Yes", "burgerbarn.jpg");
//        Restaurant r4 = new Restaurant(105, "Tandoori Treats", "North Indian", "30 minutes", "Whitefield, Bangalore", 5, "4.4", "Yes", "tandooritreats.jpg");
//        Restaurant r5 = new Restaurant(106, "Green Vegan", "Vegan", "28 minutes", "Jayanagar, Bangalore", 6, "4.6", "Yes", "greenvegan.jpg");
//
//        dao.addRestaurant(r1);
//        dao.addRestaurant(r2);
//        dao.addRestaurant(r3);
//        dao.addRestaurant(r4);
//        dao.addRestaurant(r5);
                  
//                                          getRestaurantById
        
//        Restaurant r = dao.getRestaurantById(101);
//
//        if (r != null) {
//            System.out.println(r);
//        } else {
//            System.out.println("Restaurant not found.");
//        }
        
        
//                                           updateRestaurant
        
//        Restaurant r = new Restaurant();
//        r.setRestaurantId(103); // ID of restaurant you want to update
//        
//        r.setName("Sushi Spot Deluxe");
//        r.setCuisineType("Japanese Fusion");
//        r.setDeliveryTime("40 minutes");
//        r.setAddress("HSR Layout, Bangalore");
//        r.setAdminUserId(3);
//        r.setRating("4.9");
//        r.setIsActive("Yes");
//        r.setImagePath("sushispot_deluxe.jpg");
//
//        dao.updateRestaurant(r);
//        System.out.println("Restaurant updated successfully.");
        
        
        
//                                            deleteRestaurant
        
        
//        dao.deleteRestaurant(106); // ID of restaurant you want to delete
//        System.out.println("Restaurant deleted successfully.");
        
        
        
//                                            getAllRestaurants
//        List<Restaurant> restaurants = dao.getAllRestaurants();
//        for (Restaurant r : restaurants) {
//            System.out.println(r);
//        }
	
// ------------------------------------------------------------------------------------------------------------------------
        
        
        
        MenuDaoImpl  menuDao = new MenuDaoImpl();
        
        
//        Menu m1 = new Menu();
//        m1.setMenuId(6);
//        m1.setRestaurantId(101);  // Make sure this restaurantId exists in the `restaurant` table
//        m1.setItemName("Margherita Pizza");
//        m1.setDescription("Classic cheese pizza with tomato sauce");
//        m1.setPrice(350);
//        m1.setIsAvailable("yes");
//        m1.setImagePath("images/margherita_pizza.jpg");

//        Menu m2 = new Menu();
//        m2.setMenuId(2);
//        m2.setRestaurantId(101);
//        m2.setItemName("Paneer Butter Masala");
//        m2.setDescription("Paneer in creamy tomato gravy");
//        m2.setPrice(280);
//        m2.setIsAvailable("yes");
//        m2.setImagePath("images/paneer_butter.jpg");
//
//        Menu m3 = new Menu();
//        m3.setMenuId(3);
//        m3.setRestaurantId(102);
//        m3.setItemName("Veg Biryani");
//        m3.setDescription("Spicy and aromatic rice with vegetables");
//        m3.setPrice(220);
//        m3.setIsAvailable("yes");
//        m3.setImagePath("images/veg_biryani.jpg");
//
//        Menu m4 = new Menu();
//        m4.setMenuId(4);
//        m4.setRestaurantId(102);
//        m4.setItemName("Chicken Shawarma");
//        m4.setDescription("Juicy grilled chicken in pita bread");
//        m4.setPrice(180);
//        m4.setIsAvailable("yes");
//        m4.setImagePath("images/shawarma.jpg");
//
//        Menu m5 = new Menu();
//        m5.setMenuId(5);
//        m5.setRestaurantId(103);
//        m5.setItemName("Cold Coffee");
//        m5.setDescription("Chilled coffee with milk and ice cream");
//        m5.setPrice(120);
//        m5.setIsAvailable("yes");
//        m5.setImagePath("images/cold_coffee.jpg");

       
//        menuDao.addMenu(m1);
//        menuDao.addMenu(m2);
//        menuDao.addMenu(m3);
//        menuDao.addMenu(m4);
//        menuDao.addMenu(m5);
//        System.out.println("Menu item added successfully!");
        
        
        
//                                        updateMenu         
//        Menu updatedMenu = new Menu();
//        updatedMenu.setMenuId(1); // existing menu ID
//        updatedMenu.setRestaurantId(101);
//        updatedMenu.setItemName("Updated Pizza");
//        updatedMenu.setDescription("Cheesy veggie pizza");
//        updatedMenu.setPrice(300);
//        updatedMenu.setIsAvailable("yes");
//        updatedMenu.setImagePath("images/pizza_updated.png");
//
//        menuDao.updateMenu(updatedMenu);
        
        
        
        
//                                        deleteMenu       
//       menuDao.deleteMenu(2); 
        
        
        
//                                       getMenuById    
//        Menu menu = menuDao.getMenuById(1);
//        System.out.println(menu);
        
        
//                                       getAllMenu
//        List<Menu> allMenus = menuDao.getAllMenus();
//        for (Menu menu : allMenus) {
//            System.out.println(menu);
//        }
        
//------------------------------------------------------------------------------------------------------------------------------------        
        
        
        OrderDaoImpl orderDao = new OrderDaoImpl();

//                                          addOrders
//        Order o1 = new Order(1, 1, 101, "2025-04-18", 350.50, "Pending", "Cash");
//        Order o2 = new Order(2, 2, 102, "2025-04-17", 500.00, "Delivered", "Card");
//        Order o3 = new Order(3, 3, 103, "2025-04-17", 320.00, "Shipped", "UPI");
//        Order o4 = new Order(4, 4, 104, "2025-04-16", 150.25, "Cancelled", "Card");
//        Order o5 = new Order(5, 5, 105, "2025-04-15", 275.80, "Placed", "Cash");
//        Order o6 = new Order(6, 5, 102, "2025-04-14", 400.50, "Delivered", "NetBanking");
//        Order o7 = new Order(7, 2, 104, "2025-04-13", 90.00, "Processing", "Card");
        
//        orderDao.addOrder(o1);
//        orderDao.addOrder(o2);
//        orderDao.addOrder(o3);
//        orderDao.addOrder(o4);
//        orderDao.addOrder(o5);
//        orderDao.addOrder(o6);
//        orderDao.addOrder(o7);       
//        System.out.println("Order item added successfully!");
        
        

//                                          updateOrder
//        Order o2 = new Order();
//        o2.setOrderId(1);
//        o2.setUserId(1);
//        o2.setRestaurantId(102);
//        o2.setStatus("Delivered");
//        o2.setPaymentMode("UPI");
//        orderDao.updateOrder(o2);
//        System.out.println("Order item updated successfully!");
                
        
   // Retrieve the existing order from the database first without changing putting restaurantId and userId
//        Order existingOrder = orderDao.getOrderById(5); // Fetch the order with orderId = 1
//
//        if (existingOrder != null) {
//            // Set new values for the fields you want to update
//            existingOrder.setStatus("Delivered");
//            existingOrder.setPaymentMode("UPI");
//
//            // Update the order without modifying userId and restaurantId
//            orderDao.updateOrder(existingOrder);
//
//            System.out.println("Order item updated successfully!");
//        } else {
//            System.out.println("Order with the given ID not found.");
//        }

        

//                                         getOrderById
//        Order fetchedOrder = orderDao.getOrderById(1);
//        System.out.println("Fetched Order: " + fetchedOrder);

        
//                                 AllOrders
//        List<Order> allOrders = orderDao.getAllOrders();
//        for (Order o : allOrders) {
//            System.out.println(o);
//        }

//                                          deleteOrder
//        orderDao.deleteOrder(2); 
        
//-------------------------------------------------------------------------------------------------------------------------------------       
        
        
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
        
//                                         addOrderItem
    
//        OrderItem orderItem = new OrderItem();
//        orderItem.setOrderId(1);
//        orderItem.setMenuId(1);
//        orderItem.setQuantity(2);
//        orderItem.setTotalPrice(500.00);
//
//        orderItemDao.addOrderItem(orderItem);
//        System.out.println("Adding OrderItem...");
        
        
//        OrderItem orderItem1 = new OrderItem();
//        orderItem1.setOrderId(1);       
//        orderItem1.setMenuId(1);      
//        orderItem1.setQuantity(5);      
//        orderItem1.setTotalPrice(500.00); 
//
//        OrderItem orderItem2 = new OrderItem();
//        orderItem2.setOrderId(1);      
//        orderItem2.setMenuId(2);      
//        orderItem2.setQuantity(1);      
//        orderItem2.setTotalPrice(200.00);
//
//        OrderItem orderItem3 = new OrderItem();
//        orderItem3.setOrderId(3);       
//        orderItem3.setMenuId(3);      
//        orderItem3.setQuantity(3);      
//        orderItem3.setTotalPrice(750.00); 
//
//        orderItemDao.addOrderItem(orderItem1); 
//        orderItemDao.addOrderItem(orderItem2); 
//        orderItemDao.addOrderItem(orderItem3); 

        
//                                         updateOrderItem
//        OrderItem o = new OrderItem();
//        o.setQuantity(3); // Update quantity
//        o.setTotalPrice(750.00); // Update total price
//        o.setOrderItemId(1);
//        System.out.println("Updating OrderItem...");
//        orderItemDao.updateOrderItem(o);
        
        
        
//                                          getOrderById
//        int orderItemId = 1;  
//        OrderItem orderItem = orderItemDao.getOrderItemById(orderItemId);
//        if (orderItem != null) {
//            System.out.println("OrderItem details: " + orderItem);
//        } else {
//            System.out.println("No OrderItem found with ID " + orderItemId);
//        }
    
        

//                                         allOrderItems
//        List<OrderItem> orderItems = orderItemDao.getAllOrderItems();
//        for (OrderItem item : orderItems) {
//            System.out.println(item);
//        }
//
        
        
//                                        deleteOrderItem
       
        orderItemDao.deleteOrderItem(9);
        System.out.println("OrderItem deleted successfully.");
    
               
        
	}

}

