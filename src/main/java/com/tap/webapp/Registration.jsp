<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Sign Up to FoodCrazz</title>
  <style>
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

    .signup-container {
      background-color: rgba(247, 236, 217, 0.92);
      padding: 40px;
      border-radius: 12px;
      box-shadow: 0 6px 20px rgba(0, 0, 0, 0.4);
      width: 360px;
      border: 2px solid #8c5e3c;
    }

    .signup-container h2 {
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

    .signup-btn {
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

    .signup-btn:hover {
      background-color: #6b4228;
    }

    .login-link {
      margin-top: 15px;
      text-align: center;
      color: #4a2f22;
      font-size: 14px;
    }

    .login-link a {
      color: #8c5e3c;
      text-decoration: none;
      font-weight: bold;
    }

    .login-link a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

<div class="form-container">
        <!-- Form action points to a servlet or JSP handler for registration -->
        <form action="RegistrationServlet" method="POST">
  <div class="signup-container">
    <h2>Create Your Account</h2>
      <div class="input-group">
        <label for="name">Name</label>
        <input type="text" id="name" name="name" required>
      </div>
      
      <div class="input-group">
        <label for="phone">Mobile</label>
        <input type="number" id="phone" name="phone" required>
      </div>

      <div class="input-group">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>
      </div>

      <div class="input-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
      </div>

      <div class="input-group">
        <label for="confirm-password">Confirm Password</label>
        <input type="password" id="confirm-password" name="confirm-password" required>
      </div>

      <button type="submit" class="signup-btn">Sign Up</button>

      <div class="login-link">
        Already have an account? <a href="Login.jsp">Login here</a>
      </div>
  </div>
  </form>
</div>

</body>
</html>


