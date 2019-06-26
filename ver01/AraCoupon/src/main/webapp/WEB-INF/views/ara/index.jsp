<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ara Main</title>
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
					<li><a data-target="#modalUsr" data-toggle="modal" href="#" onclick="fn_console('ara usr click');">고객</a></li>
					<li><a data-target="#modalStr" data-toggle="modal" href="#" onclick="fn_console('ara str click');">가게</a></li>
					<li><a data-target="#modalCtr" data-toggle="modal" href="#" onclick="fn_console('ara ctr click');">센타</a></li>
				</ul>
				<!-- login menu -->
				<!--
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span><span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${staticPATH}/usr/login/login.do"><span class="glyphicon glyphicon-log-in"></span>&nbsp;로그인</a></li>
							<li><a href="${staticPATH}/usr/login/register.do"><span class="glyphicon glyphicon-edit"></span>&nbsp;회원등록</a></li>
							<li><a href="${staticPATH}/usr/login/logout.do"><span class="glyphicon glyphicon-log-out"></span>&nbsp;로그아웃</a></li>
						</ul>
					</li>
				</ul>
				-->
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


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- container for column -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h4>고객</h4>
				<p>저희 서비스의 특징은 아라쿠폰을 활용한 고객들의 만족을 높이는데 있습니다. 많은 참여와 다양한 서비스의 활용을 누리시기 바랍니다. 특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<p>
				<p class="text-center"><a class="btn btn-default" data-target="#modalUsr" data-toggle="modal" href="#">고객 접속</a></p>
			</div>
			<div class="col-sm-4">
				<h4>가게</h4>
				<p>저희 서비스의 특징은 아라쿠폰을 활용한 고객들의 만족을 높이는데 있습니다. 많은 참여와 다양한 서비스의 활용을 누리시기 바랍니다. 특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<p>
				<p class="text-center"><a class="btn btn-default" data-target="#modalStr" data-toggle="modal" href="#">가게 접속</a></p>
			</div>
			<div class="col-sm-4">
				<h4>센터</h4>
				<p>저희 서비스의 특징은 아라쿠폰을 활용한 고객들의 만족을 높이는데 있습니다. 많은 참여와 다양한 서비스의 활용을 누리시기 바랍니다. 특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<p>
				<p class="text-center"><a class="btn btn-default" data-target="#modalCtr" data-toggle="modal" href="#">센터 접속</a></p>
			</div>
		</div>
	</div>


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
		<div class="modal" id="modalUsr" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						고객 접속<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						저희 서비스의 특징은 아라쿠폰을 활용한 고객들의 만족을 높이는데 있습니다.<br>
						많은 참여와 다양한 서비스의 활용을 누리시기 바랍니다.<br>
						특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<br><br>
						<img src="${staticPATH}/bootstrap3/images/LEGO_Logo.jpg" style="width:150px;">
						<br><br>
						<table class="table">
							<tbody>
								<tr>
									<td>고객ID(usrid)</td>
									<td><input id="usrid" type="text" name="usrid" value='2'></td>
								</tr>
								<tr>
									<td>아라키(Ara Key)</td>
									<td><input id="arakey" type="text" name="arakey" value='123456'></td>
								</tr>
							</tbody>
						</table>
						<br>
						<button type="button" class="btn btn-danger btn-sm" onclick="fn_connectUsr();"><i class="fa fa-floppy-o" aria-hidden="true"></i> 접속 </button>
						<!--
						<button type="button" class="btn btn-success btn-sm" onclick="fn_close();"><i class="fa fa-times" aria-hidden="true"></i> 닫기</button>
						-->
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- all of forms -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<form id='connectUsrForm' name='connectUsrForm'>
		<input type='hidden' id='_usrid'  name='usrid'  value='' />
		<input type='hidden' id='_arakey' name='arakey' value='' />
	</form>
	<form id='connectStrForm' name='connectStrForm' method='POST'>
		<input type='hidden' id='_strid'  name='strid'  value='' />
		<input type='hidden' id='_arakey' name='arakey' value='' />
	</form>
	<form id='connectCtrForm' name='connectCtrForm' method='POST'>
		<input type='hidden' id='_ctrid'  name='ctrid'  value='' />
		<input type='hidden' id='_arakey' name='arakey' value='' />
	</form>




</body>
<!-- script -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="${staticPATH}/bootstrap3/js/bootstrap.js"></script>
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
	function fn_connectUsr() {
		if (true) console.log(">>>>> fn_connectUsr();");
		if (true) {
			// validate
			if (isEmpty($('#usrid').val())) {
				$('#usrid').focus();
				return false;
			}
			if (isEmpty($('#arakey').val())) {
				$('#arakey').focus();
				return false;
			}
		}
		if (true) {
			// transfer data
			$("#_usrid").val($("#usrid").val());
			$("#_arakey").val($("#arakey").val());
		}
		if (!true) {
			if (true) console.log(">>>>> call ajax");
			// call ajax
			jQuery.ajax({
				url           : "${staticPATH}/araUsr.do",
				//dataType      : "JSON",
				dataType      : "html",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#connectUsrForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						alert("발송하였습니다. RET=" + result.RET);
					} else {
						alert("에러가 발생하였습니다. RET=" + result.RET);
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.");
				}
			});
		}
		if (!true) {
			if (true) console.log(">>>>> call submit");
			$('#connectUsrForm').submit(function(evt) {
				evt.preventDefault();
				$(this).attr('action', "${staticPATH}/usr/index.do?usrid=2");
				var data = $(this).serialize();
				$.post("${staticPATH}/usr/index.do?usrid=2", data).done(function(data) {
					console.log( data );
				});
			});
		}
		if (!true) {
			if (true) console.log(">>>>> location");
			window.location = "${staticPATH}/usr/index.do?usrid=2";
		}
		if (true) {
			if (true) console.log(">>>>> attr.action");
			$("#connectUsrForm").attr("action", "${staticPATH}/usr/index.do").attr("method", "POST").submit();
		}
	}
</script>
</html>
