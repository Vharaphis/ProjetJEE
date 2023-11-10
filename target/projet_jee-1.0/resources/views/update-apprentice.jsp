<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 10/11/2023
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/resources/styles/header.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/styles/common.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/styles/update-apprentice.css" rel="stylesheet" type="text/css">
</head>
<body>


<header>
    <div class="left">
        <img src="${pageContext.request.contextPath}/resources/images/iron.png" alt="Logo du site">
        <button class="submit buttonHeader" onclick="location.href='${pageContext.request.contextPath}/gestion';"> Home </button>
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


<div class="update-apprentice">
    <h1 class="details-title">Update Apprentice : user "${user.forename} ${user.lastname}"</h1>
    <form action="update-apprentice" method="post">

        <div class="width flex">
            <label class="bold" for="academicYear">Academic Year :</label>
            <input class="fillInput" type="text" id="academicYear" name="academicYear" placeholder="Academic Year" value="${apprentice.academicYear}">
        </div>

        <div class="width flex">
            <label class="bold" for="program">Program :</label>
            <input class="fillInput" type="text" id="program" name="program" placeholder="Program" value="${apprentice.program}">
        </div>

        <div class="width flex">
            <label class="bold" for="major">Major :</label>
            <input class="fillInput" type="text" id="major" name="major" placeholder="Major" value="${apprentice.major}">
        </div>

        <input type="hidden" name="idApprentice" value="${apprentice.idApprentice}">
        <input type="hidden" name="idUser" value="${apprentice.userID}">

        <input class="submit updateButtonDetails" type="submit" value="Update / Create my company">
    </form>
</div>


</body>
</html>
