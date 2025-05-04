package com.tap.Servlets;

import com.tap.daoimpl.MenuDaoImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/Cart")
public class CartServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Cart servlet POST called");

        HttpSession session = request.getSession();
        
        // Check if user is logged in
        if (session.getAttribute("userEmail") == null) {
            session.setAttribute("redirectAfterLogin", "Cart.jsp");
            response.sendRedirect("LoginServlet");
            return;
        }

        Cart cart = (Cart) session.getAttribute("cart");

        try {
            int newRestaurantId = Integer.parseInt(request.getParameter("restaurantId"));   
            Integer currentRestaurantId = (Integer) session.getAttribute("restaurantId");

            if (cart == null || currentRestaurantId == null || newRestaurantId != currentRestaurantId.intValue()) {

                cart = new Cart();
                session.setAttribute("cart", cart); // Set the new cart in session
                session.setAttribute("restaurantId", newRestaurantId); // Update the restaurant ID
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String action = request.getParameter("action");
        if ("add".equals(action)) {
            addItemToCart(request, cart);
            session.setAttribute("cart", cart);
        }else if ("update".equals(action)) {
            updateCartItem(request, cart);
            session.setAttribute("cart", cart);
        }else if ("clear".equals(action)) {
            cart.clear();
            session.setAttribute("cart", cart);
        }// Save restaurantId in session (important for 'Continue Ordering')
        
        
        
        String restaurantId = request.getParameter("restaurantId");
        if (restaurantId != null) {
            session.setAttribute("restaurantId", restaurantId);
        }
        
         if ("remove".equals(action)) {
            int itemId = Integer.parseInt(request.getParameter("itemId"));
            cart = (Cart) session.getAttribute("cart");
            if (cart != null) {
                cart.removeItem(itemId); // Make sure this method exists
            }
        }

        response.sendRedirect("Cart.jsp");
    }

    
    	@Override
    	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	        throws ServletException, IOException {
    	    response.sendRedirect("Cart.jsp");
    	}


        

    private void addItemToCart(HttpServletRequest request, Cart cart) {
        try {
            int itemId = Integer.parseInt(request.getParameter("itemId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            MenuDaoImpl menuDAO = new MenuDaoImpl();
            Menu menuItem = menuDAO.getMenuById(itemId);
            System.out.println("Menu item fetched: " + menuItem);

            if (menuItem != null) {
                CartItem item = new CartItem(
                        menuItem.getMenuId(),
                        menuItem.getItemName(),
                        menuItem.getPrice(),
                        quantity
                );
                cart.addCartItem(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    private void updateCartItem(HttpServletRequest request, Cart cart) {
        try {
            int itemId = Integer.parseInt(request.getParameter("itemId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            cart.updateItem(itemId, quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}


