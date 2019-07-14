<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ara Main</title>
</head>
<%@ include file="/WEB-INF/views/ara2/common/cssAra.jsp"%>
<body>
<%@ include file="/WEB-INF/views/ara2/common/navbarAra.jsp"%>
<%@ include file="/WEB-INF/views/ara2/common/jumbotron.jsp"%>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- container for column -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h4>아라</h4>
				<p>저희 서비스의 특징은 아라쿠폰을 활용한 고객들의 만족을 높이는데 있습니다. 많은 참여와 다양한 서비스의 활용을 누리시기 바랍니다. 특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<p>
				<p class="text-center"><a class="btn btn-default" data-target="#modalAra" data-toggle="modal" href="#" onclick="fn_clearModalAra('ARA');">아라 접속</a></p>
			</div>
			<div class="col-sm-4">
				<h4>고객</h4>
				<p>저희 서비스의 특징은 아라쿠폰을 활용한 고객들의 만족을 높이는데 있습니다. 많은 참여와 다양한 서비스의 활용을 누리시기 바랍니다. 특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<p>
				<p class="text-center"><a class="btn btn-default" data-target="#modalUsr" data-toggle="modal" href="#" onclick="fn_clearModalAra('USR');">고객 접속</a></p>
			</div>
			<div class="col-sm-4">
				<h4>가게</h4>
				<p>저희 서비스의 특징은 아라쿠폰을 활용한 고객들의 만족을 높이는데 있습니다. 많은 참여와 다양한 서비스의 활용을 누리시기 바랍니다. 특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<p>
				<p class="text-center"><a class="btn btn-default" data-target="#modalStr" data-toggle="modal" href="#" onclick="fn_clearModalAra('STR');">가게 접속</a></p>
			</div>
			<div class="col-sm-4">
				<h4>센터</h4>
				<p>저희 서비스의 특징은 아라쿠폰을 활용한 고객들의 만족을 높이는데 있습니다. 많은 참여와 다양한 서비스의 활용을 누리시기 바랍니다. 특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<p>
				<p class="text-center"><a class="btn btn-default" data-target="#modalCtr" data-toggle="modal" href="#" onclick="fn_clearModalAra('CTR');">센터 접속</a></p>
			</div>
		</div>
	</div>


<%@ include file="/WEB-INF/views/ara2/common/footer.jsp"%>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- modal dialog -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="row">
		<!-- user information -->
		<div class="modal" id="modalAra" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header alert alert-success">
						아라 접속<button class="close" data-dismiss="modal">&times;</button>
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
									<td>아라ID</td>
									<td class="text-left">
										<input id="araid" type="text" value=''>
										<button id='btnRequestAraKey' type="button" class="btn btn-success btn-sm" onclick="fn_requestAraKey('ARA');"> 아라키(AraKey) 요청 </button>
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
						<button id='btnConnect' type="button" class="btn btn-danger btn-sm" onclick="fn_connect('ARA');"> 접속 </button>
					</div>
				</div>
			</div>
		</div>
	</div>
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
									<td>고객ID</td>
									<td class="text-left">
										<input id="usrid" type="text" value=''>
										<button id='btnRequestAraKey' type="button" class="btn btn-success btn-sm" onclick="fn_requestAraKey('USR');"> 아라키(AraKey) 요청 </button>
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
						<button id='btnConnect' type="button" class="btn btn-danger btn-sm" onclick="fn_connect('USR');"> 접속 </button>
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
									<td>가게ID</td>
									<td class="text-left">
										<input id="strid" type="text" value=''>
										<button id='btnRequestAraKey' type="button" class="btn btn-success btn-sm" onclick="fn_requestAraKey('STR');"> 아라키(AraKey) 요청 </button>
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
						<button id='btnConnect' type="button" class="btn btn-danger btn-sm" onclick="fn_connect('STR');"> 접속 </button>
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
									<td>센터ID</td>
									<td class="text-left">
										<input id="ctrid" type="text" value=''>
										<button id='btnRequestAraKey' type="button" class="btn btn-success btn-sm" onclick="fn_requestAraKey('CTR');"> 아라키(AraKey) 요청 </button>
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
						<button id='btnConnect' type="button" class="btn btn-danger btn-sm" onclick="fn_connect('CTR');"> 접속 </button>
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
	<form id='tempForm'>
		<input type='hidden' id='_conntyp'  name='conntyp'  value='' />
		<input type='hidden' id='_araid'  name='araid'  value='' />
		<input type='hidden' id='_ctrid'  name='ctrid'  value='' />
		<input type='hidden' id='_strid'  name='strid'  value='' />
		<input type='hidden' id='_usrid'  name='usrid'  value='' />
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
		processEvent();
		selectUseCpnList();
	});
	$(document).ready(function(){
		if (true) console.log("step-2: $(document).ready(function(){})");
	});
	function processEvent() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
	}
	function selectUseCpnList() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		if (true) {
			if (true) console.log(">>>>> call ajax:", arguments.callee.caller);
			// call ajax
			jQuery.ajax({
				url           : "${staticPATH}/ara2/ib/selectLastIbTkn.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#tempForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (result.retCode == "0000") {
							if (true) alert("[알림] " + result.retMsg);
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
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	// Ara
	function fn_clearModalAra(connTyp) {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		switch (connTyp) {
		case "ARA":
			$('#modalAra #araid').val('').attr('disabled', false);
			$('#modalAra #btnRequestAraKey').attr('disabled', false);
			$('#modalAra #arakey').val('').attr('disabled', true);
			$('#modalAra #btnConnect').attr('disabled', true);
			break;
		case "USR":
			$('#modalUsr #usrid').val('').attr('disabled', false);
			$('#modalUsr #btnRequestAraKey').attr('disabled', false);
			$('#modalUsr #arakey').val('').attr('disabled', true);
			$('#modalUsr #btnConnect').attr('disabled', true);
			break;
		case "STR":
			$('#modalStr #strid').val('').attr('disabled', false);
			$('#modalStr #btnRequestAraKey').attr('disabled', false);
			$('#modalStr #arakey').val('').attr('disabled', true);
			$('#modalStr #btnConnect').attr('disabled', true);
			break;
		case "CTR":
			$('#modalCtr #ctrid').val('').attr('disabled', false);
			$('#modalCtr #btnRequestAraKey').attr('disabled', false);
			$('#modalCtr #arakey').val('').attr('disabled', true);
			$('#modalCtr #btnConnect').attr('disabled', true);
			break;
		}
	}
	function fn_requestAraKey(connTyp) {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		if (true) {
			// validate
			switch (connTyp) {
			case "ARA":
				if (isEmpty($('#modalAra #araid').val())) {
					$('#modalAra #araid').focus();
					return false;
				}
				break;
			case "USR":
				if (isEmpty($('#modalUsr #usrid').val())) {
					$('#modalUsr #usrid').focus();
					return false;
				}
				break;
			case "STR":
				if (isEmpty($('#modalStr #strid').val())) {
					$('#modalStr #strid').focus();
					return false;
				}
				break;
			case "CTR":
				if (isEmpty($('#modalCtr #ctrid').val())) {
					$('#modalCtr #ctrid').focus();
					return false;
				}
				break;
			}
		}
		if (true) {
			// clear form data
			$("#tempForm > #_conntyp").val('');
			$("#tempForm > #_araid").val('');
			$("#tempForm > #_usrid").val('');
			$("#tempForm > #_strid").val('');
			$("#tempForm > #_ctrid").val('');
			
		}
		if (true) {
			// transfer data
			$("#tempForm > #_conntyp").val(connTyp);
			switch (connTyp) {
			case "ARA":
				$("#tempForm > #_araid").val($("#modalAra #araid").val());
				break;
			case "USR":
				$("#tempForm > #_usrid").val($("#modalUsr #usrid").val());
				break;
			case "STR":
				$("#tempForm > #_strid").val($("#modalStr #strid").val());
				break;
			case "CTR":
				$("#tempForm > #_ctrid").val($("#modalCtr #ctrid").val());
				break;
			}
		}
		return;
		if (true) {
			if (true) console.log(">>>>> call ajax:", arguments.callee.caller);
			// call ajax
			jQuery.ajax({
				url           : "${staticPATH}/ara2/requestAraKey.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#tempForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						if (result.retCode == "0000") {
							if (!true) alert("[알림] " + result.retMsg);
							switch (result.connTyp) {
							case "ARA":
								$('#modalAra #araid').attr('disabled', true);
								$('#modalAra #btnRequestAraKey').attr('disabled', true);
								$('#modalAra #arakey').attr('disabled', false);
								$('#modalAra #btnConnect').attr('disabled', false);
								$('#modalAra #arakey').focus();
								break;
							case "USR":
								$('#modalUsr #usrid').attr('disabled', true);
								$('#modalUsr #btnRequestAraKey').attr('disabled', true);
								$('#modalUsr #arakey').attr('disabled', false);
								$('#modalUsr #btnConnect').attr('disabled', false);
								$('#modalUsr #arakey').focus();
								break;
							case "STR":
								$('#modalStr #strid').attr('disabled', true);
								$('#modalStr #btnRequestAraKey').attr('disabled', true);
								$('#modalStr #arakey').attr('disabled', false);
								$('#modalStr #btnConnect').attr('disabled', false);
								$('#modalStr #arakey').focus();
								break;
							case "CTR":
								$('#modalCtr #ctrid').attr('disabled', true);
								$('#modalCtr #btnRequestAraKey').attr('disabled', true);
								$('#modalCtr #arakey').attr('disabled', false);
								$('#modalCtr #btnConnect').attr('disabled', false);
								$('#modalCtr #arakey').focus();
								break;
							}
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
	function fn_connect(connTyp) {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		return;
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
</script>
</html>
