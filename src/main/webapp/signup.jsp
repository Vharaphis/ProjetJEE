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
    <form method="POST" action="signup">
        <label for="name">Name</label>
        <input type="text" id="name" name="name" required>

        <label for="forename">Forename</label>
        <input type="text" id="forename" name="forename" required>

        <label for="email">Email</label>
        <input type="text" id="email" name="email" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>

        <label for="profession-select">Profession</label>
        <select name="profession" id="profession-select">
            <option value="Apprentice">Apprentice</option>
            <option value="Tutor">Tutor</option>
        </select>

        <input type="submit" value="Sign Up">
    </form>
    <p class="footer">Already have an account? <a href="login.jsp">Login</a></p>
</div>
</body>
</html>
