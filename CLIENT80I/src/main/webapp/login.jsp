<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  Very important for error pages -->
<%@ page isErrorPage="false"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>pickandbuy - login</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amarante">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Asul">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="assets/css/Animation-Cards-1.css">
    <link rel="stylesheet" href="assets/css/Animation-Cards.css">
    <link rel="stylesheet" href="assets/css/Auto-Modal-Popup.css">
    <link rel="stylesheet" href="assets/css/Footer-Basic.css">
    <link rel="stylesheet" href="assets/css/Footer-Dark.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Dark.css">
    <link rel="stylesheet" href="assets/css/Profile-Edit-Form-1.css">
    <link rel="stylesheet" href="assets/css/Profile-Edit-Form.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
    <div class="login-dark" style="height: 100vh;background: linear-gradient(rgba(255,255,255,0.25) 0%, rgba(0,0,0,0.75) 100%), url(&quot;assets/img/joanna-kosinska-1_CMoFsPfso-unsplash.jpg&quot;) center / cover no-repeat, rgb(255,255,255);">
        <nav class="navbar navbar-light navbar-expand-md">
            <div class="container-fluid"><a class="navbar-brand" href="login"><img src="assets/img/pickandbuy.png" style="width: 80px;"></a><a class="navbar-brand" href="#" style="font-size: 30px;font-family: Amarante, cursive;">PICK&amp;BUY</a><button data-toggle="collapse" class="navbar-toggler"
                    data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse d-xl-flex justify-content-xl-end" id="navcol-1" style="font-size: 24px;">
                    <ul class="nav navbar-nav">
                        <li class="nav-item"></li>
                    </ul>
                </div>
            </div>
        </nav>
        <form method="post" style="background: rgba(30,35,51,0.8);">
            <h2 class="sr-only">Login FormPI</h2>
            <div class="illustration"><i class="icon ion-ios-locked-outline" style="color: rgb(252,147,49);"></i></div>
            <div class="form-group" style="color: rgb(255,255,255);"><input class="form-control" type="email" name="email" placeholder="Email" style="color: #ffffff;" required=""></div>
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password" style="color: #ffffff;" required=""></div>
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background: rgb(252,147,49);border-radius: 25px;">Log In</button></div><a class="forgot" href="register_user" style="color: #ffffff;">Maybe do you want to register?</a></form>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-init.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.js"></script>
    <script src="assets/js/Profile-Edit-Form.js"></script>
</body>

</html>