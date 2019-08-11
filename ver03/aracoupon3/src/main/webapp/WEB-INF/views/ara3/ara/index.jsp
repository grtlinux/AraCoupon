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
			<div class="hide col-sm-4">
				<h4>아라</h4>
				<p>아라 개발 그룹.<p>
				<p id="btnConnect" class="text-center"><a class="btn btn-default" data-target="#modalAra" data-toggle="modal" href="#" onclick="fn_clearModalAra('ARA');">아라 접속</a></p>
			</div>
			<div class="col-sm-4">
				<h4>고객</h4>
				<p>고객 관심.<p>
				<p id="btnConnect" class="text-center"><a class="btn btn-info" data-target="#modalUsr" data-toggle="modal" href="#" onclick="fn_clearModalAra('USR');">고객 접속</a></p>
			</div>
			<div class="col-sm-4">
				<h4>가게</h4>
				<p>가게 이윤.<p>
				<p id="btnConnect" class="text-center"><a class="btn btn-success" data-target="#modalStr" data-toggle="modal" href="#" onclick="fn_clearModalAra('STR');">가게 접속</a></p>
			</div>
			<div class="col-sm-4">
				<h4>센터</h4>
				<p>센터 운영 관리.<p>
				<p id="btnConnect" class="text-center"><a class="btn btn-danger" data-target="#modalCtr" data-toggle="modal" href="#" onclick="fn_clearModalAra('CTR');">센터 접속</a></p>
			</div>
		</div>
	</div>


<%@ include file="/WEB-INF/views/ara2/common/footer.jsp"%>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ARA modal dialog -->
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
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- USR modal dialog -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
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
										<input id="usrid" list="loginList" type="text" value='${usrid}'>
										<datalist id="loginList">
										</datalist>
										
										<button id='btnRequestAraKey' type="button" class="btn btn-info btn-sm" onclick="fn_requestAraKey('USR');"> 아라키(AraKey) 요청 </button>
										<div class='show'>
											<input id="usridSaveYn" type="checkbox" <c:if test="${usridSaveYn eq 'Y'}">checked="checked"</c:if>/> 고객ID 저장
										</div>
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
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- STR modal dialog -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
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
										<div class='hide'>
											<input id="stridSaveYn" type="checkbox"> 가게ID 저장
										</div>
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
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- CTR modal dialog -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
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
										<input id="ctrid" type="text" value='11' readOnly>
										<button id='btnRequestAraKey' type="button" class="btn btn-danger btn-sm" onclick="fn_requestAraKey('CTR');"> 아라키(AraKey) 요청 </button>
										<div class='hide'>
											<input id="ctridSaveYn" type="checkbox"> 센터ID 저장
										</div>
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
	<!-- NotSales modal dialog -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="row">
		<!-- center information -->
		<div class="modal" id="modalNotSales" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header alert alert-danger">
						업무시간 안내<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						아라쿠폰서비스시스템의 업무시간을 알려드립니다.<br><br>
						<div class="alert alert-danger"><h2>매일: ${araSalesOpenTime} ~ ${araSalesCloseTime}</h2></div>
						<br><br>
						<img src="${staticPATH}/bootstrap3/images/system_02.png" style="width:150px;"><br>
						<!--
						<br><br>
						<table class="table">
							<tbody>
								<tr>
									<td>센터ID</td>
									<td class="text-left">
										<input id="ctrid" type="text" value=''>
										<button id='btnRequestAraKey' type="button" class="btn btn-danger btn-sm" onclick="fn_requestAraKey('CTR');"> 아라키(AraKey) 요청 </button>
										<div class='hide'>
											<input id="ctridSaveYn" type="checkbox"> 센터ID 저장
										</div>
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
						-->
						<div class="hide text-center">
							<div id="barCodeTgt1"></div>
							<div id="barCodeTgt2"></div>
							<div id="barCodeTgt3"></div>
							<div id="barCodeTgt4"></div>
							<div id="barCodeTgt5"></div>
						</div>
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
		<input type='hidden' id='_ctridSaveYn'  name='ctridSaveYn'  value='' />
		<input type='hidden' id='_stridSaveYn'  name='stridSaveYn'  value='' />
		<input type='hidden' id='_usridSaveYn'  name='usridSaveYn'  value='' />
		<input type='hidden' id='_arakey' name='arakey' value='' />
		<input type='hidden' id='_srchWord' name='srchWord' value='20' />
	</form>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<style>
	.uploadResult {
		width: 100%;
		background-color: #aaaaff;
	}
	
	.uploadResult ul {
		display: flex;
		flex-flow: row;
		justify-content: center;
		align-items: center;
	}
	
	.uploadResult ul li {
		list-style: none;
		padding: 10px;
	}
	
	.uploadResult ul li img {
		width: 100px;
	}
</style>

<style>
	.bigPictureWrapper {
		position: absolute;
		display: none;
		justify-content: center;
		align-items: center;
		top:0%;
		width:100%;
		height:100%;
		background-color: gray; 
		z-index: 100;
	}
	
	.bigPicture {
		position: relative;
		display:flex;
		justify-content: center;
		align-items: center;
	}
</style>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->

	<div class="hide">
		<div class='bigPictureWrapper'>
			<div class='bigPicture'></div>
		</div>
		<div class='uploadDiv'>
			<input type='file' name='uploadFile' multiple>
		</div>
		<div class='uploadResult'>
			<ul>
			</ul>
		</div>
		<button id='uploadBtn'>Upload</button>
	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
		
	<div class="hide">
		<form action="/file/uploadFormAction.do" method="POST" enctype="multipart/form-data">
			<input type="file" name="uploadFile" multiple>
			<input type="submit" value="SUBMIT">
		</form>
	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->

</body>
<!-- script -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script -->
<script src="${staticPATH}/bootstrap3/js/bootstrap.js"></script>
<script src="${staticPATH}/bootstrap3/js/ara.common.v01.js"></script>
<script src="${staticPATH}/bootstrap3/js/ara.jquery-barcode.js"></script>
<script type="text/javascript">
	$(function() {
		if (true) console.log("step-1: $(function() {});");
		processEvent();
		selectUseCpnList();
		processSalesTime();
		//processSetInterval();
		//processSetTimeout();
		processBarCode();
	});
	$(document).ready(function(){
		if (true) console.log("step-2: $(document).ready(function(){})");
		if (true) {
			// cookie 이용
			if (fn_getCookie("ckSaveYn") == 'false') {
				fn_setCookie("ckId", "");
			}
			if (true) {
				var ckId = fn_getCookie("ckId");
				var ckTyp = fn_getCookie("ckTyp");
				var ckSaveYn = fn_getCookie("ckSaveYn");
				if (!true) console.log(">>>>> (" + ckId + ", " + ckTyp + ", " + ckSaveYn + ")");  // for cookie
			}
			switch (fn_getCookie("ckTyp")) {
			case "ARA":
				break;
			case "USR":
				$('#modalUsr #usrid').val(fn_getCookie("ckId"));
				$('#modalUsr #usridSaveYn').prop('checked', fn_getCookie("ckSaveYn") == 'true' ? true : false);
				break;
			case "STR":
				$('#modalStr #strid').val(fn_getCookie("ckId"));
				$('#modalStr #stridSaveYn').prop('checked', fn_getCookie("ckSaveYn") == 'true' ? true : false);
				break;
			case "CTR":
				$('#modalCtr #ctrid').val(fn_getCookie("ckId"));
				$('#modalCtr #ctridSaveYn').prop('checked', fn_getCookie("ckSaveYn") == 'true' ? true : false);
				break;
			}
		}
		if (true) {
			// session 이용
		}
	});
	function processEvent() {
		if (true) console.log(">>>>> 1. ", $F().name);
		var timeoutId = null;
		//if (true) $('#modalUsr #usrid').on('keydown', function(key) {
		//	if (key.keyCode != 13) return;
		if (true) $('#modalUsr #usrid').on('keyup', function() {
			var value = $(this).val().trim();
			if (!true) console.log(">>>>> length=" + value.length + ", value=" + value);
			if (timeoutId != null) clearTimeout(timeoutId);
			timeoutId = setTimeout(function() {
				if (value.length < 2) {
					$('#loginList').empty();
					clearTimeout(timeoutId);
					timeoutId = null;
					return;
				}
				$('#tempForm #_srchWord').val(value);
				jQuery.ajax({
					url           : "${staticPATH}/ctr2/manage/selectLikeLoginSrch.do",
					dataType      : "JSON",
					scriptCharset : "UTF-8",
					type          : "POST",
					data          : $("#tempForm").serialize(),
					success: function(result, option) {
						if (option == "success") {
							if (result.retCode == "0000") {
								if (!true) alert("[알림] " + result.retMsg);
								console.log(">>>>> result=", result);
								var list = result.list;
								$('#loginList').empty();
								list.forEach(function(value, index, array) {
									var rowOption = "";
									rowOption += "<option value='" + value.ITM_NO + "'>" + value.LOGIN_LIST + "</option>";
									$('#loginList').append(rowOption);
								});
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
			}, 2000);
		});
	}
	function selectUseCpnList() {
		if (true) console.log(">>>>> 2. ", $F().name);
		if (!true) {
			if (true) console.log(">>>>> call ajax:", arguments.callee.caller);
			// call ajax for TEST
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
	function processSalesTime() {
		if (true) console.log(">>>>> 3. ", $F().name);
		if (!true) alert("업무시간: ${araSalesOpenTime} ~ ${araSalesCloseTime}");
		if ("no" == "${araSalesOk}") {
			fn_modalToggle('#modalNotSales');
			$('.container #btnConnect').addClass('hide');
			$('.navbar-nav #btnConnect').addClass('hide');
		}
	}
	function processSetInterval() {
		if (true) console.log(">>>>> 4. ", $F().name);
		
		var idx = 0;
		var repeat = setInterval(function() {
			idx ++;
			if (true) console.log("process setInterval....idx = " + idx);
			if (idx >= 2)
				clearInterval(repeat);
		}, 2000);
	}
	function processSetTimeout() {
		if (true) console.log(">>>>> 5. ", $F().name);
		setTimeout(function() {
			if (true) console.log("process setTimeout....");
		}, 3000);
	}
	function processBarCode() {
		if (true) console.log(">>>>> 6. ", $F().name);
		// ref: https://doolyit.tistory.com/89
		// title: jquery barcode 출력(바코드출력)하기, jquery 공개소스
		//
		$('#barCodeTgt1').barcode('1234567890123', 'code128');
		$("#barCodeTgt2").barcode("1234567890128", "ean13",{barWidth:2, barHeight:30});
		$("#barCodeTgt3").barcode("1234567", "int25",{barWidth:2, barHeight:30});	
		$("#barCodeTgt4").barcode("1234567890128", "code128",{barWidth:1, barHeight:70,showHRI:true,bgColor:"red"});
		$("#barCodeTgt5").barcode("1234567890128", "datamatrix",{showHRI:false,bgColor:"yellow"});
	}
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	// Ara
	function fn_clearModalAra(connTyp) {
		if (true) console.log(">>>>> ", $F().name);
		switch (connTyp) {
		case "ARA":
			$('#modalAra #araid').val('').attr('disabled', false);
			$('#modalAra #btnRequestAraKey').attr('disabled', false);
			$('#modalAra #arakey').val('').attr('disabled', true);
			$('#modalAra #btnConnect').attr('disabled', true);
			break;
		case "USR":
			//$('#modalUsr #usrid').val('').attr('disabled', false);
			$('#modalUsr #btnRequestAraKey').attr('disabled', false);
			$('#modalUsr #arakey').val('').attr('disabled', true);
			$('#modalUsr #btnConnect').attr('disabled', true);
			break;
		case "STR":
			//$('#modalStr #strid').val('').attr('disabled', false);
			$('#modalStr #btnRequestAraKey').attr('disabled', false);
			$('#modalStr #arakey').val('').attr('disabled', true);
			$('#modalStr #btnConnect').attr('disabled', true);
			break;
		case "CTR":
			//$('#modalCtr #ctrid').val('').attr('disabled', false);
			$('#modalCtr #btnRequestAraKey').attr('disabled', false);
			$('#modalCtr #arakey').val('').attr('disabled', true);
			$('#modalCtr #btnConnect').attr('disabled', true);
			break;
		}
	}
	function fn_requestAraKey(connTyp) {
		if (true) console.log(">>>>> ", $F().name);
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
		if (true) console.log(">>>>> ", $F().name);
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
				$("#tempForm > #_usridSaveYn").val($("#modalUsr #usridSaveYn").is(":checked") ? 'Y' : 'N');
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
								//fn_setCookie("ckId", result.usrid, 1);
								//fn_setCookie("ckTyp", connTyp, 1);
								//fn_setCookie("ckSaveYn", $('#usridSaveYn').is(':checked'), 1);
								fn_loadPostPage("#tempForm", "${staticPATH}/usr2/index.do");
							} else {
								alert("에러메시지: " + result.retMsg);
								fn_modalToggle('#modalUsr');
							}
							break;
						case "STR":
							if (result.retCode == "0000") {
								//fn_setCookie("ckId", result.strid, 1);
								//fn_setCookie("ckTyp", connTyp, 1);
								//fn_setCookie("ckSaveYn", $('#stridSaveYn').is(':checked'), 1);
								fn_loadPostPage("#tempForm", "${staticPATH}/str2/index.do");
							} else {
								alert("에러메시지: " + result.retMsg);
								fn_modalToggle('#modalStr');
							}
							break;
						case "CTR":
							if (result.retCode == "0000") {
								//fn_setCookie("ckId", result.ctrid, 1);
								//fn_setCookie("ckTyp", connTyp, 1);
								//fn_setCookie("ckSaveYn", $('#ctridSaveYn').is(':checked'), 1);
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
		if (true) console.log(">>>>> ", $F().name);
		fn_loadPostPage("#tempForm", "${staticPATH}/ara2/register/registerUsrFormPage.do", "고객등록");
	}
</script>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->

<script>
	function showImage(fileCallPath){
		//alert(fileCallPath);
		$(".bigPictureWrapper").css("display","flex").show();
		
		$(".bigPicture")
			.html("<img src='/file/display.do?fileName="+fileCallPath+"'>")
			.animate({width:'100%', height: '100%'}, 1000);
	}
	$(".bigPictureWrapper").on("click", function(e) {
		$(".bigPicture").animate({width:'0%', height: '0%'}, 1000);
		setTimeout(() => {
			$(this).hide();
		}, 1000);
	});
	$(".uploadResult").on("click","span", function(e){
		var targetFile = $(this).data("file");
		var type = $(this).data("type");
		console.log(targetFile);
		$.ajax({
			url: '/file/deleteFile.do',
			data: {fileName: targetFile, type:type},
			dataType:'text',
			type: 'POST',
			success: function(result){
				alert(result);
			}
		}); //$.ajax
	});
	
	var regex1 = new RegExp("^[0-9a-zA-Z_.\-\w]+$");
	var regex2 = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	var maxSize = 5242880; //5MB
	
	function checkExtension(fileName, fileSize) {
		if (fileSize >= maxSize) {
			alert("파일 사이즈 초과");
			return false;
		}
		if (regex1.test(fileName)) {
			alert("[알림] 숫자, 알파뱃대-소문자, 공백, 특수(_.) 만 허용됩니다. (" + fileName+ ")");
			return;
		}
		if (regex2.test(fileName)) {
			alert("해당 종류의 파일은 업로드할 수 없습니다.");
			return false;
		}
		return true;
	}

	var cloneObj = $(".uploadDiv").clone();

	$("#uploadBtn").on("click", function(e) {
		var formData = new FormData();
		var inputFile = $(".uploadDiv input[name='uploadFile']");
		var files = inputFile[0].files;
		console.log(files);
		for (var i = 0; i < files.length; i++) {
			if (!checkExtension(files[i].name, files[i].size)) {
				return false;
			}
			formData.append("uploadFile", files[i]);
		}
		$.ajax({
			url : '/file/uploadAjaxAction.do',
			type : 'POST',
			data : formData,
			dataType : 'json',
			processData : false,
			contentType : false,
			success : function(result) {
				console.log(result);
				showUploadedFile(result);
				$(".uploadDiv").html(cloneObj.html());
			}
		}); //$.ajax
	});

	var uploadResult = $(".uploadResult ul");

	function showUploadedFile(uploadResultArr) {
		var str = "";
		$(uploadResultArr).each(function(i, obj) {
			if (!obj.image) {
				var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
				var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
				str += "<li><div>"
					+ "<a href='/file/download.do?fileName=" + fileCallPath + "'>"
					+ "<img src='/image/attach.png'>" + obj.fileName
					+ "</a>"
					+ "<span data-file=\'" + fileCallPath + "\' data-type='file'> x </span>"
					+ "<div></li>\n";
			} else {
				var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
				var originPath = obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName;
				originPath = originPath.replace(new RegExp(/\\/g),"/");
				str += "<li>"
					+ "<a href=\"javascript:showImage(\'" + originPath + "\')\">"
					+ "<img src='/file/display.do?fileName=" + fileCallPath + "'>"
					+ "</a>"
					+ "<span data-file=\'" + fileCallPath + "\' data-type='image'> x </span>"
					+ "<li>\n";
			}
		});
		uploadResult.append(str);
	}
</script>

</html>
