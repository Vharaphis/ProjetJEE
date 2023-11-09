<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <title>Mon Site</title>
  <link href="${pageContext.request.contextPath}/resources/styles/header.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/styles/gestion.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/styles/common.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/styles/popup.css" rel="stylesheet" type="text/css">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/resources/scripts/gestion.js"></script>
</head>
<body>
<header>
  <div class="left">
    <img src="${pageContext.request.contextPath}/resources/images/iron.png" alt="Logo du site">
    <h1>Bonjour ${authenticatedUser.forename} ${authenticatedUser.lastname}</h1>
  </div>
  <div class="right">
    <div class="user-dropdown">
      <img src="${pageContext.request.contextPath}/resources/images/lol.png" alt="Icône utilisateur">
      <div class="dropdown-content">
        <a href="${pageContext.request.contextPath}/update-profile">Update profile</a>
        <a href="${pageContext.request.contextPath}/logout">Déconnexion</a>
      </div>
    </div>
  </div>
</header>

<h1>List of Users</h1>
<div class="researchTable">
  <div class="inputs">

    <div class="filter-input-container">
      <i class="fas fa-search"></i> <!-- Icône de loupe (Font Awesome) -->
      <input type="text" placeholder="Filtrer">
    </div>

    <div class="buttons">
      <input type="submit" value="Create User" onclick="openPopupCreateUser()" class="submit buttonFilter">
      <input type="submit" value="Tutor" class="submit buttonFilter">
      <input type="submit" value="Apprentice" class="submit buttonFilter">
    </div>
  </div>

  <c:if test="${not empty USER_LIST}">
  <div class="tablo">
    <table>
      <thead>
      <tr>
        <th>Name</th>
        <th>Forename</th>
        <th>Role</th>
        <th></th>
      </tr>
      </thead>

      <c:forEach var="user" items="${USER_LIST}">
        <tr>
          <td>${user.lastname}</td>
          <td>${user.forename}</td>
          <td>${user.userType}</td>
          <td><button class="submit" onclick="openPopupDetail()">Details</button></td>
          <td><button class="submit" onclick="openPopupEdit()">Edit</button></td>
          <td><button class="submit" onclick="location.href='${pageContext.request.contextPath}/archive?userId=${user.userId}';">Archive</button></td>
        </tr>
      </c:forEach>

    </table>
    </c:if>
    <c:if test="${empty USER_LIST}">
      <p>La liste est vide. Ajoutez au moins un(e) apprenti(e)</p>
    </c:if>
  </div>
</div>



<div id="popupEdit" class="popup">
  <div class="popup-content">
    <span class="close" id="close-popup-detail" onclick="closePopupEdit()">&times;</span>
    <h2 class="popup-title">Ineed Morebullets</h2>
    <div class="input-row">
      <div class="half-width flex">
        <span class="bold">Academic Year</span>
        <input class="fillInput" type="text" id="academic" name="lastname" placeholder="Academic Year">
      </div>
      <div class="half-width flex">
        <span class="bold">Program</span>
        <input class="fillInput" type="text" id="program" name="lastname" placeholder="Program" >
      </div>
    </div>
    <div class="input-row">
      <div class="half-width flex">
        <span class="bold">Major</span>
        <input class="fillInput" type="text" id="major" name="lastname" placeholder="Major">
      </div>
      <div class="half-width flex">
        <span class="bold">Tutor</span>
        <input class="fillInput" type="text" id="tutor" name="lastname" placeholder="Tutor">
      </div>
    </div>
    <hr />
    <h3 class="popup-title"> US Navy </h3>
    <div class="input-row">
      <div class="half-width flex">
        <span class="bold">Address</span>
        <input class="fillInput" type="text" id="address" name="lastname" placeholder="Address">
      </div>
      <div class="half-width flex">
        <span class="bold">Infos</span>
        <input class="fillInput" type="text" id="infos" name="lastname" placeholder="Infos">
      </div>
    </div>
  </div>
</div>


<div id="popupDetail" class="popup">
  <div class="popup-content">
    <span class="close" id="close-popup-edit" onclick="closePopupDetail()">&times;</span>
    <h2 class="popup-title">Ineed Morebullets</h2>
    <div class="input-row">
      <div class="half-width flex">
        <span class="bold">Academic Year</span>
        <span>2022 - 2023</span>
      </div>
      <div class="half-width flex">
        <span class="bold">Program</span>
        <span>RS</span>
      </div>
    </div>
    <div class="input-row">
      <div class="half-width flex">
        <span class="bold">Major</span>
        <span>Cybersecurity</span>
      </div>
      <div class="half-width flex">
        <span class="bold">Tutor</span>
        <span>LaFrappeDeChine</span>
      </div>
    </div>
    <hr />
    <h3 class="popup-title"> US Navy </h3>
    <div class="input-row">
      <div class="half-width flex">
        <span class="bold">Address</span>
        <span>4 rue des Chasseurs</span>
      </div>
      <div class="half-width flex">
        <span class="bold">Infos</span>
        <span>A la cambrousse</span>
      </div>
    </div>
  </div>
</div>


<div id="popupCreateUser" class="popup">
  <div class="popup-content">
    <span class="close" id="close-popup-create-user" onclick="closePopupCreateUser()">&times;</span>

    <h1>Create a new user</h1>
    <form method="POST" action="create">
      <div class="input-row">
        <div class="half-width">
          <label for="name">Name</label>
          <input type="text" id="name" name="name" class="fillInput" required>
        </div>
        <div class="half-width">
          <label for="forename">Forename</label>
          <input type="text" id="forename" name="forename" class="fillInput" required>
        </div>
      </div>

      <div class="input-row">
        <div class="half-width">
          <label for="email">Email</label>
          <input type="text" id="email" name="email" class="fillInput" required>
        </div>
        <div class="half-width">
          <label for="profession-select">Profession</label>
          <select name="profession" id="profession-select">
            <option value="Apprentice">Student</option>
            <option value="Tutor">Tutor</option>
          </select>
        </div>
      </div>

      <div class="input-row">
        <div class="half-width">
          <label for="password">Password</label>
          <input type="password" id="password" name="password" class="fillInput" required>
        </div>
        <div class="half-width">
          <label for="confirmPassword">Confirm Password</label>
          <input type="password" id="confirmPassword" name="confirmPassword" class="fillInput" required>
        </div>
      </div>

      <input type="submit" value="Create" class="submit">
    </form>

  </div>
</div>


</body>
</html>