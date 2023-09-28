
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <!-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>  -->
    <link type="text/css" href="../resources/styles/login.css" rel="stylesheet">
    <title>Jakarta EE - Login</title>
</head>

<body>
<p>tkt</p>
<div class="d-grid gap-3">
    <div class="p-2 bg-light border"><input class="form-control" placeholder="Login" name="champLogin" autofocus=""></div>
    <div class="p-2 bg-light border"><input class="form-control" placeholder="Login" name="champLogin" autofocus=""></div>
    <div class="p-2 bg-light border"><input class="form-control" placeholder="Login" name="champLogin" autofocus=""></div>
</div>
<div class="container" style="margin-top:30px">
    <div class="col-md-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Login</h3>
            </div>
            <div class="d-grid gap-3">
                <form action="hello-servlet" method="post">
                    <fieldset>
                        <div class="p-2 light border">
                            <input class="form-control" placeholder="Login" name="champLogin" autofocus="">
                        </div>
                        <div class="p-2-group">
                            <input class="form-control" placeholder="Mot de passe" name="champMotDePasse" type="password">
                        </div>

                        <input type="submit" name="action" value="Login" class="btn btn-primary"/>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="text-bg-danger p-3">
            login failed
        </div>
    </div>
</div>

</body>
</html>