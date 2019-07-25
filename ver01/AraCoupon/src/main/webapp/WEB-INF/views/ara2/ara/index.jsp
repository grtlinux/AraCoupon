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
<script type="text/javascript">
	// no backward on history
	history.pushState(null, null, document.URL);
	window.addEventListener('popstate', function () {
		history.pushState(null, null, document.URL);
	});
</script>
<body>
<%@ include file="/WEB-INF/views/ara2/common/navbarAra.jsp"%>
<%@ include file="/WEB-INF/views/ara2/common/jumbotron.jsp"%>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- container for column -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container">
		<div class="row">
			<div class="col-sm-4 hide">
				<h4>아라</h4>
				<p>쿠폰시스템 서비스를 만들고 유지하고 운영하는 주체이다. 유지보수를 한다.<p>
				<p class="text-center"><a class="btn btn-default" data-target="#modalAra" data-toggle="modal" href="#" onclick="fn_clearModalAra('ARA');">아라 접속</a></p>
			</div>
			<div class="col-sm-4">
				<h4>고객</h4>
				<p>가게로부터 제공받은 쿠폰을 갖고있다가 쿠폰가게에서 제공쿠폰을 사용한다. 즉, 쿠폰시스템 서비스 해택을 누리는 주체이다.<p>
				<div class="phoneWithDashes">01033882025</div>
				<div class="phoneWithDashes">0103882025</div>
				<div class="numberToMoney">123456789</div>
				<div class="numberWithCommas">123456789</div>
				<div class="onlyNumber">123,456,789 원</div>
				<p class="text-center"><a class="btn btn-default" data-target="#modalUsr" data-toggle="modal" href="#" onclick="fn_clearModalAra('USR');">고객 접속</a></p>
			</div>
			<div class="col-sm-4">
				<h4>가게</h4>
				<p>센터에서 발행한 쿠폰을 구매하고 고객에게 서비스로 제공한다. 고객은 갖고 있는 쿠폰을 사용하면 받아서 일정시간이 흐르면 정산을 실행한다. 정산을 처리하고 나면 가게 통장으로 입금이 이뤄진다.<p>
				<p class="text-center"><a class="btn btn-default" data-target="#modalStr" data-toggle="modal" href="#" onclick="fn_clearModalAra('STR');">가게 접속</a></p>
			</div>
			<div class="col-sm-4">
				<h4>센터</h4>
				<p>쿠폰시스템 전체를 관리하는 곳이다. 쿠폰을 생성하고 가게로 분배하고 마지막으로 쿠폰을 정산한다. 매월 정산에 대한 결산을 진행한다.<p>
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
					<div class="modal-header alert alert-dark">
						아라 접속<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						쿠폰시스템 서비스를 만들고 유지하고 운영하는 주체이다. 유지보수를 한다.<br>
						<img src="${staticPATH}/bootstrap3/images/LEGO_Logo.jpg" style="width:150px;">
						<br><br>
						<table class="table">
							<tbody>
								<tr>
									<td>아라ID</td>
									<td class="text-left">
										<input id="araid" type="text" value=''>
										<button id='btnRequestAraKey' type="button" class="btn btn-dark btn-sm" onclick="fn_requestAraKey('ARA');"> 아라키(AraKey) 요청 </button>
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
					<div class="modal-header alert alert-info">
						고객 접속<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						가게로부터 제공받은 쿠폰을 갖고있다가 쿠폰가게에서 제공쿠폰을 사용한다.<br>
						즉, 쿠폰시스템 서비스 해택을 누리는 주체이다.<br><br>
						<img src="${staticPATH}/bootstrap3/images/user_03.png" style="width:150px;">
						<br><br>
						<table class="table">
							<tbody>
								<tr>
									<td>
										<button id='btnRegisterUsr' type="button" class="btn btn-danger btn-sm" onclick="fn_registerUsr();"> 고객등록 </button>&nbsp;&nbsp;
										고객ID
									</td>
									<td class="text-left">
										<input id="usrid" type="text" value=''>
										<button id='btnRequestAraKey' type="button" class="btn btn-info btn-sm" onclick="fn_requestAraKey('USR');"> 아라키(AraKey) 요청 </button>
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
						<button id='btnConnect' type="button" class="btn btn-info btn-sm" onclick="fn_connect('USR');"> 접속 </button>
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
						센터에서 발행한 쿠폰을 구매하고 고객에게 서비스로 제공한다.<br>
						고객은 갖고 있는 쿠폰을 사용하면 받아서 일정시간이 흐르면 정산을 실행한다.<br>
						정산을 처리하고 나면 가게 통장으로 입금이 이뤄진다.<br><br>
						<img src="${staticPATH}/bootstrap3/images/store_02.png" style="width:150px;">
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
						<button id='btnConnect' type="button" class="btn btn-success btn-sm" onclick="fn_connect('STR');"> 접속 </button>
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
					<div class="modal-header alert alert-danger">
						센터 접속<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						쿠폰시스템 전체를 관리하는 곳이다.<br>
						쿠폰을 생성하고 가게로 분배하고 마지막으로 쿠폰을 정산한다.<br>
						매월 정산에 대한 결산을 진행한다.<br><br>
						<img src="${staticPATH}/bootstrap3/images/system_02.png" style="width:150px;">
						<br><br>
						<table class="table">
							<tbody>
								<tr>
									<td>센터ID</td>
									<td class="text-left">
										<input id="ctrid" type="text" value=''>
										<button id='btnRequestAraKey' type="button" class="btn btn-danger btn-sm" onclick="fn_requestAraKey('CTR');"> 아라키(AraKey) 요청 </button>
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
		<input type='hidden' id='_menuName' name='menuName' value='' />
		<input type='hidden' id='_conntyp'  name='conntyp'  value='' />
		<input type='hidden' id='_connid'  name='connid'  value='' />
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
		if (!true) {
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
				$("#tempForm > #_connid").val($("#modalAra #araid").val());
				break;
			case "USR":
				$("#tempForm > #_usrid").val($("#modalUsr #usrid").val());
				$("#tempForm > #_connid").val($("#modalUsr #usrid").val());
				break;
			case "STR":
				$("#tempForm > #_strid").val($("#modalStr #strid").val());
				$("#tempForm > #_connid").val($("#modalStr #strid").val());
				break;
			case "CTR":
				$("#tempForm > #_ctrid").val($("#modalCtr #ctrid").val());
				$("#tempForm > #_connid").val($("#modalCtr #ctrid").val());
				break;
			}
		}
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
							if (true) alert("[알림] " + result.retMsg);
							switch (result.conntyp) {
							case "ARA":
								$('#modalAra #araid').attr('disabled', true);
								$('#modalAra #btnRequestAraKey').attr('disabled', true);
								$('#modalAra #btnConnect').attr('disabled', false);
								$('#modalAra #arakey').attr('disabled', false).focus();
								break;
							case "USR":
								$('#modalUsr #usrid').attr('disabled', true);
								$('#modalUsr #btnRequestAraKey').attr('disabled', true);
								$('#modalUsr #btnConnect').attr('disabled', false);
								$('#modalUsr #arakey').attr('disabled', false).focus();
								break;
							case "STR":
								$('#modalStr #strid').attr('disabled', true);
								$('#modalStr #btnRequestAraKey').attr('disabled', true);
								$('#modalStr #btnConnect').attr('disabled', false);
								$('#modalStr #arakey').attr('disabled', false).focus();
								break;
							case "CTR":
								$('#modalCtr #ctrid').attr('disabled', true);
								$('#modalCtr #btnRequestAraKey').attr('disabled', true);
								$('#modalCtr #btnConnect').attr('disabled', false);
								$('#modalCtr #arakey').attr('disabled', false).focus();
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
		if (true) {
			// validate
			switch (connTyp) {
			case "ARA":
				if (isEmpty($('#modalAra #arakey').val())) {
					$('#modalAra #arakey').focus();
					return false;
				}
				break;
			case "USR":
				if (isEmpty($('#modalUsr #arakey').val())) {
					$('#modalUsr #arakey').focus();
					return false;
				}
				break;
			case "STR":
				if (isEmpty($('#modalStr #arakey').val())) {
					$('#modalStr #arakey').focus();
					return false;
				}
				break;
			case "CTR":
				if (isEmpty($('#modalCtr #arakey').val())) {
					$('#modalCtr #arakey').focus();
					return false;
				}
				break;
			}
		}
		if (true) {
			// transfer data
			switch (connTyp) {
			case "ARA":
				$("#tempForm > #_arakey").val($("#modalAra #arakey").val());
				break;
			case "USR":
				$("#tempForm > #_arakey").val($("#modalUsr #arakey").val());
				break;
			case "STR":
				$("#tempForm > #_arakey").val($("#modalStr #arakey").val());
				break;
			case "CTR":
				$("#tempForm > #_arakey").val($("#modalCtr #arakey").val());
				break;
			}
		}
		if (true) {
			// confirm connection Authentication
			jQuery.ajax({
				url           : "${staticPATH}/ara2/connect.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#tempForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						switch (connTyp) {
						case "ARA":
							if (result.retCode == "0000") {
								fn_loadPostPage("#tempForm", "${staticPATH}/ara2/index.do");
							} else {
								alert("에러메시지: " + result.retMsg);
								fn_modalToggle('#modalAra');
							}
							break;
						case "USR":
							if (result.retCode == "0000") {
								fn_loadPostPage("#tempForm", "${staticPATH}/usr2/index.do");
							} else {
								alert("에러메시지: " + result.retMsg);
								fn_modalToggle('#modalUsr');
							}
							break;
						case "STR":
							if (result.retCode == "0000") {
								fn_loadPostPage("#tempForm", "${staticPATH}/str2/index.do");
							} else {
								alert("에러메시지: " + result.retMsg);
								fn_modalToggle('#modalStr');
							}
							break;
						case "CTR":
							if (result.retCode == "0000") {
								fn_loadPostPage("#tempForm", "${staticPATH}/ctr2/index.do");
							} else {
								alert("에러메시지: " + result.retMsg);
								fn_modalToggle('#modalCtr');
							}
							break;
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
	function fn_registerUsr() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		fn_loadPostPage("#tempForm", "${staticPATH}/ara2/register/registerUsrFormPage.do");		
	}
</script>
</html>
