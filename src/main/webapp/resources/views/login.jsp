<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/styles/common.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/styles/login.css" rel="stylesheet" type="text/css">
    <title>Login</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>
<div class="container card">
    <h1>Login</h1>
    <form method="POST" action="login">
        <span class="login-row">
            <label for="email">Email</label>
            <input type="text" id="email" name="email" class="fillInput-login" required>
        </span>

        <span class="login-row">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="fillInput-login" required>
        </span>

        <input type="submit" value="Login" class="submit login-submit">
    </form>
    <c:if test="${error}">
        <p class="footer" style="color: red">Wrong email or password.</p>
    </c:if>
    <p class="footer">Don't have an account? <a href="signup">Sign up</a></p>
</div>
</body>

<style>



</style>

</html>