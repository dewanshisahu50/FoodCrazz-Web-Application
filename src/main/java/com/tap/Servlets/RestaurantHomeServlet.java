package com.tap.Servlets;

import java.io.IOException;
import java.util.List;

import com.tap.daoimpl.RestaurantDaoImpl;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Restaurant")
public class RestaurantHomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false); // Get session if it exists, but don't create a new one
        if (session == null || session.getAttribute("user") == null) {
            // Redirect to login page if the user is not logged in
            resp.sendRedirect("Login.jsp");
            return;  // Ensure that the rest of the method does not execute after redirect
        }

        String redirectTarget = (String) session.getAttribute("redirectAfterLogin");
        if (redirectTarget != null) {
            session.removeAttribute("redirectAfterLogin");
            resp.sendRedirect(redirectTarget); // Redirect if there is a target
            return;  // Ensure no forwarding happens after the redirect
        }

        // Now load restaurants and forward to the Restaurant.jsp
        RestaurantDaoImpl resImpl = new RestaurantDaoImpl();
        List<Restaurant> allRestaurants = resImpl.getAllRestaurants();

        // Debugging: print all restaurants to check if they are loaded
        for (Restaurant restaurant : allRestaurants) {
            System.out.println(restaurant);
        }

        req.setAttribute("restaurants", allRestaurants);
        RequestDispatcher rd = req.getRequestDispatcher("Restaurant.jsp");
        rd.forward(req, resp);  // Forward to the Restaurant.jsp after processing
    }
}

