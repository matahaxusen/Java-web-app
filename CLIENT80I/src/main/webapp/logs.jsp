<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  Very important for error pages -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>logs</title>
    <% 
    String[] error = (String[]) request.getAttribute("error");
		if (error == null){
			out.print("<script>location.replace('login');</script>");
		}else{
			out.print("<meta http-equiv='refresh' content='3; URL=login'>");
		}	
    %>
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
    <link rel="stylesheet" href="assets/css/Empty-message.css">
    <link rel="stylesheet" href="assets/css/Footer-Basic.css">
    <link rel="stylesheet" href="assets/css/Footer-Dark.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Dark.css">
    <link rel="stylesheet" href="assets/css/Profile-Edit-Form-1.css">
    <link rel="stylesheet" href="assets/css/Profile-Edit-Form.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body style="height: 100vh;">
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
    <section class="text-center d-md-flex align-items-md-center">
        <div class="container d-xl-flex justify-content-xl-center">
            <div class="card mh-medium my-4 d-block" style="box-shadow: 0px 0px 20px 10px rgb(228,228,228);width: 70%;"><img class="card-img w-100 d-block mh-medium o-25" src="assets/img/undraw_into_the_night_vumi.svg" style="padding: 2rem;">
                <div class="card-img-overlay d-flex flex-column justify-content-center">
                <%
                	out.print("<h1 class='text-center'>"+error[0]+"&nbsp;</h1>");
                	out.print("<p class='lead text-center'>"+error[1]+"</p>");
                %>
                </div>
            </div>
        </div>
    </section>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-init.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.js"></script>
    <script src="assets/js/Auto-Modal-Popup.js"></script>
    <script src="assets/js/Navbar---Apple.js"></script>
    <script src="assets/js/Profile-Edit-Form.js"></script>
</body>

</html>