<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List,com.tap.model.Menu,com.tap.dao.MenuDao" %>
<%@ page import="com.tap.daoimpl.MenuDaoImpl" %>
<%@ page import="com.tap.model.Menu" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>FoodCrazz Menu</title>
  <link rel="stylesheet" href="Menu.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
</head>


<body>
 
<%
    String restaurantIdStr = request.getParameter("restaurantId");

    if (restaurantIdStr == null || restaurantIdStr.isEmpty() || restaurantIdStr.equals("null")) {
        out.println("No restaurant selected.");
        return;
    }
    int restaurantId = Integer.parseInt(restaurantIdStr);
    
    // Instantiate the correct DAO implementation
    MenuDaoImpl menuDAO = new MenuDaoImpl();
    List<Menu> menuList = menuDAO.getAllMenus(restaurantId); // Use the method to fetch menu items by restaurantId
    request.setAttribute("menus", menuList);
%>


  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg custom-navbar py-3">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">
        <img src="Image_R/FoodCrazz_logo.png" alt="Logo" width="70" height="60" />
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0 me-4">
          <li class="nav-item"><a class="nav-link" href="Restaurant">Home</a></li>
          <li class="nav-item"><a class="nav-link" href="Restaurant">Restaurants</a></li>
          <li class="nav-item"><a class="nav-link" href="Restaurant">Specials</a></li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">Cuisine</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Italian</a></li>
              <li><a class="dropdown-item" href="#">Chinese</a></li>
              <li><a class="dropdown-item" href="#">Indian</a></li>
              <li><a class="dropdown-item" href="#">Mexican</a></li>
              <li><a class="dropdown-item" href="#">Japanese</a></li>
              <li><a class="dropdown-item" href="#">Explore by Restaurant</a></li>
            </ul>
          </li>
        </ul>
        <form class="d-flex me-3" role="search">
          <input class="form-control me-2" type="search" placeholder="Search" />
         
        </form>
        <div class="d-flex align-items-center">
          <a href="Login.jsp" class="me-3" title="Sign In / Sign Out">
            <i class="fa-solid fa-user fa-lg"></i>
          </a>
          <a href="Cart.jsp" title="View Cart">
            <i class="fa-solid fa-cart-shopping fa-lg"></i>
          </a>
        </div>
      </div>
    </div>
  </nav>


<div class="container">
		<div class="row">
			<%
    List<Menu> allMenus = (List<Menu>) request.getAttribute("menus");

    if (allMenus == null || allMenus.isEmpty()) { 
%>
			<div class="col-12 text-center mt-4">
				<h4 class="text-danger">No menus available, please come after
					some time.</h4>
			</div>
			<%
    } else {
        for (Menu r : allMenus) {
%>

			<div class="col-md-4 col-lg-3 mb-4 mt-3">
				<div class="card food-card h-100">
					<div class="position-relative">
						<img src="<%= r.getImagePath() %>" class="card-img-top"
							alt="Food Image">
					</div>
					<div class="card-body">
						<h5
							class="card-title mb-0 d-flex justify-content-between align-items-center">
							<span class="text-truncate"
								style="max-width: 60%; font-size: 1.2rem;"> <%= r.getItemName() %>
							</span>
						</h5>

						<p class="card-text description mt-2"><%= r.getDescription() %></p>

						<!-- Price Section -->
						<div
							class="d-flex justify-content-between align-items-center mb-2">
							<span class="" style="font-size: 15px; font-weight: 400;">
								₹<%= r.getPrice() %> for one
							</span>
						</div>

						<!-- Add to Cart Form -->
						<form action="Cart" method="post"
							class="d-flex flex-column align-items-center">
							<input type="hidden" name="restaurantId"
								value="<%=r.getRestaurantId()%>">
							<!-- Use restaurantId from the current Menu -->
							<input type="hidden" name="itemId" value="<%=r.getMenuId()%>">
							<input type="number" name="quantity" class="form-control me-2"
								value="1" min="1" required> <input type="hidden"
								name="action" value="add">
							<button type="submit" class="btn btn-primary add-to-cart mt-3">
								<i class="bi bi-cart-plus me-2"></i> Add to Cart
							</button>
						</form>

					</div>
				</div>
			</div>

			<%
        } // End of for loop
    } // End of if-else condition
%>
		</div>
	</div>


  <!-- Footer -->
  <footer class="text-light text-center text-lg-start">
    <div class="container py-4">

      <!-- Social Media -->
      <section class="d-flex justify-content-center justify-content-lg-between mb-4">
        <div class="me-5">
          <span>Get connected with us on social networks:</span>
        </div>
        <div>
          <a href="#" class="me-4"><i class="fab fa-facebook-f"></i></a>
          <a href="#" class="me-4"><i class="fab fa-twitter"></i></a>
          <a href="#" class="me-4"><i class="fab fa-google"></i></a>
          <a href="#" class="me-4"><i class="fab fa-instagram"></i></a>
          <a href="#" class="me-4"><i class="fab fa-linkedin"></i></a>
          <a href="#" class="me-4"><i class="fab fa-github"></i></a>
        </div>
      </section>

    </div>

<!-- Footer Links -->
<section>
  <div class="container">
    <div class="row text-center text-md-start mt-3">
    
          <!-- Image Column -->
     <div class="col-md-4 col-lg-3 mb-4">
        <h6 class="text-uppercase fw-bold mb-4">Who Are You ?</h6>
        <p class="text-reset">Are You</p>
        <p class="text-reset">Crazyyyy</p>
        <p class="text-reset">For</p>
        <p class="text-reset">Foooood ???</p>
      </div>
    
      <!-- Useful Links Column -->
      <div class="col-md-4 col-lg-3 mb-4">
        <h6 class="text-uppercase fw-bold mb-4">Useful Links</h6>
        <p><a href="#" class="text-reset">Pricing</a></p>
        <p><a href="#main" class="text-reset">Orders</a></p>
        <p><a href="#pop" class="text-reset">Settings</a></p>
        <p><a href="#" class="text-reset">Help</a></p>
      </div>

      <!-- About Us Column -->
      <div class="col-md-4 col-lg-3 mb-4">
        <h6 class="text-uppercase fw-bold mb-4">About Us</h6>
        <p><a href="#" class="text-reset">Our Stories</a></p>
        <p><a href="#main" class="text-reset">Why Choose Us</a></p>
        <p><a href="#pop" class="text-reset">How It Works</a></p>
        <p><a href="#" class="text-reset">Customer Reviews</a></p>
      </div>

      <!-- Contact Column -->
      <div class="col-md-4 col-lg-3 mb-4">
        <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
        <p><i class="fas fa-home me-3"></i> Kormangla, Bangalore</p>
        <p><i class="fas fa-envelope me-3"></i> foodcrazz@gmail.com</p>
        <p><i class="fas fa-phone me-3"></i> +91 620-123-4567</p>
        <p><i class="fas fa-print me-3"></i> +91 809-593-2490</p>
      </div>

    </div>
  </div>
</section>

<!-- Copyright Section -->
<div class="text-center py-3">
  Â© 2025 Copyright:
  <a class="text-reset fw-bold" href="https://www.linkedin.com/in/shubhverma2000/">FoodCrazz.com</a>
</div>
    
    
  </footer>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
