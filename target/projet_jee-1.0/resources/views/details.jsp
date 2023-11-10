<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Details</title>
    <link href="${pageContext.request.contextPath}/resources/styles/header.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/styles/details.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/styles/common.css" rel="stylesheet" type="text/css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css" rel="stylesheet">
</head>
<body>

<header>
    <div class="left">
        <img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Logo du site">
        <button class="submit buttonHeader" onclick="location.href='${pageContext.request.contextPath}/gestion';"> < Back </button>
    </div>
    <div class="right">&nbsp;&nbsp;
        <div class="user-dropdown">
            <img src="${pageContext.request.contextPath}/resources/images/lol.png" alt="User icon">
            <div class="dropdown-content">
                <a href="${pageContext.request.contextPath}/update-profile">Update profile</a>
                <a href="${pageContext.request.contextPath}/logout">Disconnect</a>
            </div>
        </div>
    </div>
</header>


<div class="details">
    <div class="details-apprenticeInformation">
        <h1 class="details-title">
            <c:if test="${associatedTutor != null}">
                Tutor Information
            </c:if>
            <c:if test="${associatedTutor == null}">
                Apprentice Information
            </c:if>
        </h1>
        <div class="half-width flex">
            <span class="bold">Lastname</span>
            <span>${user.lastname}</span>
        </div>
        <div class="half-width flex">
            <span class="bold">Forename</span>
            <span>${user.forename}</span>
        </div>
        <div class="half-width flex">
            <span class="bold">Email</span>
            <span>${user.email}</span>
        </div>
        <div class="half-width flex">
            <span class="bold">Phone Number</span>
            <span>${user.phone}</span>
        </div>
    </div>

    <c:if test="${associatedApprentice != null}">
        <div class="details-apprenticeInformation">
            <h1 class="details-title">Company And School Information</h1>

            <div class="half-width flex">
                <span class="bold">Program</span>
                <span>${associatedApprentice.program}</span>
            </div>
            <div class="half-width flex">
                <span class="bold">Academic Year</span>
                <span>${associatedApprentice.academicYear}</span>
            </div>
            <div class="half-width flex">
                <span class="bold">Major</span>
                <span>${associatedApprentice.major}</span>
            </div>
            <div class="half-width flex">
                <span class="bold">Is Archived</span>
                <span>
                        <c:choose>
                            <c:when test="${associatedApprentice.isArchived}">True</c:when>
                            <c:otherwise>False</c:otherwise>
                        </c:choose>
                    </span>
                </div>
                <div class="half-width flex">
                    <span class="bold">Company</span>
                    <span>${apprenticeCompany.socialReason}</span>
                    <span>${apprenticeCompany.companyAddress}</span>
                    <span>${apprenticeCompany.companyInfos}</span>
                </div>
                <div class="half-width flex">
                    <span class="bold">Tutor</span>
                    <span><a href="detail?userId=${apprenticeTutor.userId}">${apprenticeTutor.forename} ${apprenticeTutor.lastname}</a></span>
                </div>
            </div>


        <div class="details-apprenticeInformation">
            <h1 class="details-title">Tutor's Apprentices</h1>
            <!-- ON ARRIVE EN DESSOUS UNIQUEMENT QUUAND ON DISPLAY LES INFOS DU TUTEUR : TU ME FAIS LE CSS WALLAH-->
            <c:if test="${associatedTutor != null}">
                <c:if test="${not empty tutorApprentices}">
                    <table>
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Forename</th>
                            <th>Role</th>
                            <th></th>
                        </tr>
                        </thead>
                        <!-- TUTOR APPRENTICES CONTIENT LA LISTE D'APPRENTI D'UN TUTEUR-->
                        <c:forEach var="apprentice" items="${tutorApprentices}">
                            <tr>
                                <td>${apprentice.lastname}</td>
                                <td>${apprentice.forename}</td>
                                <td>${apprentice.userType}</td>
                                <td><button class="submit" onclick="location.href='${pageContext.request.contextPath}/detail?userId=${apprentice.userId}';">Details</button></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <c:if test="${empty tutorApprentices}">

                </c:if>
                <button class="submit updateButtonDetails" onclick="location.href='${pageContext.request.contextPath}/update-tutor?idTutor=${associatedTutor.idTutor}';">Update Tutor's Information</button>
            </c:if>

        </div>

        </div>
        <button class="submit updateButtonDetails" onclick="location.href='${pageContext.request.contextPath}/update-apprentice?idApprentice=${associatedApprentice.idApprentice}';">Update Apprentice's Information</button>
    </c:if>



    <c:if test="${associatedApprentice == null && associatedTutor == null}">
        <h3>NO DATA ABOUT THE USER TYPE. THIS IS A PROBLEM.</h3>
    </c:if>


</body>
</html>
