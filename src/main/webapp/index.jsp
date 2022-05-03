<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Register</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row-justify-content-center">
        <div class="col-md-6" style="border: 2px solid; margin-top: 50px; ">
            <h1 class="text-center">REGISTRATION</h1><br>
            <form class="form-group" action="register" method="post">
                <%--@declare id="name"--%><label class="form-label" for="name"> Enter your name</label>
                <input name="name" type="text" class="form-control mb-3" minlength="3" required>
                <%--@declare id="username"--%><label class="form-label" for="username"> Enter your UserName</label>
                   <input name="username" type="text" class="form-control mb-3" minlength="3" required >
                    <%--@declare id="password"--%> <label class="form-label" for="password"> Enter your Password</label>
                   <input name="pass1" type="password" class="form-control mb-3" minlength="6"  pattern="^[а-яА-ЯёЁa-zA-Z0-9]+$" title="The password must not contain special characters!" required >
                    <%--@declare id="password2"--%><label class="form-label" for="password2"> Confirm your Password</label>
                   <input name="pass2" type="password" class="form-control mb-3" minlength="6" pattern="^[а-яА-ЯёЁa-zA-Z0-9]+$" title="The password must not contain special characters!"required >
                <button class="btn btn-primary mb-4" type="submit"> Sign up</button>
                <button class="btn btn-danger mb-4" type="reset"> Cancel</button>
            </form>
            <p> Already Registered? <a href="login.jsp" > Login </a></p>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>
