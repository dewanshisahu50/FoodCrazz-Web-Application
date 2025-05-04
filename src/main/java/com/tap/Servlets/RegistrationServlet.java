
package com.tap.Servlets;

import com.tap.dao.userDao;
import com.tap.daoimpl.userDaoimpl;
import com.tap.model.User;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private userDao userDao;
    
    @Override
    public void init() throws ServletException {
        userDao = new userDaoimpl();  // Initialize the DAO implementation
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the form parameters from the registration page
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        String phone = request.getParameter("phone");
        
        
        
        // Validate passwords match
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Passwords do not match.");
            request.getRequestDispatcher("Registration.jsp").forward(request, response);
            return;
        }

        // Create a new User object
        User newUser = new User();
        newUser.setUsername(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setPhone(phone);
        newUser.setRole("user"); // Default role is 'user'
        newUser.setAddress("");  // Optionally, can set an empty address for now

        try {
            // Add the user to the database using DAO
            userDao.addUser(newUser);
            // Redirect to the login page after successful registration
            response.sendRedirect("Login.jsp");
        } catch (Exception e) {
            // Handle database errors (e.g., email already exists)
            e.printStackTrace();
            request.setAttribute("error", "Error during registration. Please try again.");
            request.getRequestDispatcher("Registration.jsp").forward(request, response);
        }
    }
}
