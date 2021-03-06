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
<link rel="stylesheet" href="${staticPATH}/bootstrap3/css/ara.codingBooster5.v01.css">
<link rel="stylesheet" href="${staticPATH}/bootstrap3/css/ara.jumbotron.v01.css">
<body>


<%@ include file="/WEB-INF/views/ara/common/_navbarAra.jsp"%>
<%@ include file="/WEB-INF/views/ara/common/_jumbotron.jsp"%>


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


<%@ include file="/WEB-INF/views/ara/common/_footer.jsp"%>


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
									<td>고객키</td>
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
						<button id='btnConnectUsr' type="button" class="btn btn-danger btn-sm" onclick="fn_connectUsr();"> 접속 </button>
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
						<button id='btnConnectStr' type="button" class="btn btn-danger btn-sm" onclick="fn_connectStr();"> 접속 </button>
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
						<button id='btnConnectCtr' type="button" class="btn btn-danger btn-sm" onclick="fn_connectCtr();"> 접속 </button>
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
	<form id='tempUsrForm'>
		<input type='hidden' id='_usrid'  name='usrid'  value='' />
		<input type='hidden' id='_arakey' name='arakey' value='' />
	</form>
	<form id='tempStrForm'>
		<input type='hidden' id='_strid'  name='strid'  value='' />
		<input type='hidden' id='_arakey' name='arakey' value='' />
	</form>
	<form id='tempCtrForm'>
		<input type='hidden' id='_ctrid'  name='ctrid'  value='' />
		<input type='hidden' id='_arakey' name='arakey' value='' />
	</form>




</body>
<!-- script -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="${staticPATH}/bootstrap3/js/bootstrap.js"></script>
<script src="${staticPATH}/bootstrap3/js/ara.common.v01.js"></script>
<script type="text/javascript">
	$(function() {
		if (true) console.log("step-1: $(function() {});");
	});
	$(document).ready(function(){
		if (true) console.log("step-2: $(document).ready(function(){})");
	});
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	// Usr
	function fn_clearModalUsr() {
		if (true) console.log(">>>>> fn_clearModalUsr();");
		$('#modalUsr #usrid').val('').attr('disabled', false);
		$('#modalUsr #btnRequestAraKey').attr('disabled', false);
		$('#modalUsr #arakey').val('').attr('disabled', true);
		$('#modalUsr #btnConnectUsr').attr('disabled', true);
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
			$("#tempUsrForm > #_usrid").val($("#modalUsr #usrid").val());
		}
		if (true) {
			if (true) console.log(">>>>> call ajax");
			// call ajax
			jQuery.ajax({
				url           : "${staticPATH}/ara/requestUsrAraKey.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#tempUsrForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (result.retCode == "0000") {
							if (!true) alert("[알림] " + result.retMsg);
							$('#modalUsr #usrid').attr('disabled', true);
							$('#modalUsr #btnRequestAraKey').attr('disabled', true);
							$('#modalUsr #arakey').attr('disabled', false);
							$('#modalUsr #btnConnectUsr').attr('disabled', false);
							$('#modalUsr #arakey').focus();
						} else {
							alert("에러메시지: " + result.retMsg);
						}
					} else {
						alert("에러가 발생하였습니다.(1)");
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.(9)");
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
			$("#tempUsrForm > #_usrid").val($("#modalUsr #usrid").val());
			$("#tempUsrForm > #_arakey").val($("#modalUsr #arakey").val());
		}
		if (true) {
			// confirm connection Authentication
			jQuery.ajax({
				url           : "${staticPATH}/ara/confirmUsr.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#tempUsrForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (result.retCode == "0000") {
							fn_loadPostPage("#tempUsrForm", "${staticPATH}/usr/index.do");
						} else {
							alert("에러메시지: " + result.retMsg);
							fn_modalToggle('#modalUsr');
						}
					} else {
						alert("에러가 발생하였습니다.(1)");
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.(9)");
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
		$('#modalStr #strid').val('').attr('disabled', false);
		$('#modalStr #btnRequestAraKey').attr('disabled', false);
		$('#modalStr #arakey').val('').attr('disabled', true);
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
			$("#tempStrForm > #_strid").val($("#modalStr #strid").val());
		}
		if (true) {
			if (true) console.log(">>>>> call ajax");
			// call ajax
			jQuery.ajax({
				url           : "${staticPATH}/ara/requestStrAraKey.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#tempStrForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (result.retCode == "0000") {
							if (!true) alert("[알림] " + result.retMsg);
							$('#modalStr #strid').attr('disabled', true);
							$('#modalStr #btnRequestAraKey').attr('disabled', true);
							$('#modalStr #arakey').attr('disabled', false);
							$('#modalStr #btnConnectStr').attr('disabled', false);
							$('#modalStr #arakey').focus();
						} else {
							alert("에러메시지: " + result.retMsg);
						}
					} else {
						alert("에러가 발생하였습니다.(1)");
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.(9)");
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
			$("#tempStrForm > #_strid").val($("#modalStr #strid").val());
			$("#tempStrForm > #_arakey").val($("#modalStr #arakey").val());
		}
		if (true) {
			// confirm connection Authentication
			jQuery.ajax({
				url           : "${staticPATH}/ara/confirmStr.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#tempStrForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (result.retCode == "0000") {
							fn_loadPostPage("#tempStrForm", "${staticPATH}/str/index.do");
						} else {
							alert("에러메시지: " + result.retMsg);
							fn_modalToggle('#modalStr');
						}
					} else {
						alert("에러가 발생하였습니다.(1)");
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.(9)");
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
		$('#modalCtr #ctrid').val('').attr('disabled', false);
		$('#modalCtr #btnRequestAraKey').attr('disabled', false);
		$('#modalCtr #arakey').val('').attr('disabled', true);
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
			$("#tempCtrForm > #_ctrid").val($("#modalCtr #ctrid").val());
		}
		if (true) {
			if (true) console.log(">>>>> call ajax");
			// call ajax
			jQuery.ajax({
				url           : "${staticPATH}/ara/requestCtrAraKey.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#tempCtrForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (result.retCode == "0000") {
							if (!true) alert("[알림] " + result.retMsg);
							$('#modalCtr #ctrid').attr('disabled', true);
							$('#modalCtr #btnRequestAraKey').attr('disabled', true);
							$('#modalCtr #arakey').attr('disabled', false);
							$('#modalCtr #btnConnectCtr').attr('disabled', false);
							$('#modalCtr #arakey').focus();
						} else {
							alert("에러메시지: " + result.retMsg);
						}
					} else {
						alert("에러가 발생하였습니다.(1)");
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.(9)");
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
			$("#tempCtrForm > #_ctrid").val($("#modalCtr #ctrid").val());
			$("#tempCtrForm > #_arakey").val($("#modalCtr #arakey").val());
		}
		if (true) {
			// confirm connection Authentication
			jQuery.ajax({
				url           : "${staticPATH}/ara/confirmCtr.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#tempCtrForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (result.retCode == "0000") {
							fn_loadPostPage("#tempCtrForm", "${staticPATH}/ctr/index.do");
							$("#connectCtrForm").attr("action", "${staticPATH}/ctr/index.do").attr("method", "POST").submit();
						} else {
							alert("에러메시지: " + result.retMsg);
							fn_modalToggle('#modalCtr');
						}
					} else {
						alert("에러가 발생하였습니다.(1)");
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.(9)");
				}
			});
		}
	}
</script>
</html>
