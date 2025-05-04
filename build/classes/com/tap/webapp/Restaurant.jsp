<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List,com.tap.model.Restaurant" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>FoodCrazz</title>
  <link rel="stylesheet" href="Restaurant.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
</head>

<style>
.floating-food-section {
  height: 300px;
  background: linear-gradient(135deg, #ffecd2 0%, #fcb69f 100%);
  overflow: hidden;
  position: relative;
  border-radius: 20px;
  margin: 20px 0;
  display: flex;
  align-items: center;
  justify-content: center;
}

.floating-food-container {
  position: relative;
  width: 250%;
  height: 150%;
}

.floating-food {
  position: absolute;
  width: 150px;
  height: 100px;
  object-fit: contain;
  animation: floatRotate 6s ease-in-out infinite;
}

/* Assign different starting positions */
.food1 { top: 30%; left: 10%; animation-delay: 1s; }
.food2 { top: 45%; left: 20%; animation-delay: 1s; }
.food3 { top: 30%; left: 70%; animation-delay: 1s; }
.food4 { top: 45%; left: 80%; animation-delay: 1s; }

/* Animation for floating + rotating */
@keyframes floatRotate {
  0% {
    transform: translateY(0px) rotate(0deg);
  }
  50% {
    transform: translateY(-30px) rotate(15deg);
  }
  100% {
    transform: translateY(0px) rotate(0deg);
  }
}

.text-overlay {
  position: absolute;
  top: 43%;
  left: 49%;
  transform: translate(-50%, -50%);
  text-align: center;
  color: 481E14;
  font-weight:bold;
  text-shadow: 1px 1px 2px #fff;
}


/* --- RESPONSIVE --- */
@media (max-width: 768px) {
  .floating-food-section {
    height: 250px;
  }

  .floating-food {
    width: 80px;
    height: 60px;
  }

  .text-overlay h1 {
    font-size: 20px;
  }

  .text-overlay p {
    font-size: 15px;
  }
}

@media (max-width: 480px) {
  .floating-food-section {
    height: 220px;
  }

  .floating-food {
    width: 40px;
    height: 20px;
  }

  .text-overlay h1 {
    font-size: 15px;
  }

  .text-overlay p {
    font-size: 5px;
  }
}
</style>

<body>

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
          <li class="nav-item"><a class="nav-link" href="Restaurant.jsp">Home</a></li>
          <li class="nav-item"><a class="nav-link" href="Restaurant.jsp">Restaurants</a></li>
          <li class="nav-item"><a class="nav-link" href="Restaurant.jsp">Specials</a></li>
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

  <!-- Main Content -->
  <div class="container-fluid" id="main">
  
  <div class="floating-food-section">
  <div class="floating-food-container">
    <img src="Image_R/menu1.jpeg" class="floating-food food1" alt="Burger">
    <img src="Image_R/menu2.jpeg" class="floating-food food2" alt="Pizza">
    <img src="Image_R/menu3.jpeg" class="floating-food food3" alt="Noodles">
    <img src="Image_R/menu4.jpeg" class="floating-food food4" alt="Donut">

    <div class="text-overlay">
     <h1 class="display-5">WelcomeToFoodCrazz!</h1>
     
      <p class="lead">Let flavors float to your soul!</p>
    </div>
  </div>
</div>
  
  <!-- Restaurant Cards -->
<section class="py-5">
  <div class="container">
    <div class="row g-4">

					<%
					List<Restaurant> restaurant = (List<Restaurant>) request.getAttribute("restaurants");
					if (restaurant != null && !restaurant.isEmpty()) {
						for (Restaurant r : restaurant) {
					%>
					<div class="col-md-4">
						<a href="Menu?restaurantId=<%=r.getRestaurantId()%>"
							class="text-decoration-none">
							<div class="card food-card h-100 shadow-sm">
								<img src="<%=r.getImagePath()%>" class="card-img-top"
									alt="Restaurant Image" />
								<div class="card-body">
									<h5 class="card-title"><%=r.getName()%></h5>
									<p class="card-text">
										Cuisine:
										<%=r.getCuisineType()%>
									</p>
									<div class="d-flex justify-content-between">
										<span class="card-text">Rating: <%=r.getRating()%> ★
										</span> <span class="card-text">Time: <%=r.getDeliveryTime()%>
										</span>
									</div>
								</div>
							</div>
						</a>
					</div>
					<%
					}
					} else {
					%>
					<p>No restaurants available.</p>
					<%
}
%>
				</div>
  </div>
</section>
  
    
    
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
