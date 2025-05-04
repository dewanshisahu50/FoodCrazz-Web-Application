
package com.tap.Servlets;

import com.tap.model.CartItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Checkout")
public class CheckoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the session and cart from the session
        HttpSession session = request.getSession(false);  // Use an existing session if possible
        if (session == null || session.getAttribute("cart") == null) {
            response.sendRedirect("Menu.jsp");  // Redirect to the menu if no cart exists
            return;
        }

        // Retrieve the cart items from the session
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cart");

        // Calculate subtotal, delivery fee, tax, and total
        double subtotal = 0.0;
        for (CartItem item : cartItems) {
            subtotal += item.getPrice() * item.getQuantity();
        }

        double deliveryFee = 40.0;  // Example delivery fee
        double tax = subtotal * 0.05;  // 5% tax rate
        double total = subtotal + deliveryFee + tax;

        // Set the calculated values as request attributes for the JSP
        request.setAttribute("cartItems", cartItems);
        request.setAttribute("subtotal", subtotal);
        request.setAttribute("deliveryFee", deliveryFee);
        request.setAttribute("tax", tax);
        request.setAttribute("total", total);

        // Forward the request to Checkout.jsp to display the cart
        request.getRequestDispatcher("Checkout.jsp").forward(request, response);
    }
}
