<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  Very important for error pages -->
<%@ page isErrorPage="false"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>pickandbuy - register</title>
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
    <link rel="stylesheet" href="assets/css/Bootstrap-4---Payment-Form.css">
    <link rel="stylesheet" href="assets/css/Empty-message.css">
    <link rel="stylesheet" href="assets/css/Footer-Basic.css">
    <link rel="stylesheet" href="assets/css/Footer-Dark.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Dark.css">
    <link rel="stylesheet" href="assets/css/Pretty-Product-List.css">
    <link rel="stylesheet" href="assets/css/Profile-Edit-Form-1.css">
    <link rel="stylesheet" href="assets/css/Profile-Edit-Form.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/Toggle-Switch-1.css">
</head>

<body style="background: linear-gradient(rgba(255,255,255,0.25) 0%, rgba(0,0,0,0.75) 100%), url(&quot;assets/img/joanna-kosinska-1_CMoFsPfso-unsplash.jpg&quot;) center / cover no-repeat;">
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
    <div class="register-photo" style="background: transparent;">
        <div class="form-container">
            <div class="image-holder"></div>
            <form method="post" action="register_user">
                <h2 class="text-center"><strong>Create</strong> an account.</h2>
                <div class="form-group"><input class="form-control" type="text" placeholder="Name" name="name" required=""></div>
                <div class="form-group"><input class="form-control" type="text" placeholder="Surname" name="surname" required=""></div>
                <div class="form-group"><input class="form-control" type="email" name="email" placeholder="Email" required=""></div>
                <div class="form-group"><input class="form-control" type="password" name="pass" placeholder="Password" required=""></div>
                <div class="form-group"><select class="form-control" name="city">
                	<optgroup label="Selecciona tu ciudad">
                		<%
                		String[] cities = {"Alava","Albacete","Alicante","Almería","Asturias","Avila","Badajoz","Barcelona","Burgos","Cáceres",
                				"Cádiz","Cantabria","Castellón","Ciudad Real","Córdoba","La Coruña","Cuenca","Gerona","Granada","Guadalajara",
                				"Guipúzcoa","Huelva","Huesca","Islas Baleares","Jaén","León","Lérida","Lugo","Madrid","Málaga","Murcia","Navarra",
                				"Orense","Palencia","Las Palmas","Pontevedra","La Rioja","Salamanca","Segovia","Sevilla","Soria","Tarragona",
                				"Santa Cruz de Tenerife","Teruel","Toledo","Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"};
                		for (int i=0;i<cities.length;i++){
                			out.print("<option value='"+cities[i]+"'>"+cities[i]+"</option>");
                		}
                		%>
                	</optgroup></select>
                </div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="col-3"><label class="switch">
  							<input type="checkbox" required=""><span class="slider round"></span></label>
  						</div>
                        <div class="col-9">
                            <p style="font-size: 10px;">I have read and I agree with terms and conditions.</p>
                        </div>
                    </div>
                </div>
                <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="border-radius: 25px;background: rgb(252,147,49);">Sign Up</button></div><a class="already" href="login">You already have an account? Login here.</a></form>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-init.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.js"></script>
    <script src="assets/js/Auto-Modal-Popup.js"></script>
    <script src="assets/js/Navbar---Apple.js"></script>
    <script src="assets/js/Profile-Edit-Form.js"></script>
</body>

</html>