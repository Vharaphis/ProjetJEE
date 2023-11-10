<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit profile</title>
    <link href="${pageContext.request.contextPath}/resources/styles/parameters.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/styles/common.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/scripts/update-profile.js"></script>
</head>
<body>
<div class="container">
    <div class="profile">


        <h1>Update Company</h1>

        <form action="update-company" method="post">

            <div class="half-width flex">
                <label for="socialReason">Social Reason :</label>
                <input type="text" id="socialReason" name="socialReason" placeholder="Social Reason" value="${company.socialReason}">
            </div>

            <div class="half-width flex">
                <label for="companyAddress">Company Address :</label>
                <input type="text" id="companyAddress" name="companyAddress" placeholder="Company Address" value="${company.companyAddress}">
            </div>

            <div class="half-width flex">
                <label for="companyInfos">Company Infos :</label>
                <input type="text" id="companyInfos" name="companyInfos" placeholder="companyInfos" value="${company.companyInfos}">
            </div>

            <input type="hidden" name="idCompany" value="${company.idCompany}">

            <input type="submit" value="Update / Create my company">
        </form>
        <c:if test="${error}">
            <p class="footer" style="color: red">No fields other than 'passwords' should be blank. Passwords should be equal IF they are set.</p>
        </c:if>
    </div>
</div>

</body>
</html>