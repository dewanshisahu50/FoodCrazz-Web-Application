package com.tap.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/foodcrazz";
    private static final String DB_USER = "root"; 
    private static final String DB_PASSWORD = "seedit"; 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // When the GET request is made, forward to Login.jsp to show the login form
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare SQL query
            String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            // Execute query
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String dbPassword = rs.getString("password");
                if (dbPassword.equals(password)) {
                    // Login successful
                    HttpSession session = request.getSession();
                    session.setAttribute("userEmail", email); // Save user info
                    session.setAttribute("user", true); // Add this to help with login checks
                    
                    String redirectTarget = (String) session.getAttribute("redirectAfterLogin");
                    if (redirectTarget != null) {
                        session.removeAttribute("redirectAfterLogin"); // Clean up
                        response.sendRedirect(redirectTarget); // Redirect to the target page
                    } else {
                        response.sendRedirect("Restaurant"); // Default landing page
                    }
                } else {
                    // Invalid password
                    request.setAttribute("errorMessage", "Invalid email or password!");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            } else {
                // Invalid email
                request.setAttribute("errorMessage", "Invalid email or password!");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Something went wrong: " + e.getMessage());
        }
    }
}
