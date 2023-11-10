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
</head>
<body>
    <h1>Update Company</h1>

    <h2>For user "${user.forename} ${user.lastname}"</h2>

    <form action="update-apprentice" method="post">

        <div class="half-width flex">
            <label for="academicYear">Academic Year :</label>
            <input type="text" id="academicYear" name="academicYear" placeholder="Academic Year" value="${apprentice.academicYear}">
        </div>

        <div class="half-width flex">
            <label for="program">Program :</label>
            <input type="text" id="program" name="program" placeholder="Program" value="${apprentice.program}">
        </div>

        <div class="half-width flex">
            <label for="major">Company Infos :</label>
            <input type="text" id="major" name="major" placeholder="Major" value="${apprentice.major}">
        </div>

        <input type="hidden" name="idApprentice" value="${apprentice.idApprentice}">
        <input type="hidden" name="idUser" value="${apprentice.userID}">

        <input type="submit" value="Update / Create my company">
    </form>



    <div class="input-row">
        <div class="half-width flex">
            <span class="bold">Program</span>
            <span>${associatedApprentice.program}</span>
        </div>
        <div class="half-width flex">
            <span class="bold">Academic Year</span>
            <span>${associatedApprentice.academicYear}</span>
        </div>
    </div>
    <div class="input-row">
        <div class="half-width flex">
            <span class="bold">Major</span>
            <span>${associatedApprentice.major}</span>
        </div>
    </div>

</body>
</html>
