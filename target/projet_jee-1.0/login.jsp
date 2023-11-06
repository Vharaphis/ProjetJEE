<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="resources/styles/login.css" rel="stylesheet" type="text/css">
    <link href="resources/styles/common.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>
<div class="container card">
    <h1>Login</h1>
    <form method="POST" action="login">
        <label for="email">Email</label>
        <input type="text" id="email" name="email" class="fillImput" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="fillImput" required>

        <input type="submit" value="Login" class="submit">
    </form>
    <c:if test="${error}">
        <p class="footer" style="color: red">Wrong email or password.</p>
    </c:if>
    <p class="footer">Don't have an account? <a href="signup.jsp">Sign up</a></p>
</div>
</body>
</html>
