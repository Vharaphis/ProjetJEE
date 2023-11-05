<%--
  Created by IntelliJ IDEA.
  User: YSI13
  Date: 10/20/2023
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Parameters</title>
    <link href="resources/styles/parameters.css" rel="stylesheet" type="text/css">
    <link href="resources/styles/common.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="profile">
        <h1>Modifier votre profil</h1>
        <form action="#" method="post">
            <label for="email">email :</label>
            <input type="text" id="email" name="email" placeholder="Email" value="Yani@pd.com">

            <label for="phone">Phone :</label>
            <input type="text" id="phone" name="phone" placeholder="Phone" value="0475874554">

            <label for="oldPassword">Old password :</label>
            <input type="password" id="oldPassword" name="oldPassword" placeholder="old password">

            <label for="newPassword">New password :</label>
            <input type="password" id="newPassword" name="newPassword" placeholder="new password">

            <label for="confirmPassword">Confirm password :</label>
            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="confirm password">

            <input type="submit" value="Enregistrer">
        </form>
    </div>
</div>

</body>
</html>