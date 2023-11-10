<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1 class="details-title">Update Tutor : user "${user.forename} ${user.lastname}"</h1>
    <form action="update-tutor" method="post">

        <label for="apprenticeList">Apprentices Tutored</label>
        <select id="apprenticeList" name="apprenticeList" multiple="multiple" size="5">
            <c:forEach var="apprentice" items="${allApprentices}">
                <!-- Met une couleur différente si apprentice.idTutor == tutor.idTutor-->
                <!-- PREMIER CAS : Bleu, ou couleur qui tape à l'oeil-->
                <c:if test="${apprentice.idTutor == tutor.idTutor}">
                    <option class="A" value="${apprentice.userId}">${apprentice.lastname} ${apprentice.forename}</option>
                </c:if>

                <!-- DEUXIEME CAS : Gris bien banal sa mère-->
                <c:if test="${apprentice.idTutor != tutor.idTutor}">
                    <option class="B" value="${apprentice.userId}">${apprentice.lastname} ${apprentice.forename}</option>
                </c:if>
            </c:forEach>
        </select>


        <input type="hidden" name="idApprentice" value="${tutor.idTutor}">
        <input type="hidden" name="idUser" value="${tutor.userId}">

        <input class="submit updateButtonDetails" type="submit" value="Update / Create my company">
    </form>
</div>


</body>
</html>
