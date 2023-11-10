<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit profile</title>
    <link href="${pageContext.request.contextPath}/resources/styles/header.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/styles/parameters.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/styles/common.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/scripts/update-profile.js"></script>
</head>
<body>

<header>
    <div class="left">
        <img src="${pageContext.request.contextPath}/resources/images/iron.png" alt="Logo du site">
        <button class="submit buttonHeader" onclick="location.href='${pageContext.request.contextPath}/gestion';"> < Back </button>
    </div>
    <div class="right">&nbsp;&nbsp;
        <div class="user-dropdown">
            <img src="${pageContext.request.contextPath}/resources/images/profile.png" alt="User icon">
            <div class="dropdown-content">
                <a href="${pageContext.request.contextPath}/update-profile">Update profile</a>
                <a href="${pageContext.request.contextPath}/logout">Disconnect</a>
            </div>
        </div>
    </div>
</header>


<div class="container">
    <div class="profile">
        <h1>Edit your user profile</h1>
        <form action="update-profile" method="post">

            <div class="half-width flex">
                <label for="lastname">Last Name :</label>
                <input type="text" id="lastname" name="lastname" placeholder="Last name" value="${authenticatedUser.lastname}">
            </div>

            <div class="half-width flex">
                <label for="forename">Forename :</label>
                <input type="text" id="forename" name="forename" placeholder="Forename" value="${authenticatedUser.forename}">
            </div>

            <div class="half-width flex">
                <label for="email">Email :</label>
                <input type="text" id="email" name="email" placeholder="Email" value="${authenticatedUser.email}">
            </div>

            <div class="half-width flex">
                <label for="phone">Phone :</label>
                <input type="text" id="phone" name="phone" placeholder="Phone" value="${authenticatedUser.phone}">
            </div>

            <div class="half-width flex">
                <label for="newPassword">New password :</label>
                <input type="password" id="newPassword" name="newPassword" placeholder="new password">
            </div>

            <div class="half-width flex">
                <label for="confirmPassword">Confirm password :</label>
                <input type="password" id="confirmPassword" name="confirmPassword" placeholder="confirm password">
            </div>

            <input type="submit" name="update" value="Update my user profile">
        </form>
        <c:if test="${error}">
            <p class="footer" style="color: red">No fields other than 'passwords' should be blank. Passwords should be equal IF they are set.</p>
        </c:if>
    </div>
</div>

</body>
</html>