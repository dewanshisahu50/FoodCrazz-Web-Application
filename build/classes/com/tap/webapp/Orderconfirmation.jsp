<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.tap.model.CartItem" %>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation - FoodCrazz</title>
    <link rel="stylesheet" href="Orderconfirmation.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-lg custom-navbar">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="Image_R/FoodCrazz_logo.png" alt="Logo" width="70" height="60">
        </a>
        <span class="navbar-text ms-auto text-white">Order Confirmation</span>
    </div>
</nav>

<div class="container mt-5 mb-5">
    <div class="confirmation-box p-4">
        <h2 class="text-center mb-4">Order Confirmed!</h2>

        <p class="text-center">Thank you for your order! Your order has been successfully placed and is being processed.</p>
        
        <h4 class="mt-5">Order Details:</h4>
        
        <%
            com.tap.model.Cart cart = (com.tap.model.Cart) session.getAttribute("cart");
            List<CartItem> cartItems = (cart != null) ? new ArrayList<>(cart.getItems().values()) : null;
            double subtotal = 0;
            if (cartItems != null && !cartItems.isEmpty()) {
                for (CartItem item : cartItems) {
                    subtotal += item.getQuantity() * item.getPrice();
                }
                double deliveryFee = 40.0;
                double tax = subtotal * 0.05;
                double total = subtotal + deliveryFee + tax;
        %>

        <table class="table table-bordered">
            <thead class="table-light">
                <tr>
                    <th>Item</th>
                    <th>Qty</th>
                    <th>Price</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (CartItem item : cartItems) {
                        double itemTotal = item.getQuantity() * item.getPrice();
                %>
                <tr>
                    <td><%= item.getName() %></td>
                    <td><%= item.getQuantity() %></td>
                    <td>₹<%= item.getPrice() %></td>
                    <td>₹<%= itemTotal %></td>
                </tr>
                <% } %>
            </tbody>
        </table>

        <div class="summary mt-4">
            <p>Subtotal: ₹<%= (int) subtotal %></p>
            <p>Delivery Fee: ₹<%= (int) deliveryFee %></p>
            <p>Tax (5%): ₹<%= (int) tax %></p>
            <hr>
            <h4>Total: ₹<%= (int) total %></h4>
        </div>

        <% } else { %>
        <div class="text-center text-danger">
            <p>Your cart is empty.</p>
        </div>
        <% } %>

			<div class="text-center mt-4">
				<a href="Restaurant" class="btn btn-dark px-4 py-2"
					style="background-color: #4e342e; border-color: #4e342e;">
					Return to Restaurant </a>
			</div>

		</div>
    
</div>

</body>
</html>
