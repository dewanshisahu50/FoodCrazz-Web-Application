<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.tap.model.CartItem" %>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Checkout - FoodCrazz</title>
    <link rel="stylesheet" href="Checkout.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-lg custom-navbar">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="Image_R/FoodCrazz_logo.png" alt="Logo" width="70" height="60">
        </a>
        <span class="navbar-text ms-auto text-white">Checkout</span>
    </div>
</nav>

<div class="container mt-5 mb-5">
    <div class="checkout-box p-4">
        <h2 class="text-center mb-4">Order Summary</h2>

        <%
        com.tap.model.Cart cart = (com.tap.model.Cart) session.getAttribute("cart");
        List<CartItem> cartItems = (cart != null) ? new ArrayList<>(cart.getItems().values()) : null;
        if (cartItems != null && !cartItems.isEmpty()) {
            double subtotal = 0;
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

        <!-- Personal Details Form -->
        <div class="card mb-4">
            <div class="card-header">
                <h5>Personal Details</h5>
            </div>
            <div class="card-body">
                <form action="Orderconfirmation.jsp" method="post">
                    <div class="mb-3">
                        <label for="name" class="form-label">Full Name</label>
                        <input type="text" class="form-control" id="name" name="name" required>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">Phone Number</label>
                        <input type="text" class="form-control" id="phone" name="phone" required>
                    </div>
                </form>
            </div>
        </div>

        <!-- Delivery Address Form -->
        <div class="card mb-4">
            <div class="card-header">
                <h5>Delivery Address</h5>
            </div>
            <div class="card-body">
                <form action="Orderconfirmation.jsp" method="post">
                    <div class="mb-3">
                        <label for="address" class="form-label">Address</label>
                        <input type="text" class="form-control" id="address" name="address" required>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="city" class="form-label">City</label>
                            <input type="text" class="form-control" id="city" name="city" required>
                        </div>
                        <div class="col-md-3">
                            <label for="state" class="form-label">State</label>
                            <select class="form-select" id="state" name="state" required>
                                <option value="">Choose...</option>
                                <option>Chhattisgarh</option>
                                <option>Karnataka</option>
                                <option>Haryana</option>
                                <option>Punjab</option>
                                <option>Assam</option>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <label for="zip" class="form-label">Zip Code</label>
                            <input type="text" class="form-control" id="zip" name="zip" required>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <!-- Payment Method Form -->
        <div class="card mb-4">
            <div class="card-header">
                <h5>Payment Method</h5>
            </div>
            <div class="card-body">
                <form action="Orderconfirmation.jsp" method="post">
                    <div class="mb-3">
                        <label class="form-label">Select Payment Method</label>
                        <select class="form-select" name="paymentMethod" required>
                            <option value="">Choose payment method...</option>
                            <option value="cod">Cash on Delivery (COD)</option>
                            <option value="credit">Credit Card</option>
                            <option value="debit">Debit Card</option>
                            <option value="paypal">PayPal</option>
                            <option value="upi">UPI</option>
                        </select>
                    </div>
                    <!-- Hidden input for email if needed for payment methods -->
                    <input type="text" name="email" id="email" class="dummyInputBox" style="display: none;">
                </form>
            </div>
        </div>

        <!-- Confirm Order Button -->
        <form action="Orderconfirmation.jsp" method="post">
        <div class="text-center mt-4">
				<a href="Orderconfirmation.jsp" class="btn btn-dark px-4 py-2"
					style="background-color: #4e342e; border-color: white;">
					Order Confirm </a>
			</div>
        </form>
        
        
        <% } else { %>
        <div class="text-center text-danger">
            <p>Your cart is empty.</p>
        </div>
        <% } %>

    </div>
</div>

</body>
</html>
