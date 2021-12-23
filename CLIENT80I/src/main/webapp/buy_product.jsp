<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  Very important for error pages -->
<%@ page isErrorPage="false"%>
<%@ page import="domains.User" %>
<%@ page import="domains.Product" %>
<%
	User client = (User) session.getAttribute("user");
		Product product = (Product) request.getAttribute("buy_product");
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>pickandbuy - buy product</title>
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
	</section><div class="container py-5">

  <div class="row">
    <div class="col-lg-7 mx-auto">
      <div class="bg-white rounded-lg shadow-sm p-5">
        <!-- Credit card form tabs -->
        <ul role="tablist" class="nav bg-light nav-pills rounded-pill nav-fill mb-3">
          <li class="nav-item">
            <a data-toggle="pill" href="#nav-tab-card" class="nav-link active rounded-pill">
                                <i class="fa fa-credit-card"></i>
                                Credit Card
                            </a>
          </li>
          <li class="nav-item">
            <a data-toggle="pill" href="#nav-tab-bank" class="nav-link rounded-pill">
                                <i class="fa fa-university"></i>
                                 Bank Transfer
                             </a>
          </li>
        </ul>
        <!-- End -->


        <!-- Credit card form content -->
        <div class="tab-content">

          <!-- credit card info-->
          <div id="nav-tab-card" class="tab-pane fade show active">
            <form method="post" action="process_payment?id_product=<%out.print(product.getId_product());%>">
              <div class="form-group">
                <label for="username">Full name (on the card)</label>
                <input type="text" name="username" placeholder="Jeff Doe" required class="form-control">
              </div>
              <div class="form-group">
                <label for="cardNumber">Card number</label>
                <div class="input-group">
                  <input type="text" name="cardNumber" placeholder="Your card number" class="form-control" required>
                  <div class="input-group-append">
                    <span class="input-group-text text-muted">
                                                <i class="fa fa-cc-visa mx-1"></i>
                                                <i class="fa fa-cc-amex mx-1"></i>
                                                <i class="fa fa-cc-mastercard mx-1"></i>
                                            </span>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-sm-8">
                  <div class="form-group">
                    <label><span class="hidden-xs">Expiration</span></label>
                    <div class="input-group">
                      <input type="number" placeholder="MM" name="" class="form-control" required>
                      <input type="number" placeholder="YY" name="" class="form-control" required>
                    </div>
                  </div>
                </div>
                <div class="col-sm-4">
                  <div class="form-group mb-4">
                    <label data-toggle="tooltip" title="Three-digits code on the back of your card">CVV
                                                <i class="fa fa-question-circle"></i>
                                            </label>
                    <input type="text" required class="form-control" name="cvv">
                  </div>
                </div>



              </div>
              <button type="submit" class="btn btn-primary btn-block rounded-pill shadow-sm"> Confirm  </button>
            </form>
          </div>
          <!-- End -->

          <!-- Paypal info -->
          <div id="nav-tab-paypal" class="tab-pane fade">
            <p>Paypal is easiest way to pay online</p>
            <p>
              <button type="button" class="btn btn-primary rounded-pill"><i class="fa fa-paypal mr-2"></i> Log into my Paypal</button>
            </p>
            <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
            </p>
          </div>
          <!-- End -->

          <!-- bank transfer info -->
          <div id="nav-tab-bank" class="tab-pane fade">
            <h6>Bank account details</h6>
            <dl>
              <dt>Bank</dt>
              <dd> THE WORLD BANK</dd>
            </dl>
            <dl>
              <dt>Account number</dt>
              <dd>7775877975</dd>
            </dl>
            <dl>
              <dt>IBAN</dt>
              <dd>CZ7775877975656</dd>
            </dl>
            <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
            </p>
          </div>
          <!-- End -->
        </div>
        <!-- End -->

      </div>
    </div>
  </div>
</div>

    <div class="footer-basic">
        <footer>
            <div class="social"><a href="#"><i class="icon ion-social-instagram"></i></a><a href="#"><i class="icon ion-social-snapchat"></i></a><a href="#"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-facebook"></i></a></div>
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
    <script src="assets/js/Bootstrap-4---Payment-Form.js"></script>
    <script src="assets/js/Navbar---Apple.js"></script>
    <script src="assets/js/Profile-Edit-Form.js"></script>
</body>

</html>