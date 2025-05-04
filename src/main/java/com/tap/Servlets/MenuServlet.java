
package com.tap.Servlets;

import java.io.IOException;
import java.util.List;

import com.tap.daoimpl.MenuDaoImpl;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Menu")
public class MenuServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the restaurantId parameter from the request
        String resIdParam = req.getParameter("restaurantId");

        // Validate parameter presence
        if (resIdParam == null || resIdParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing 'restaurantId' parameter.");
            return;
        }

        int resId;
        try {
            resId = Integer.parseInt(resIdParam);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid 'restaurantId' format. It must be an integer.");
            return;
        }

        // Retrieve menu items for the given restaurant
        MenuDaoImpl menuDao = new MenuDaoImpl();
        List<Menu> menus = menuDao.getAllMenus(resId);

        // Set the menu list as a request attribute
        req.setAttribute("menus", menus);

        // Forward to Menu.jsp
        RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
        rd.forward(req, resp);
    }
}



