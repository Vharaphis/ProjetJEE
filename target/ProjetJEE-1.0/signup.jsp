<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="resources/styles/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <h1>Register</h1>
    <form>
        <label for="name">Name</label>
        <input type="text" id="name" name="name" required>

        <label for="forname">Forname</label>
        <input type="text" id="forname" name="forname" required>

        <label for="email">Email</label>
        <input type="text" id="email" name="email" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <label for="confirmpassword">Confirm Password</label>
        <input type="password" id="confirmpassword" name="confirmpassword" required>

        <label for="profession-select">Profession</label>
        <select name="profession" id="profession-select">
            <option value="student">student</option>
            <option value="tutor">tutor</option>
        </select>

        <input type="submit" value="Login">
    </form>
    <p class="footer">Already have an account? <a href="login.jsp">Login</a></p>
</div>
</body>
</html>
