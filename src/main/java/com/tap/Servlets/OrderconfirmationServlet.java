package com.tap.Servlets;

import com.tap.model.Cart;
import com.tap.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@WebServlet("/Orderconfirmation")
public class OrderconfirmationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Retrieve cart from session
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {
            List<CartItem> cartItems = new ArrayList<>(cart.getItems().values());
            
            // Calculate total, subtotal, delivery fee, tax, etc.
            double subtotal = 0;
            for (CartItem item : cartItems) {
                subtotal += item.getQuantity() * item.getPrice();
            }
            double deliveryFee = 40.0;
            double tax = subtotal * 0.05;
            double total = subtotal + deliveryFee + tax;

            // Set the attributes to be used in JSP
            request.setAttribute("cartItems", cartItems);
            request.setAttribute("subtotal", subtotal);
            request.setAttribute("deliveryFee", deliveryFee);
            request.setAttribute("tax", tax);
            request.setAttribute("total", total);
        }

        // Forward to the OrderConfirmation.jsp page
        request.getRequestDispatcher("OrderConfirmation.jsp").forward(request, response);
    }
}
