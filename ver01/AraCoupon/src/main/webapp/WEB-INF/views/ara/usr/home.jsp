<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<base href="http://172.30.1.20:8080/AraCoupon/" target="_self">
	<title>고객 - 인증</title>
</head>
<!-- style -->
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<link rel="stylesheet" href="bootstrap3/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap3/css/codingBooster5.css">
<style type="text/css">
	.jumbotron {
		background-image: url('bootstrap3/images/jumbotronBackground.jpg');
		background-size: cover;
		text-shadow: black 0.4em 0.4em 0.4em;
		color: white;
	}
</style>
<body>
	<!-- navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="usr/home.do">ACSS</a>
			</div>
			<div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
				<!-- navbar menu -->
				<ul class="nav navbar-nav navbar-left">
					<li><a href="usr/info.do">내 정보</a></li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="usr/coupon/take.do"><span class="glyphicon glyphicon-list-all"></span>&nbsp;수령</a></li>
							<li><a href="usr/coupon/list.do"><span class="glyphicon glyphicon-list-all"></span>&nbsp;목록</a></li>
							<li class="divider"></li>
							<li><a href="usr/coupon/record.do"><span class="glyphicon glyphicon-list-all"></span>&nbsp;기록</a></li>
						</ul>
					</li>
					<!--
					<li><a href="/sample05/">통계</a></li>
					-->
				</ul>
				
				<!-- login menu -->
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span><span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="usr/login/login.do"><span class="glyphicon glyphicon-log-in"></span>&nbsp;로그인</a></li>
							<li><a href="usr/login/register.do"><span class="glyphicon glyphicon-edit"></span>&nbsp;회원등록</a></li>
							<li><a href="usr/login/logout.do"><span class="glyphicon glyphicon-log-out"></span>&nbsp;로그아웃</a></li>
						</ul>
					</li>
				</ul>
				
				<!-- search menu -->
				<!--
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input class="form-control" type="search" placeholder="검색내용을 입력하세요.">
					</div>
					<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
				</form>
				-->
				
			</div>
		</div>
	</nav>
	
	
	<!-- gap -->
	<div style="height:70px;"></div>
	
	
	<!-- container -->
	<div class="container">
		<!-- jumbotron -->
		<div class="jumbotron text-center">
			<h1>아라쿠폰서비스시스템(ACSS)을 소개합니다.</h1>
			<p>아라쿠폰서비스시스템은 여러분이 쿠폰서비스를 이용하여 많은 부가가치를 창출하기를 바라는 마음으로 ...</p>
			<p><a class="btn btn-primary btn-lg" role="button" href="javascript:fn_console('아라쿠폰서비스시스템 가기');">아라쿠폰서비스시스템 가기</a></p>
		</div>
		
		<!-- modal -->
		<div class="row">
			<div class="col-sm-4">
				<h4>코딩 부스터의 특징</h4>
				<p>크딩 부스터는 다른 사이트만 지원이 다른 깔끔한 구성을 보여줍니다. 모든 페이지가 사용자가 접근하고 읽기 쉽도록 정교하게 구성됩니다. 많은 강의를 들으세요.</p>
				<p class="text-center"><a class="btn btn-default" data-target="#modal1" data-toggle="modal" href="#">자세히 알아보기</a></p>
			</div>
			<div class="col-sm-4">
				<h4>폭 넓은 강사진</h4>
				<p>크딩 부스터는 다른 사이트만 지원이 다른 깔끔한 구성을 보여줍니다. 모든 페이지가 사용자가 접근하고 읽기 쉽도록 정교하게 구성됩니다. 많은 강의를 들으세요.</p>
				<p class="text-center"><a class="btn btn-default" data-target="#modal2" data-toggle="modal" href="#">자세히 알아보기</a></p>
			</div>
			<div class="col-sm-4">
				<h4>핵심적인 강의</h4>
				<p>크딩 부스터는 다른 사이트만 지원이 다른 깔끔한 구성을 보여줍니다. 모든 페이지가 사용자가 접근하고 읽기 쉽도록 정교하게 구성됩니다. 많은 강의를 들으세요.</p>
				<p><a class="btn btn-default" href="javascript:fn_console('핵심적인 강의');">자세히 알아보기</a></p>
			</div>
		</div>
		
		<!-- panel -->
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;최신 강의 목록</h3>
			</div>
			<div class="panel-body">
				<div class="media">
					<div class="media-left">
						<a href="#"><img class="media-object" src="/images/CAN.jpg" style="width:100px;" alt="강의 이미지 1"></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading"><a href="javascript:fn_console('언어 기초 프로그램');">언어 기초 프로그램</a>&nbsp;<span class="badge">New</span></h4>
						언어 강의는 기초 프로그래밍 강의ㅣㅂ니다. ㅓ음 프로그램을 접하는 입뭄자가 듣기에 적합한 강의입니다.
						강의로는 무료이며 언어 기초 프로그래밍 강좌는 총 20간으로 구성됩니다.
					</div>
				</div>
				<hr>
				<div class="media">
					<div class="media-left">
						<a href="#"><img class="media-object" src="/images/PNG.jpg" style="width:100px;" alt="강의 이미지 2"></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading"><a href="javascript:fn_console('Java 언어 기초 프로그래밍 강좌');">Java 언어 기초 프로그래밍 강좌</a>&nbsp;<span class="badge">New</span></h4>
						언어 강의는 기초 프로그래밍 강의ㅣㅂ니다. ㅓ음 프로그램을 접하는 입뭄자가 듣기에 적합한 강의입니다.
						강의로는 무료이며 언어 기초 프로그래밍 강좌는 총 20간으로 구성됩니다.<br>
						언어 강의는 기초 프로그래밍 강의ㅣㅂ니다. ㅓ음 프로그램을 접하는 입뭄자가 듣기에 적합한 강의입니다.
						강의로는 무료이며 언어 기초 프로그래밍 강좌는 총 20간으로 구성됩니다.<br>
						언어 강의는 기초 프로그래밍 강의ㅣㅂ니다. ㅓ음 프로그램을 접하는 입뭄자가 듣기에 적합한 강의입니다.
						강의로는 무료이며 언어 기초 프로그래밍 강좌는 총 20간으로 구성됩니다.
					</div>
				</div>
				<hr>
				<div class="media">
					<div class="media-left">
						<a href="#"><img class="media-object" src="/images/SQL.jpg" style="width:100px;" alt="강의 이미지 3"></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading"><a href="javascript:fn_console('Android 언어 기초 프로그래밍 강좌');">Android 언어 기초 프로그래밍 강좌</a>&nbsp;<span class="badge">New</span></h4>
						언어 강의는 기초 프로그래밍 강의ㅣㅂ니다. ㅓ음 프로그램을 접하는 입뭄자가 듣기에 적합한 강의입니다.
						강의로는 무료이며 언어 기초 프로그래밍 강좌는 총 20간으로 구성됩니다.
						The time on the server is ${serverTime}.
					</div>
				</div>
			</div>
		</div>
		
		<!-- form test -->
		search: <input class="form-control" type="search" name="search" placeholder="search">
		tel: <input class="form-control" type="tel" name="tel" placeholder="tel">
		url: <input class="form-control" type="url" name="url" placeholder="url">
		email: <input class="form-control" type="email" name="emal" placeholder="email">

		password: <input class="form-control" type="password" name="password" placeholder="password">
		datetime: <input class="form-control" type="datetime" name="datetime" placeholder="datetime">
		datetime-local: <input class="form-control" type="datetime-local" name="datetime-local" placeholder="datetime-local">
		date: <input class="form-control" type="date" name="date" placeholder="date">
		month: <input class="form-control" type="month" name="month" placeholder="month">
		week: <input class="form-control" type="week" name="week" placeholder="week">
		time: <input class="form-control" type="time" name="time" placeholder="time">
		number: <input class="form-control" type="number" name="number" placeholder="number">
		range: <input class="form-control" type="range" name="range" placeholder="range">
		color: <input class="form-control" type="color" name="color" placeholder="color">
		
		
		
		
		
		<br>
		<hr>
	</div>
	
	
	<!-- modal dialog -->
	<div class="row">
		<div class="modal" id="modal1" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						코딩부스터의 특징<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						저희 서비스의 특징은 바로 강의를 들을 수 있다는 점입니다.<br>
						특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<br><br>
						<img src="/images/LEGO_Logo.jpg" style="width:250px;">
					</div>
				</div>
			</div>
		</div>
		<div class="modal" id="modal2" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						폭넓은 강사진<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						저희 서비스의 특징은 바로 강의를 들을 수 있다는 점입니다.<br>
						특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<br><br>
						<img src="/images/JPG-logo-highres.jpg" style="width:250px;">
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<!-- footer -->
	<footer class="footer-default">
		<div class="container">
			<br>
			<div class="row">
				<div class="col-sm-2 text-center">
					<h6>
						Copyright &copy; 2019 TAIN Inc.
					</h6>
				</div>
				<div class="col-sm-4">
					<h5>소개</h5>
					<p>ACSS(Ara Coupon Service System)</p>
				</div>
				<div class="col-sm-2">
					<h5>네비게이션</h5>
					<div class="list-group">
						<a class="list-group-item" href="/sample05/">소개</a>
						<a class="list-group-item" href="/sample05/instructor">강사진</a>
						<a class="list-group-item" href="/sample05/lecture">강의</a>
					</div>
				</div>
				<div class="col-sm-2">
					<h5>SNS</h5>
					<div class="list-group">
						<a class="list-group-item" href="javascript:fn_console('facebook');">facebook</a>
						<a class="list-group-item" href="javascript:fn_console('YouTube');">YouTube</a>
						<a class="list-group-item" href="javascript:fn_console('Naver');">Naver</a>
					</div>
				</div>
				<div class="col-sm-2">
					<h5><span class="glyphicon glyphicon-ok"></span>&nbsp;&nbsp;by TAIN Inc.</h5>
				</div>
			</div>
		</div>
	</footer>
	
	
</body>
<!-- script -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="bootstrap3/js/bootstrap.js"></script>
<script type="text/javascript">
	$(function() {
		if (true) console.log("step-1: $(function() {});");
	});
	$(document).ready(function(){
		if (true) console.log("step-2: $(document).ready(function(){})");
	});
</script>
</html>
