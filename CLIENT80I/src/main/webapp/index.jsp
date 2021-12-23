<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  Very important for error pages -->
<%@ page isErrorPage="false"%>
<%@ page import="domains.User" %>
<%@ page import="domains.Product" %>
<%
	User client = (User) session.getAttribute("user");
	if (client == null) {
		String[] error = {"Access denied","You dont have enough privileges to access here"};
		request.setAttribute("error",error);
		request.getRequestDispatcher("logs.jsp").forward(request, response);
	}
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>pickandbuy</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Amarante">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Asul">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/fonts/ionicons.min.css">
<link rel="stylesheet"
	href="assets/fonts/fontawesome5-overrides.min.css">
<link rel="stylesheet" href="assets/css/Animation-Cards-1.css">
<link rel="stylesheet" href="assets/css/Animation-Cards.css">
<link rel="stylesheet" href="assets/css/Auto-Modal-Popup.css">
<link rel="stylesheet" href="assets/css/Footer-Basic.css">
<link rel="stylesheet" href="assets/css/Footer-Dark.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.2.0/aos.css">
<link rel="stylesheet" href="assets/css/Login-Form-Dark.css">
<link rel="stylesheet" href="assets/css/Profile-Edit-Form-1.css">
<link rel="stylesheet" href="assets/css/Profile-Edit-Form.css">
<link rel="stylesheet"
	href="assets/css/Registration-Form-with-Photo.css">
<link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
	<section
		style="background: #ffffff; box-shadow: 0px 0px 14px rgb(190, 190, 190);">
		<nav class="navbar navbar-light navbar-expand-md">
			<div class="container-fluid">
				<a class="navbar-brand" href="index"><img
					src="assets/img/pickandbuy.png" style="width: 80px;"></a><a
					class="navbar-brand" href="#"
					style="font-size: 30px; font-family: Amarante, cursive;">PICK&amp;BUY</a>
				<button data-toggle="collapse" class="navbar-toggler"
					data-target="#navcol-1">
					<span class="sr-only">Toggle navigation</span><span
						class="navbar-toggler-icon"></span>
				</button>
				<div
					class="collapse navbar-collapse d-xl-flex justify-content-xl-end align-items-xl-center"
					id="navcol-1" style="font-size: 24px;">
					<ul class="nav navbar-nav" style="margin-left: 3rem;">
						<li
							class="nav-item d-xl-flex justify-content-xl-end align-items-xl-center"
							style="padding-top: 0px;"><a class="nav-link"
							href="update_user">
								<p class="d-xl-flex align-items-xl-center"
									style="font-size: 18px; margin-top: 0px; padding-top: 13px; font-family: Roboto, sans-serif;">
									<img src="assets/img/usersIMG/<%out.print(client.getImage());%>.jpg"
										style="width: 3rem; height: 3rem; border-radius: 40px; border: 2px solid rgb(252, 147, 49); margin-right: .5rem;">&nbsp;
										<%out.print(client.getName()+" "+client.getSurname());%>
								</p>
						</a></li>
					</ul>
					<ul class="nav navbar-nav" style="margin-left: 3rem;">
						<li class="nav-item"><a
							class="btn btn-primary btn-block orange-hover" role="button"
							href="add_product"
							style="border-radius: 25px; padding-right: 22px; padding-left: 22px; border-style: solid; border-color: rgb(255, 206, 160);"><i
								class="fas fa-plus-circle" style="font-size: 18px;"></i>&nbsp;
								Add a product</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</section>
	<section>
        <div class="container">
            <form method="post" action="index_search">
                <div class="form-group">
                    <div class="form-row">
                        <div class="col">
                            <div class="form-row">
                                <div class="col-4"><select class="form-control" name="area" required="">
                                	<%
									String[] areas = {"descripcion","vendedor","titulo","categoria"};
									for (int i=0;i<areas.length;i++){
										out.print("<option value='"+areas[i]+"'>"+areas[i]+"</option>");
									}
									%>
                                </select></div>
                                <div
                                    class="col-8"><input class="form-control" required="" type="text" name="search" placeholder="Write what you wish..."></div>
                        </div>
                    </div>
                    <div class="col"><button class="btn btn-primary btn-block orange-hover" type="submit" style="border-radius: 25px;padding-right: 22px;padding-left: 22px;border-style: solid;border-color: rgb(255,206,160);width: 191px;"><i class="fa fa-search" style="font-size: 18px;"></i>&nbsp;SEARCH</button></div>
                </div>
        </div>
        </form>
        </div>
    </section>
	<section>
		<div class="container">
			<%
			int row_cont = 0;
			Product[] products_array = (Product[]) request.getAttribute("products");
			out.print("<div class='row space-rows'>");
			String product_description;
			String product_title;
			for (int i=0;i<products_array.length;i++){
				if (products_array[i].getDescription().length() > 60){
					product_description = products_array[i].getDescription().substring(0,Math.min(products_array[i].getDescription().length(), 58))+"...";
				}else{
					product_description = products_array[i].getDescription(); 
				}
				if (products_array[i].getTitle().length() > 18){
					product_title = products_array[i].getTitle().substring(0,Math.min(products_array[i].getTitle().length(), 18))+"...";
				}else{
					product_title = products_array[i].getTitle(); 
				}
				if (row_cont > 2){
					out.print("</div><div class='row space-rows'>");
					row_cont = 0;
				}
				out.print("<div class='col-sm-12 col-md-4' style='margin-top: 2rem;'>");
				out.print("<div class='card cards-shadown cards-hover' data-aos='flip-left' data-aos-duration='950'>");
				out.print("<div class='card-header' style='background: url(assets/img/items/"+products_array[i].getImage()+") center/cover no-repeat;''> <a class='stretched-link' href='view_product?id_product="+products_array[i].getId_product()+"'></a> </div>");
				out.print("<div class='card-body' style='font-family: Roboto, sans-serif;'>");
				out.print("<p class='text-uppercase card-text sub-text-color' style='color: rgb(57, 57, 57); font-size: 20px;'>"+product_title+"</p>");
				out.print("<p class='text-uppercase card-text sub-text-color' style='color: rgb(57, 57, 57); font-size: 16px;'>Precio: "+products_array[i].getValue()+"€</p>");
				out.print("<p class='card-text cardbody-sub-text' style='font-size: 16px;'>"+product_description+"</p> </div></div></div>");
			}
			out.print("</div>");
			%>
			<div class="row d-xl-flex justify-content-xl-center">
				<div class="col-sm-12 col-md-4">
					<button class="btn btn-primary btn-block orange-hover"
						type="submit"
						style="border-radius: 25px; padding-right: 22px; padding-left: 22px; border: 2px solid rgb(255, 206, 160);">
						<i class="fas fa-search-plus" style="font-size: 18px;"></i>&nbsp;
						SHOW MORE
					</button>
				</div>
			</div>
		</div>
	</section>
	<div class="footer-basic">
		<footer>
			<div class="social">
				<a href="#"><i class="icon ion-social-instagram"></i></a><a href="#"><i
					class="icon ion-social-snapchat"></i></a><a href="#"><i
					class="icon ion-social-twitter"></i></a><a href="#"><i
					class="icon ion-social-facebook"></i></a>
			</div>
			<ul class="list-inline">
				<li class="list-inline-item"><a href="index.html">Home</a></li>
				<li class="list-inline-item"><a href="#">Services</a></li>
				<li class="list-inline-item"><a href="#">About</a></li>
				<li class="list-inline-item"><a href="#">Terms</a></li>
				<li class="list-inline-item"><a href="#">Privacy Policy</a></li>
			</ul>
			<p class="copyright">Pick&amp;Buy Â© 2021</p>
		</footer>
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