<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--
	<base href="http://arajeju.com:8080/AraCoupon/" target="_self">
	<base href="http://172.30.1.20:8080/AraCoupon/" target="_self">
	<base href="http://192.168.1.117:8080/AraCoupon/" target="_self">
	-->
	<title>거래처 - ${info.STR_NM}</title>
</head>
<!-- style -->
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<link rel="stylesheet" href="/AraCoupon/bootstrap3/css/bootstrap.css">
<link rel="stylesheet" href="/AraCoupon/bootstrap3/css/codingBooster5.css">
<style type="text/css">
	.jumbotron {
		background-image: url('/AraCoupon/bootstrap3/images/jumbotronBackground.jpg');
		background-size: cover;
		text-shadow: black 0.4em 0.4em 0.4em;
		color: white;
	}
</style>
<body>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- navigation -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/AraCoupon/str/index.do?strid=${info.STR_ID}">ACSS</a>
			</div>
			<div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
				<!-- navbar menu -->
				<ul class="nav navbar-nav navbar-left">
					<li><a data-target="#modal0" data-toggle="modal" href="#" onclick="fn_console('toggle event after click event.....');">내 정보</a></li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰발행<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/AraCoupon/str/coupon/create.do?strid=${info.STR_ID}"><span class="glyphicon glyphicon-list-all"></span>&nbsp;생성</a></li>
							<li class="divider"></li>
							<li><a href="/AraCoupon/str/coupon/approvalReq.do?strid=${info.STR_ID}"><span class="glyphicon glyphicon-list-all"></span>&nbsp;신청목록</a></li>
							<li><a href="/AraCoupon/str/coupon/approvalRes.do?strid=${info.STR_ID}"><span class="glyphicon glyphicon-list-all"></span>&nbsp;승인목록</a></li>
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
							<li><a href="/AraCoupon/str/login/login.do"><span class="glyphicon glyphicon-log-in"></span>&nbsp;로그인</a></li>
							<li><a href="/AraCoupon/str/login/register.do"><span class="glyphicon glyphicon-edit"></span>&nbsp;회원등록</a></li>
							<li><a href="/AraCoupon/str/login/logout.do"><span class="glyphicon glyphicon-log-out"></span>&nbsp;로그아웃</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- gap -->
	<div style="height:70px;"></div>



	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- container for jumbotron -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- container for panel -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;쿠폰을 만든다.</h3>
					</div>
					<div class="panel-body">
						<div class="media">
							<div class="media-left">
								<a href="#"><img class="media-object" src="/AraCoupon/bootstrap3/images/PNG.jpg" style="width:80px;"></a>
							</div>
							<div class="media-body">
								<h4>캠페인</h4>
								<div class="panel panel-primary">
									<table id="codeTable" class="table">
										<tbody>
											<tr>
												<td style="width:20%;">캠페인 명칭</td>
												<td><input type='text' style="width:90%;"></td>
											</tr>
											<tr>
												<td>캠페인 설명</td>
												<td><input type='text' style="width:90%;"></td>
											</tr>
											<tr>
												<td>캠페인 시작일</td>
												<td><input type='text' style="width:90%;"></td>
											</tr>
											<tr>
												<td>캠페인 종료일</td>
												<td><input type='text' style="width:90%;"></td>
											</tr>
										</tbody>
									</table>
								</div>
								<h4>제공오퍼</h4>
								<div class="panel panel-primary">
									<table id="codeTable" class="table">
										<tbody>
											<tr>
												<td style="width:20%;">오퍼 종류</td>
												<td><input type='text' style="width:90%;"></td>
											</tr>
											<tr>
												<td>오퍼 설명</td>
												<td><input type='text' style="width:90%;"></td>
											</tr>
											<tr>
												<td>쿠폰 명칭</td>
												<td><input type='text' style="width:90%;"></td>
											</tr>
											<tr>
												<td>쿠폰 종류</td>
												<td><input type='text' style="width:90%;"></td>
											</tr>
											<tr>
												<td>쿠폰 갯수</td>
												<td><input type='text' style="width:90%;"></td>
											</tr>
										</tbody>
									</table>
								</div>
								<h4>알림채널</h4>
								<div class="panel panel-primary">
									<table id="codeTable" class="table">
										<tbody>
											<tr>
												<td style="width:20%;">채널 종류</td>
												<td><input type='text' style="width:90%;"></td>
											</tr>
											<tr>
												<td>채널 설명</td>
												<td><input type='text' style="width:90%;"></td>
											</tr>
											<tr>
												<td>SMS 명칭</td>
												<td><input type='text' style="width:90%;"></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<blockquote>&nbsp;&nbsp;Do And Forget!!</blockquote>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- gap -->
	<div style="height:70px;"></div>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- footer -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<footer class="footer-default">
		<div class="container">
			<br>
			<div class="row">
				<div class="col-sm-12 text-center">
					<h6>
						Copyright &copy; 2014 ~ 2018, 2019 TAIN Inc.
					</h6>
				</div>
				<!--
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
				-->
			</div>
		</div>
	</footer>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- modal dialog -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="row">
		<!-- user information -->
		<div class="modal" id="modal0" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						내 정보(거래처)<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						<div class="panel panel-primary">
							<table class="table">
								<tbody>
									<tr>
										<td>거래처번호</td>
										<td class="align-left">${info.STR_ID}</td>
									</tr>
									<tr>
										<td>거래처별명</td>
										<td>${info.STR_NM}</td>
									</tr>
									<tr>
										<td>핸드폰번호</td>
										<td>${info.MBL_NO}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<img src="/AraCoupon/bootstrap3/images/steve-jobs.png" style="width:250px;">
					</div>
				</div>
			</div>
		</div>
		<div class="modal" id="modal1" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						코딩부스터의 특징<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						저희 서비스의 특징은 바로 강의를 들을 수 있다는 점입니다.<br>
						특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<br><br>
						<img src="/AraCoupon/bootstrap3/images/LEGO_Logo.jpg" style="width:250px;">
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
						<img src="/AraCoupon/bootstrap3/images/JPG-logo-highres.jpg" style="width:250px;">
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
<!-- script -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/AraCoupon/bootstrap3/js/bootstrap.js"></script>
<script type="text/javascript">
	$(function() {
		if (true) console.log("step-1: $(function() {});");
	});
	$(document).ready(function(){
		if (true) console.log("step-2: $(document).ready(function(){})");
	});
	function fn_console(msg) {
		if (true) console.log(">>>>> " + msg);
	}
	function isEmpty(value) {
		if( value == "" || value == null || value == undefined || ( value != null && typeof value == "object" && !Object.keys(value).length ) ){
			return true;
		} else {
			return false;
		}
	}
</script>
</html>
