<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<!-- Theme Made By www.w3schools.com - No Copyright -->
	<title>Bootstrap Theme The Band</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
	<link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<style type="text/css">
		body {
			font: 400 15px/1.8 Lato, sans-serif;
			color: #777;
			background: gray;
		}
		h3, h4 {
			margin: 10px 0 30px 0;
			letter-spacing: 10px;
			font-size: 20px;
			color: #111;
		}
		.container {
			padding: 80px 120px;
		}
		.person {
			border: 10px solid transparent;
			margin-bottom: 25px;
			width: 80%;
			height: 80%;
			opacity: 0.7;
		}
		.person:hover {
			border-color: #f1f1f1;
		}
		.carousel-inner img {
			-webkit-filter: grayscale(0%);
			filter: grayscale(0%); /* make all photos black and white */
			width: 100%; /* Set width to 100% */
			margin: auto;
		}
		.carousel-caption h3 {
			color: #fff !important;
		}
		@media (max-width: 600px) {
			.carousel-caption {
				display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
			}
		}
		.bg-1 {
			background: #2d2d30;
			color: #bdbdbd;
		}
		.bg-1 h3 {color: #fff;}
		.bg-1 p {font-style: italic;}
		.list-group-item:first-child {
			border-top-right-radius: 0;
			border-top-left-radius: 0;
		}
		.list-group-item:last-child {
			border-bottom-right-radius: 0;
			border-bottom-left-radius: 0;
		}
		.thumbnail {
			padding: 0 0 15px 0;
			border: none;
			border-radius: 0;
			box-shadow: 2px 3px 10px rgba(0,0,0, .9);
			/*
			box-shadow: 5px 5px 10px rgba(0,0,0, .2);
			*/
		}
		.thumbnail p {
			margin-top: 15px;
			color: #555;
		}
		.btn {
			padding: 10px 20px;
			background-color: #333;
			color: #f1f1f1;
			border-radius: 0;
			transition: .2s;
		}
		.btn:hover, .btn:focus {
			border: 1px solid #333;
			background-color: #fff;
			color: #000;
		}
		.modal-header, h4, .close {
			background-color: #333;
			color: #fff !important;
			text-align: center;
			font-size: 30px;
		}
		.modal-header, .modal-body {
			padding: 40px 50px;
		}
		.nav-tabs li a {
			color: #777;
		}
		#googleMap {
			width: 100%;
			height: 400px;
			-webkit-filter: grayscale(100%);
			filter: grayscale(100%);
		}
		.navbar {
			font-family: Montserrat, sans-serif;
			margin-bottom: 0;
			background-color: #2d2d30;
			border: 0;
			font-size: 11px !important;
			letter-spacing: 4px;
			opacity: 0.8;
		}
		.navbar li a, .navbar .navbar-brand {
			color: #d5d5d5 !important;
		}
		.navbar-nav li a:hover {
			color: #fff !important;
		}
		.navbar-nav li.active a {
			color: #fff !important;
			background-color: #29292c !important;
		}
		.navbar-default .navbar-toggle {
			border-color: transparent;
		}
		.open .dropdown-toggle {
			color: #fff;
			background-color: #555 !important;
		}
		.dropdown-menu li a {
			color: #000 !important;
		}
		.dropdown-menu li a:hover {
			background-color: red !important;
		}
		footer {
			background-color: #2d2d30;
			color: #f5f5f5;
			padding: 32px;
		}
		footer a {
			color: #f5f5f5;
		}
		footer a:hover {
			color: #777;
			text-decoration: none;
		}
		.form-control {
			border-radius: 0;
		}
		textarea {
			resize: none;
		}
	</style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- navbar -->
<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<!-- 
			<a class="navbar-brand" href="#myPage">Logo</a>
			 -->
			<a class="navbar-brand" href="#myPage"><span class="glyphicon glyphicon-barcode" style="font-size:30px;color:lightblue;text-shadow:4px 5px 6px #000000;"></span></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#myPage">HOME</a></li>
				<li><a href="#band">BAND</a></li>
				<li><a href="#tour">TOUR</a></li>
				<li><a href="#contact">CONTACT</a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Merchandise</a></li>
						<li><a href="#">Extras</a></li>
						<li><a href="#">Media</a></li>
					</ul>
				</li>
				<li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
			</ul>
		</div>
	</div>
</nav>

<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- carousel -->
<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
		<li data-target="#myCarousel" data-slide-to="3"></li>
		<li data-target="#myCarousel" data-slide-to="4"></li>
		<li data-target="#myCarousel" data-slide-to="5"></li>
		<li data-target="#myCarousel" data-slide-to="6"></li>
		<li data-target="#myCarousel" data-slide-to="7"></li>
		<li data-target="#myCarousel" data-slide-to="8"></li>
		<li data-target="#myCarousel" data-slide-to="9"></li>
		<li data-target="#myCarousel" data-slide-to="10"></li>
		<li data-target="#myCarousel" data-slide-to="11"></li>
		<li data-target="#myCarousel" data-slide-to="12"></li>
		<li data-target="#myCarousel" data-slide-to="13"></li>
		<li data-target="#myCarousel" data-slide-to="14"></li>
		<li data-target="#myCarousel" data-slide-to="15"></li>
		<li data-target="#myCarousel" data-slide-to="16"></li>
		<li data-target="#myCarousel" data-slide-to="17"></li>
		<li data-target="#myCarousel" data-slide-to="18"></li>
		<li data-target="#myCarousel" data-slide-to="19"></li>
		<li data-target="#myCarousel" data-slide-to="20"></li>
		<li data-target="#myCarousel" data-slide-to="21"></li>
	</ol>
	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<!--
			<img src="/bootstrap3/images/carousel/slide0.jpg" alt="Slide 0" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_00.jpg" alt="Slide 0" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 0</h3>
				<p>The atmosphere in New York is lorem ipsum.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/slide1.jpg" alt="Slide 1" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_01.jpg" alt="Slide 1" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 1</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/slide2.jpg" alt="Slide 2" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_02.jpg" alt="Slide 2" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 2</h3>
				<p>Even though the traffic was a mess, we had the best time playing at Venice Beach!</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/slide3.jpg" alt="Slide 3" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_03.jpg" alt="Slide 3" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 3</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/slide4.jpg" alt="Slide 4" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_04.jpg" alt="Slide 4" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 4</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/slide5.jpg" alt="Slide 5" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_05.jpg" alt="Slide 5" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 5</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/slide6.jpg" alt="Slide 6" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_06.jpg" alt="Slide 6" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 6</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/slide7.jpg" alt="Slide 7" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_07.jpg" alt="Slide 7" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 7</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/slide8.jpg" alt="Slide 8" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_08.jpg" alt="Slide 8" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 8</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>



		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/coffee1.jpg" alt="Slide 9" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_09.jpg" alt="Slide 9" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 9</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/coffee2.jpg" alt="Slide 10" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_10.jpg" alt="Slide 10" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 10</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/coffee3.jpg" alt="Slide 11" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_11.jpg" alt="Slide 11" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 11</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>



		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/computer01.jpg" alt="Slide 12" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_12.jpg" alt="Slide 12" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 12</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/computer02.jpg" alt="Slide 13" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_13.jpg" alt="Slide 13" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 13</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>



		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/jeju_01.jpg" alt="Slide 14" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_14.jpg" alt="Slide 14" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 14</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/jeju_02.jpg" alt="Slide 15" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_15.jpg" alt="Slide 15" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 15</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/jeju_03.jpg" alt="Slide 16" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_16.jpg" alt="Slide 16" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 16</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>



		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/main_01.jpg" alt="Slide 17" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_17.jpg" alt="Slide 17" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 17</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/main_02.jpg" alt="Slide 18" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_18.jpg" alt="Slide 18" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 18</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>



		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/sunrise_01.jpg" alt="Slide 19" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_19.jpg" alt="Slide 19" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 19</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/sunrise_02.jpg" alt="Slide 20" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_20.jpg" alt="Slide 20" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 20</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
		<div class="item">
			<!--
			<img src="/bootstrap3/images/carousel/sunrise_03.jpg" alt="Slide 21" width="1200" height="400">
			-->
			<img src="/bootstrap3/images/carousel/carousel_21.jpg" alt="Slide 21" width="1200" height="400">
			<div class="carousel-caption">
				<h3>Slide 21</h3>
				<p>Thank you, Chicago - A night we won't forget.</p>
			</div>
		</div>
	</div>
	<!-- Left and right controls -->
	<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		<span class="sr-only">Previous</span>
	</a>
	<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		<span class="sr-only">Next</span>
	</a>
</div>
<script type="text/javascript">
	/* carousel interval control */
	$('.carousel').carousel({interval:2000});
</script>

<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- card -->
<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- Container (The Band Section) -->
<div id="band" class="container-fluid text-center">
	<!-- 광고
	<h3>THE BAND</h3>
	<p><em>We love music!</em></p>
	<p>We have created a fictional band website. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
	<br>
	-->
	<div class="row">
		<div class="col-sm-4">
			<div class="thumbnail">
				<p class="text-center"><strong>광고-1</strong></p><br>
				<a href="#demo" data-toggle="collapse">
					<img src="/bootstrap3/images/bandmember.jpg" class="img-rounded person" alt="Random Name" width="255" height="255">
				</a>
				<div id="demo" class="collapse">
					<p>Guitarist and Lead Vocalist</p>
					<p>Loves long walks on the beach</p>
					<p>Member since 1988</p>
					<button class="btn" data-toggle="modal" data-target="#myModal">Buy Tickets</button>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="thumbnail">
				<p class="text-center"><strong>광고-2</strong></p><br>
				<a href="#demo2" data-toggle="collapse">
					<img src="/bootstrap3/images/bandmember.jpg" class="img-rounded person" alt="Random Name" width="255" height="255">
				</a>
				<div id="demo2" class="collapse">
					<p>Drummer</p>
					<p>Loves drummin'</p>
					<p>Member since 1988</p>
					<button class="btn" data-toggle="modal" data-target="#myModal">Buy Tickets</button>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<div class="thumbnail">
				<p class="text-center"><strong>광고-3</strong></p><br>
				<a href="#demo3" data-toggle="collapse">
					<img src="/bootstrap3/images/bandmember.jpg" class="img-circle person" alt="Random Name" width="255" height="255">
				</a>
				<div id="demo3" class="collapse">
					<p>Bass player</p>
					<p>Loves math</p>
					<p>Member since 2005</p>
					<button class="btn" data-toggle="modal" data-target="#myModal">Buy Tickets</button>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- list group and modal -->
<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- Container (TOUR Section) -->
<div id="tour" class="bg-1">
	<div class="container-fluid">
		<h3 class="text-center">TOUR DATES</h3>
		<p class="text-center">Lorem ipsum we'll play you some music.<br> Remember to book your tickets!</p>
		<ul class="list-group">
			<li class="list-group-item">September <span class="label label-danger">Sold Out!</span></li>
			<li class="list-group-item">October <span class="label label-danger">Sold Out!</span></li>
			<li class="list-group-item">November <span class="badge">3</span></li>
		</ul>
		<div class="row text-center">
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="/bootstrap3/images/paris.jpg" alt="Paris" width="400" height="300">
					<p><strong>Paris</strong></p>
					<p>Friday 27 November 2015</p>
					<button class="btn" data-toggle="modal" data-target="#myModal">Buy Tickets</button>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="/bootstrap3/images/newyork.jpg" alt="New York" width="400" height="300">
					<p><strong>New York</strong></p>
					<p>Saturday 28 November 2015</p>
					<button class="btn" data-toggle="modal" data-target="#myModal">Buy Tickets</button>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="/bootstrap3/images/sanfran.jpg" alt="San Francisco" width="400" height="300">
					<p><strong>San Francisco</strong></p>
					<p>Sunday 29 November 2015</p>
					<button class="btn" data-toggle="modal" data-target="#myModal">Buy Tickets</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h4><span class="glyphicon glyphicon-lock"></span> Tickets</h4>
				</div>
				<div class="modal-body">
					<form role="form">
						<div class="form-group">
							<label for="psw"><span class="glyphicon glyphicon-shopping-cart"></span> Tickets, $23 per person</label>
							<input type="number" class="form-control" id="psw" placeholder="How many?">
						</div>
						<div class="form-group">
							<label for="usrname"><span class="glyphicon glyphicon-user"></span> Send To</label>
							<input type="text" class="form-control" id="usrname" placeholder="Enter email">
						</div>
							<button type="submit" class="btn btn-block">Pay<span class="glyphicon glyphicon-ok"></span></button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;Cancel</button>
					<p>Need <a href="#">help?</a></p>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- contact nav-tabs -->
<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- Container (Contact Section) -->
<div id="contact" class="container-fluid">
	<h3 class="text-center">Contact</h3>
	<p class="text-center"><em>We love our fans!</em></p>
	<div class="row">
		<div class="col-md-4">
			<p>Fan? Drop a note.</p>
			<p><span class="glyphicon glyphicon-map-marker"></span>Chicago, US</p>
			<p><span class="glyphicon glyphicon-phone"></span>Phone: +00 1515151515</p>
			<p><span class="glyphicon glyphicon-envelope"></span>Email: mail@mail.com</p>
		</div>
		<div class="col-md-8">
			<div class="row">
				<div class="col-sm-6 form-group">
					<input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
				</div>
				<div class="col-sm-6 form-group">
					<input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
				</div>
			</div>
			<textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea>
			<br>
			<div class="row">
				<div class="col-md-12 form-group">
					<button class="btn pull-right" type="submit">Send</button>
				</div>
			</div>
		</div>
	</div>
	<br>
	<h3 class="text-center">From The Blog</h3>
	<ul class="nav nav-tabs">
		<li class="active"><a data-toggle="tab" href="#home">Mike</a></li>
		<li><a data-toggle="tab" href="#menu1">Chandler</a></li>
		<li><a data-toggle="tab" href="#menu2">Peter</a></li>
	</ul>
	<div class="tab-content">
		<div id="home" class="tab-pane fade in active">
			<h2>Mike Ross, Manager</h2>
			<p>Man, we've been on the road for some time now. Looking forward to lorem ipsum.</p>
		</div>
		<div id="menu1" class="tab-pane fade">
			<h2>Chandler Bing, Guitarist</h2>
			<p>Always a pleasure people! Hope you enjoyed it as much as I did. Could I BE.. any more pleased?</p>
		</div>
		<div id="menu2" class="tab-pane fade">
			<h2>Peter Griffin, Bass player</h2>
			<p>I mean, sometimes I enjoy the show, but other times I enjoy other things.</p>
		</div>
	</div>
</div>

<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- map -->
<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- Image of location/map -->
<img src="/bootstrap3/images/map.jpg" class="img-responsive" style="width:100%">

<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- footer -->
<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- Footer -->
<footer class="text-center">
	<a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
		<span class="glyphicon glyphicon-chevron-up"></span>
	</a>
	<br><br>
	<p>Bootstrap Theme Made By <a href="https://www.w3schools.com" data-toggle="tooltip" title="Visit w3schools">www.w3schools.com</a></p>
</footer>

</body>
<script type="text/javascript">
	$(document).ready(function(){
		// Initialize Tooltip
		$('[data-toggle="tooltip"]').tooltip();
		// Add smooth scrolling to all links in navbar + footer link
		$(".navbar a, footer a[href='#myPage']").on('click', function(event) {
			// Make sure this.hash has a value before overriding default behavior
			if (this.hash !== "") {
				// Prevent default anchor click behavior
				event.preventDefault();
				// Store hash
				var hash = this.hash;
				// Using jQuery's animate() method to add smooth page scroll
				// The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
				$('html, body').animate({
					scrollTop: $(hash).offset().top
				}, 1200, function(){
					// Add hash (#) to URL when done scrolling (default click behavior)
					window.location.hash = hash;
				});
			} // End if
		});
	})
</script>
</html>
