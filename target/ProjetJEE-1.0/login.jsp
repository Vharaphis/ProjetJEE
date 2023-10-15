<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="resources/styles/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <h1>Login</h1>
    <form method="GET" action="login">
        <label for="email">Email</label>
        <input type="text" id="email" name="email" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <input type="submit" value="Login">
    </form>
    <p class="footer">Don't have an account? <a href="signup.jsp">Sign up</a></p>
</div>
</body>
</html>
