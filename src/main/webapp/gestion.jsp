<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Mon Site</title>
  <link href="resources/styles/header.css" rel="stylesheet" type="text/css">
  <link href="resources/styles/gestion.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  <link href="resources/styles/common.css" rel="stylesheet" type="text/css">
  <link href="resources/styles/popup.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css">


</head>
<body>
<header>
  <div class="left">
    <img src="resources/images/iron.png" alt="Logo du site">
    <h1>Trisotto</h1>
  </div>
  <div class="right">
    <div class="user-dropdown">
      <img src="resources/images/lol.png" alt="Icône utilisateur">
      <div class="dropdown-content">
        <a href="parameters.jsp">Paramètres</a>
        <a href="#">Déconnexion</a>
      </div>
    </div>
  </div>
</header>
<!-- Le reste du contenu de votre page -->
</body>
<h1>List of Users</h1>
<div class="researchTable">
  <div class="inputs">

    <div class="filter-input-container">
      <i class="fas fa-search"></i> <!-- Icône de loupe (Font Awesome) -->
      <input type="text" placeholder="Filtrer">
    </div>

    <div class="buttons">
      <input type="submit" value="Tutor" class="submit buttonFilter">
      <input type="submit" value="Apprentice" class="submit buttonFilter">
    </div>
  </div>

  <div class="tablo">
    <table>
      <thead>
      <tr>
        <th>Name</th>
        <th>Forename</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Role</th>
        <th></th>
      </tr>
      </thead>
      <tr>
        <td>MoreBullets</td>
        <td>Ineed</td>
        <td>ineedmorebullets@gmail.com</td>
        <td>0666666666</td>
        <td>Apprenti</td>
        <td><button class="submit" onclick="openPopup()">Details</button></td>
      </tr>
      <tr>
        <td>Shaco</td>
        <td>Ce</td>
        <td>champion@dencule.com</td>
        <td>0666666666</td>
        <td>Tutor</td>
        <td></td>
      </tr>
    </table>
  </div>
</div>
<div id="popup" class="popup">
  <div class="popup-content">
    <span class="close" id="close-popup" onclick="closePopup()">&times;</span>
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
<script>
  function closePopup() {
    var popup = document.getElementById("popup");
    popup.style.display = "none";
  }

  function openPopup() {
    var popup = document.getElementById("popup");
    popup.style.display = "flex";
  }
</script>

</html>