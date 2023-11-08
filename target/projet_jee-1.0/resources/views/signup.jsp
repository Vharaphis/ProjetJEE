<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href="../styles/signup.css" rel="stylesheet" type="text/css">
    <link href="../styles/common.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>
<div class="container card">
    <h1>Register</h1>
    <form method="POST" action="signup">
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

        <input type="submit" value="Sign up" class="submit">
    </form>
    <p class="footer">Already have an account? <a href="login.jsp">Login</a></p>
</div>
</body>
</html>