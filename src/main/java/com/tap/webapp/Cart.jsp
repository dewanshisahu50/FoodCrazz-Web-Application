<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.model.Restaurant, com.tap.model.Cart, com.tap.model.CartItem" %>
<%
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null) {
        cart = new Cart();
        session.setAttribute("cart", cart);
    }

    String restaurantIdStr = (String) session.getAttribute("restaurantId");
    Integer restaurantId = null;
    try {
        restaurantId = Integer.parseInt(restaurantIdStr);
    } catch (NumberFormatException e) {
        out.println("Invalid restaurant ID.");
    }

    float tax = (cart.getTotalPrice() * 18.0f) / 100.0f;
    float deliveryFee = 50.0f;
    float total = cart.getTotalPrice() + tax + deliveryFee;
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FoodCrazz Cart</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- External Libraries -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">

    <!-- Custom Style -->
    <link rel="stylesheet" href="Cart.css">
</head>
<body style="font-family: 'Poppins', sans-serif; background-color: #fdf6f0;">

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg" style="background-color: #4e342e;">
        <div class="container-fluid">
            <a class="navbar-brand" href="/Tap_foods/Resturant">
                <img src="Image_R/FoodCrazz_logo.png" alt="Logo" width="60" height="50">
            </a>
            <a class="navbar-brand text-white" href="Restaurant.jsp">FoodCrazz</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link text-white" href="Restaurant">Home</a></li>
                    <li class="nav-item"><a class="nav-link text-white" href="Restaurant">Restaurants</a></li>             
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-white" href="Restaurant.jsp" role="button" data-bs-toggle="dropdown">Cuisine</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="Restaurant.jsp">Italian</a></li>
                            <li><a class="dropdown-item" href="Restaurant.jsp">Chinese</a></li>
                            <li><a class="dropdown-item" href="Restaurant.jsp">Indian</a></li>
                            <li><a class="dropdown-item" href="Restaurant.jsp">Mexican</a></li>
                            <li><a class="dropdown-item" href="Restaurant.jsp">Japanese</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="d-flex ms-3">
                    <a href="Login.jsp" class="text-white me-3"><i class="fa-solid fa-user fa-lg"></i></a>
                    <a href="Cart.jsp" class="text-white position-relative">
                        <i class="fa-solid fa-cart-shopping fa-lg"></i>
                        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                            <%= cart.getTotalItems() %>
                        </span>
                    </a>
                </div>
            </div>
        </div>
    </nav>
    
    

    <!-- Main Content -->
    <div class="container py-5">
        <h2 class="text-center mb-4">FoodCrazz Cart</h2>
        <div class="row">
            <!-- Cart Items -->
            <div class="col-lg-8">
                <div class="card">
                    <div class="card-header bg-dark text-white">Items (<%= cart.getTotalItems() %>)</div>
                    <div class="card-body">
                        <% if (cart.getItems() != null && !cart.getItems().isEmpty()) {
                            for (CartItem item : cart.getItems().values()) { %>
                                <div class="row mb-3 align-items-center border-bottom pb-2">
                                    <div class="col-md-5">
                                        <h5><%= item.getName() %></h5>
                                        <p>Price: ₹<%= item.getPrice() %></p>
                                    </div>
                                    <div class="col-md-4 d-flex align-items-center">
                                        <!-- Decrease -->
                                        <form action="Cart" method="post" class="me-2">
                                            <input type="hidden" name="action" value="update">
                                            <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                                            <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                                            <button class="btn btn-sm btn-outline-secondary"><i class="bi bi-dash"></i></button>
                                        </form>

                                        <span><%= item.getQuantity() %></span>

                                        <!-- Increase -->
                                        <form action="Cart" method="post" class="ms-2">
                                            <input type="hidden" name="action" value="update">
                                            <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                                            <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                                            <button class="btn btn-sm btn-outline-secondary"><i class="bi bi-plus"></i></button>
                                        </form>
                                    </div>
                                    <div class="col-md-2 text-end">
                                        ₹<%= item.getPrice() * item.getQuantity() %>
                                    </div>
                                    <div class="col-md-1 text-end">
                                        <form action="Cart" method="post">
                                            <input type="hidden" name="action" value="remove">
                                           <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                                            <button class="btn btn-sm btn-outline-danger"><i class="bi bi-trash"></i></button>
                                        </form>
                                    </div>
                                </div>
                        <% } } else { %>
                            <p class="text-center">Your cart is empty.</p>
                        <% } %>
                    </div>
                    <div class="card-footer d-flex justify-content-between">
                        <a href="Menu.jsp?restaurantId=<%= restaurantId %>" class="btn btn-primary">Continue Ordering</a>
                        <form action="Cart" method="post">
                            <input type="hidden" name="action" value="clear">
                            <button type="submit" class="btn btn-danger">Clear Cart</button>
                        </form>
                    </div>
                </div>
            </div>



            <!-- Summary -->
            <div class="col-lg-4">
                <div class="card bg-light">
                    <div class="card-header bg-dark text-white">Order Summary</div>
                    <div class="card-body">
                        <p class="d-flex justify-content-between">Subtotal: <span>₹<%= cart.getTotalPrice() %></span></p>
                        <p class="d-flex justify-content-between">Delivery: <span>₹<%= deliveryFee %></span></p>
                        <p class="d-flex justify-content-between">Tax (18%): <span>₹<%= tax %></span></p>
                        <hr>
                        <h5 class="d-flex justify-content-between">Total: <span>₹<%= total %></span></h5>


                        <!-- Delivery Option -->
                        <div class="mt-4">
                            <label class="form-label fw-bold">Delivery Method</label>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="deliveryOption" id="homeDelivery" checked>
                                <label class="form-check-label" for="homeDelivery">Home Delivery</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="deliveryOption" id="pickup">
                                <label class="form-check-label" for="pickup">Pickup</label>
                            </div>
                        </div>


                        <!-- Checkout -->
                        <a href="Checkout.jsp" class="btn btn-success w-100 mt-4">Proceed to Checkout</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
