<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Login to FoodCrazz</title>
  <style>
    /* (Your existing CSS styles here) */
    body {
      margin: 0;
      padding: 0;
      font-family: 'Georgia', serif;
      background-image: url('https://images.unsplash.com/photo-1600891964599-f61ba0e24092');
      background-repeat: no-repeat;
      background-size: cover;
      background-position: center;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .login-container {
      background-color: rgba(247, 236, 217, 0.92);
      padding: 40px;
      border-radius: 12px;
      box-shadow: 0 6px 20px rgba(0, 0, 0, 0.4);
      width: 360px;
      border: 2px solid #8c5e3c;
    }

    .login-container h2 {
      text-align: center;
      margin-bottom: 20px;
      color: #5a3c2d;
      font-size: 26px;
    }

    .input-group {
      margin-bottom: 20px;
    }

    .input-group label {
      display: block;
      margin-bottom: 6px;
      color: #5c4033;
      font-weight: bold;
    }

    .input-group input {
      width: 100%;
      padding: 10px;
      border: 1px solid #a78b71;
      border-radius: 4px;
      background-color: #fff7e8;
      font-size: 14px;
      box-sizing: border-box;
    }

    .input-group input:focus {
      outline: none;
      border-color: #8c5e3c;
    }

    .login-btn {
      width: 100%;
      padding: 12px;
      background-color: #8c5e3c;
      color: white;
      border: none;
      border-radius: 4px;
      font-size: 15px;
      cursor: pointer;
      transition: 0.3s ease;
      box-sizing: border-box;
      margin-top: 10px;
    }

    .login-btn:hover {
      background-color: #6b4228;
    }

    .register-link {
      margin-top: 15px;
      text-align: center;
      color: #4a2f22;
      font-size: 14px;
    }

    .register-link a {
      color: #8c5e3c;
      text-decoration: none;
      font-weight: bold;
    }

    .register-link a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

  <div class="login-container">
    <h2>Login to FoodCrazz</h2>
    <form action="LoginServlet" method="post">
      <div class="input-group">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>
      </div>

      <div class="input-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
      </div>

      <!-- Display the error message if present -->
      <c:if test="${not empty errorMessage}">
        <div class="error-message" style="color: red; text-align: center; margin-bottom: 10px;">
          ${errorMessage}
        </div>
      </c:if>

      <button type="submit" class="login-btn">Login</button>

      <div class="register-link">
        New here? <a href="Registration.jsp">Create an account</a>
      </div>
    </form>
  </div>

</body>
</html>

  