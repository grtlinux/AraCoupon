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
					<li><a data-target="#modalUsr" data-toggle="modal" href="#" onclick="fn_clearModalUsr();">고객</a></li>
					<li><a data-target="#modalStr" data-toggle="modal" href="#" onclick="fn_clearModalStr();">가게</a></li>
					<li><a data-target="#modalCtr" data-toggle="modal" href="#" onclick="fn_clearModalCtr();">센타</a></li>
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


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- container for column -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h4>고객</h4>
				<p>저희 서비스의 특징은 아라쿠폰을 활용한 고객들의 만족을 높이는데 있습니다. 많은 참여와 다양한 서비스의 활용을 누리시기 바랍니다. 특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<p>
				<p class="text-center"><a class="btn btn-default" data-target="#modalUsr" data-toggle="modal" href="#" onclick="fn_clearModalUsr();">고객 접속</a></p>
			</div>
			<div class="col-sm-4">
				<h4>가게</h4>
				<p>저희 서비스의 특징은 아라쿠폰을 활용한 고객들의 만족을 높이는데 있습니다. 많은 참여와 다양한 서비스의 활용을 누리시기 바랍니다. 특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<p>
				<p class="text-center"><a class="btn btn-default" data-target="#modalStr" data-toggle="modal" href="#" onclick="fn_clearModalStr();">가게 접속</a></p>
			</div>
			<div class="col-sm-4">
				<h4>센터</h4>
				<p>저희 서비스의 특징은 아라쿠폰을 활용한 고객들의 만족을 높이는데 있습니다. 많은 참여와 다양한 서비스의 활용을 누리시기 바랍니다. 특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<p>
				<p class="text-center"><a class="btn btn-default" data-target="#modalCtr" data-toggle="modal" href="#" onclick="fn_clearModalCtr();">센터 접속</a></p>
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
					<div class="modal-header alert alert-success">
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
									<td class="text-left">
										<input id="usrid" type="text" value=''>
										<button id='btnRequestAraKey' type="button" class="btn btn-success btn-sm" onclick="fn_requestUsrAraKey();"> 아라키(AraKey) 요청 </button>
									</td>
								</tr>
								<tr>
									<td>아라키(Ara Key)</td>
									<td class="text-left">
										<input id="arakey" type="text" value=''>
									</td>
								</tr>
							</tbody>
						</table>
						<br>
						<button id='connectUsr' type="button" class="btn btn-danger btn-sm" onclick="fn_connectUsr();"><i class="fa fa-floppy-o" aria-hidden="true"></i> 접속 </button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<!-- store information -->
		<div class="modal" id="modalStr" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header alert alert-success">
						가게 접속<button class="close" data-dismiss="modal">&times;</button>
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
									<td>가게ID(strid)</td>
									<td class="text-left">
										<input id="strid" type="text" value=''>
										<button id='btnRequestAraKey' type="button" class="btn btn-success btn-sm" onclick="fn_requestStrAraKey();"> 아라키(AraKey) 요청 </button>
									</td>
								</tr>
								<tr>
									<td>아라키(Ara Key)</td>
									<td class="text-left">
										<input id="arakey" type="text" value=''>
									</td>
								</tr>
							</tbody>
						</table>
						<br>
						<button id='connectStr' type="button" class="btn btn-danger btn-sm" onclick="fn_connectStr();"><i class="fa fa-floppy-o" aria-hidden="true"></i> 접속 </button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<!-- center information -->
		<div class="modal" id="modalCtr" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header alert alert-success">
						센터 접속<button class="close" data-dismiss="modal">&times;</button>
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
									<td>센터ID(ctrid)</td>
									<td class="text-left">
										<input id="ctrid" type="text" value=''>
										<button id='btnRequestAraKey' type="button" class="btn btn-success btn-sm" onclick="fn_requestCtrAraKey();"> 아라키(AraKey) 요청 </button>
									</td>
								</tr>
								<tr>
									<td>아라키(Ara Key)</td>
									<td class="text-left">
										<input id="arakey" type="text" value=''>
									</td>
								</tr>
							</tbody>
						</table>
						<br>
						<button id='connectCtr' type="button" class="btn btn-danger btn-sm" onclick="fn_connectCtr();"><i class="fa fa-floppy-o" aria-hidden="true"></i> 접속 </button>
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
	<form id='requestUsrAraKeyForm'>
		<input type='hidden' id='_usrid'  name='usrid'  value='' />
	</form>
	<form id='requestStrAraKeyForm'>
		<input type='hidden' id='_strid'  name='strid'  value='' />
	</form>
	<form id='requestCtrAraKeyForm'>
		<input type='hidden' id='_ctrid'  name='ctrid'  value='' />
	</form>
	
	<form id='connectUsrForm'>
		<input type='hidden' id='_usrid'  name='usrid'  value='' />
		<input type='hidden' id='_arakey' name='arakey' value='' />
	</form>
	<form id='connectStrForm'>
		<input type='hidden' id='_strid'  name='strid'  value='' />
		<input type='hidden' id='_arakey' name='arakey' value='' />
	</form>
	<form id='connectCtrForm'>
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
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	// Usr
	function fn_clearModalUsr() {
		if (true) console.log(">>>>> fn_clearModalUsr();");
		$('#modalUsr #usrid').val('');
		$('#modalUsr #arakey').val('');
		
		$('#modalUsr #usrid').attr('disabled', false);
		$('#modalUsr #btnRequestAraKey').attr('disabled', false);
		$('#modalUsr #arakey').attr('disabled', true);
		$('#modalUsr #connectUsr').attr('disabled', true);
	}
	function fn_requestUsrAraKey() {
		if (true) console.log(">>>>> fn_requestUsrAraKey();");
		if (true) {
			// validate
			if (isEmpty($('#modalUsr #usrid').val())) {
				$('#modalUsr #usrid').focus();
				return false;
			}
		}
		if (true) {
			// transfer data
			$("#requestUsrAraKeyForm > #_usrid").val($("#modalUsr #usrid").val());
		}
		if (true) {
			if (true) console.log(">>>>> call ajax");
			// call ajax
			jQuery.ajax({
				url           : "${staticPATH}/requestUsrAraKey.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#requestUsrAraKeyForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (true) alert("[알림] " + result.retMsg);
						$('#modalUsr #usrid').attr('disabled', true);
						$('#modalUsr #btnRequestAraKey').attr('disabled', true);
						$('#modalUsr #arakey').attr('disabled', false);
						$('#modalUsr #connectUsr').attr('disabled', false);
						$('#modalUsr #arakey').focus();
					} else {
						alert("에러가 발생하였습니다. retMsg=" + result.retMsg);
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.");
				}
			});
		}
	}
	function fn_connectUsr() {
		if (true) console.log(">>>>> fn_connectUsr();");
		if (true) {
			// validate
			if (isEmpty($('#modalUsr #usrid').val())) {
				$('#modalUsr #usrid').focus();
				return false;
			}
			if (isEmpty($('#modalUsr #arakey').val())) {
				$('#modalUsr #arakey').focus();
				return false;
			}
		}
		if (true) {
			// transfer data
			$("#connectUsrForm > #_usrid").val($("#modalUsr #usrid").val());
			$("#connectUsrForm > #_arakey").val($("#modalUsr #arakey").val());
		}
		if (true) {
			// confirm connection Authentication
			jQuery.ajax({
				url           : "${staticPATH}/confirmUsr.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#connectUsrForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (true && result.retMsg == "SUCCESS") {
							// load new page
							if (true) console.log(">>>>> attr.action");
							$("#connectUsrForm").attr("action", "${staticPATH}/usr/index.do").attr("method", "POST").submit();
						} else {
							alert("retMsg=" + result.retMsg);
							$('#modalUsr').modal('toggle');
						}
					} else {
						alert("에러가 발생하였습니다. retMsg=" + result.retMsg);
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.");
				}
			});
		}
	}
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	// Str
	function fn_clearModalStr() {
		if (true) console.log(">>>>> fn_clearModalStr();");
		$('#modalStr #strid').val('');
		$('#modalStr #arakey').val('');
		
		$('#modalStr #strid').attr('disabled', false);
		$('#modalStr #btnRequestAraKey').attr('disabled', false);
		$('#modalStr #arakey').attr('disabled', true);
		$('#modalStr #connectStr').attr('disabled', true);
	}
	function fn_requestStrAraKey() {
		if (true) console.log(">>>>> fn_requestStrAraKey();");
		if (true) {
			// validate
			if (isEmpty($('#modalStr #strid').val())) {
				$('#modalStr #strid').focus();
				return false;
			}
		}
		if (true) {
			// transfer data
			$("#requestStrAraKeyForm > #_strid").val($("#modalStr #strid").val());
		}
		if (true) {
			if (true) console.log(">>>>> call ajax");
			// call ajax
			jQuery.ajax({
				url           : "${staticPATH}/requestStrAraKey.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#requestStrAraKeyForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (true) alert("[알림] " + result.retMsg);
						$('#modalStr #strid').attr('disabled', true);
						$('#modalStr #btnRequestAraKey').attr('disabled', true);
						$('#modalStr #arakey').attr('disabled', false);
						$('#modalStr #connectStr').attr('disabled', false);
						$('#modalStr #arakey').focus();
					} else {
						alert("에러가 발생하였습니다. retMsg=" + result.retMsg);
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.");
				}
			});
		}
	}
	function fn_connectStr() {
		if (true) console.log(">>>>> fn_connectStr();");
		if (true) {
			// validate
			if (isEmpty($('#modalStr #strid').val())) {
				$('#modalStr #strid').focus();
				return false;
			}
			if (isEmpty($('#modalStr #arakey').val())) {
				$('#modalStr #arakey').focus();
				return false;
			}
		}
		if (true) {
			// transfer data
			$("#connectStrForm > #_strid").val($("#modalStr #strid").val());
			$("#connectStrForm > #_arakey").val($("#modalStr #arakey").val());
		}
		if (true) {
			// confirm connection Authentication
			jQuery.ajax({
				url           : "${staticPATH}/confirmStr.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#connectStrForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (true && result.retMsg == "SUCCESS") {
							// load new page
							if (true) console.log(">>>>> attr.action");
							$("#connectStrForm").attr("action", "${staticPATH}/str/index.do").attr("method", "POST").submit();
						} else {
							alert("retMsg=" + result.retMsg);
							$('#modalStr').modal('toggle');
						}
					} else {
						alert("에러가 발생하였습니다. retMsg=" + result.retMsg);
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.");
				}
			});
		}
	}
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	// Ctr
	function fn_clearModalCtr() {
		if (true) console.log(">>>>> fn_clearModalCtr();");
		$('#modalCtr #ctrid').val('');
		$('#modalCtr #arakey').val('');
		
		$('#modalCtr #ctrid').attr('disabled', false);
		$('#modalCtr #btnRequestAraKey').attr('disabled', false);
		$('#modalCtr #arakey').attr('disabled', true);
		$('#modalCtr #connectCtr').attr('disabled', true);
	}
	function fn_requestCtrAraKey() {
		if (true) console.log(">>>>> fn_requestCtrAraKey();");
		if (true) {
			// validate
			if (isEmpty($('#modalCtr #ctrid').val())) {
				$('#modalCtr #ctrid').focus();
				return false;
			}
		}
		if (true) {
			// transfer data
			$("#requestCtrAraKeyForm > #_ctrid").val($("#modalCtr #ctrid").val());
		}
		if (true) {
			if (true) console.log(">>>>> call ajax");
			// call ajax
			jQuery.ajax({
				url           : "${staticPATH}/requestCtrAraKey.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#requestCtrAraKeyForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (true) alert("[알림] " + result.retMsg);
						$('#modalCtr #ctrid').attr('disabled', true);
						$('#modalCtr #btnRequestAraKey').attr('disabled', true);
						$('#modalCtr #arakey').attr('disabled', false);
						$('#modalCtr #connectCtr').attr('disabled', false);
						$('#modalCtr #arakey').focus();
					} else {
						alert("에러가 발생하였습니다. retMsg=" + result.retMsg);
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.");
				}
			});
		}
	}
	function fn_connectCtr() {
		if (true) console.log(">>>>> fn_connectCtr();");
		if (true) {
			// validate
			if (isEmpty($('#modalCtr #ctrid').val())) {
				$('#modalCtr #ctrid').focus();
				return false;
			}
			if (isEmpty($('#modalCtr #arakey').val())) {
				$('#modalCtr #arakey').focus();
				return false;
			}
		}
		if (true) {
			// transfer data
			$("#connectCtrForm > #_ctrid").val($("#modalCtr #ctrid").val());
			$("#connectCtrForm > #_arakey").val($("#modalCtr #arakey").val());
		}
		if (true) {
			// confirm connection Authentication
			jQuery.ajax({
				url           : "${staticPATH}/confirmCtr.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#connectCtrForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (true && result.retMsg == "SUCCESS") {
							// load new page
							if (true) console.log(">>>>> attr.action");
							$("#connectCtrForm").attr("action", "${staticPATH}/ctr/index.do").attr("method", "POST").submit();
						} else {
							alert("retMsg=" + result.retMsg);
							$('#modalCtr').modal('toggle');
						}
					} else {
						alert("에러가 발생하였습니다. retMsg=" + result.retMsg);
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.");
				}
			});
		}
	}
</script>
</html>
