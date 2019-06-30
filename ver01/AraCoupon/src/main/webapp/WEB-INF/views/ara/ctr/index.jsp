<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>센터 - ${info.CTR_NM}</title>
</head>
<!-- style -->
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<link rel="stylesheet" href="${staticPATH}/bootstrap3/css/bootstrap.css">
<link rel="stylesheet" href="${staticPATH}/bootstrap3/css/codingBooster5.css">
<style type="text/css">
	.jumbotron {
		background-image: url('${staticPATH}/bootstrap3/images/jumbotronBackground.jpg');
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
				<a class="navbar-brand" href="${staticPATH}/ara.do">ACSS</a>
			</div>
			<div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
				<!-- navbar menu -->
				<ul class="nav navbar-nav navbar-left">
					<li><a data-target="#modal0" data-toggle="modal" href="#" onclick="fn_console('toggle event after click event.....');">내 정보</a></li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰발행<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('${staticPATH}/ctr/coupon/apprReqListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰패키지 신청목록</a></li>
							<li><a href="javascript:fn_loadPostPage('${staticPATH}/ctr/coupon/apprResListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰패키지 승인목록</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰정산<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('${staticPATH}/ctr/calculate/calcListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;정산목록</a></li>
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
							<li><a href="${staticPATH}/ctr/login/login.do"><span class="glyphicon glyphicon-log-in"></span>&nbsp;로그인</a></li>
							<li><a href="${staticPATH}/ctr/login/register.do"><span class="glyphicon glyphicon-edit"></span>&nbsp;회원등록</a></li>
							<li><a href="${staticPATH}/ctr/login/logout.do"><span class="glyphicon glyphicon-log-out"></span>&nbsp;로그아웃</a></li>
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
	<div class="container">
		<!-- jumbotron -->
		<div class="jumbotron text-center">
			<h1>아라쿠폰서비스시스템(ACSS)을 소개합니다.</h1>
			<p>아라쿠폰서비스시스템은 여러분이 쿠폰서비스를 이용하여 많은 부가가치를 창출하기를 바라는 마음으로 ...</p>
			<p><a class="btn btn-primary btn-lg" role="button" href="javascript:fn_console('아라쿠폰서비스시스템 가기');">아라쿠폰서비스시스템 가기</a></p>
		</div>
	</div>
	<!-- gap -->
	<div style="height:70px;"></div>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- footer -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<footer class="footer-default">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 text-center">
					<h6>
						ACSS ( Ara Coupon Service System )<br>
						Copyright &copy; 2014 ~ 2018, 2019 TAIN Inc.
					</h6>
				</div>
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
						내 정보(센터)<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						<div class="panel panel-primary">
							<table class="table">
								<tbody>
									<tr>
										<td>센터번호</td>
										<td class="align-left">${info.CTR_ID}</td>
									</tr>
									<tr>
										<td>센터별명</td>
										<td>${info.CTR_NM}</td>
									</tr>
									<tr>
										<td>핸드폰번호</td>
										<td>${info.MBL_NO}</td>
									</tr>
									<tr>
										<td>전화번호</td>
										<td>${info.TEL_NO}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<img src="${staticPATH}/bootstrap3/images/steve-jobs.png" style="width:250px;">
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
						<img src="${staticPATH}/bootstrap3/images/LEGO_Logo.jpg" style="width:250px;">
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
						<img src="${staticPATH}/bootstrap3/images/JPG-logo-highres.jpg" style="width:250px;">
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- Form -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<form id='tempForm'>
		<input type='hidden' id='_ctrid' name='ctrid' value='${info.CTR_ID}' />
	</form>




</body>
<!-- script -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="${staticPATH}/bootstrap3/js/bootstrap.js"></script>
<script type="text/javascript">
	$(function() {
		if (true) console.log("step-1: $(function() {});");
		processEvent();
	});
	$(document).ready(function(){
		if (true) console.log("step-2: $(document).ready(function(){})");
	});
	function isEmpty(value) {
		if( value == "" || value == null || value == undefined || ( value != null && typeof value == "object" && !Object.keys(value).length ) ){
			return true;
		} else {
			return false;
		}
	}
	function processEvent() {
	}
	function fn_console(msg) {
		if (true) console.log(">>>>> " + msg);
	}
	function fn_loadPostPage(url) {
		$('#tempForm').attr('method', 'POST').attr('action', url).submit();
	}
</script>
</html>
