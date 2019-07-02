<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>거래처 - ${info.STR_NM}</title>
</head>
<!-- style -->
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<link rel="stylesheet" href="${staticPATH}/bootstrap3/css/bootstrap.css">
<link rel="stylesheet" href="${staticPATH}/bootstrap3/css/ara.codingBooster5.v01.css">
<link rel="stylesheet" href="${staticPATH}/bootstrap3/css/ara.jumbotron.v01.css">
<script type="text/javascript">
	// no backward on history
	history.pushState(null, null, document.URL);
	window.addEventListener('popstate', function () {
		history.pushState(null, null, document.URL);
	});
	//window.history.forward();
	//function noBack() {
	//	window.history.forward();
	//}
</script>
<body>

<%@ include file="/WEB-INF/views/ara/common/_navbarStr.jsp"%>



	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- container for table panel -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container-fluid">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;미결제 쿠폰목록</h3>
			</div>
			<div class="panel-body">
				<div id="sysbtn1" class="text-right" style="margin-bottom:10px;">
					<button type="button" class="btn btn-info btn-sm" onclick="fn_refresh();"> 새로고침 </button>
					<button type="button" class="btn btn-danger btn-sm hide" onclick="fn_insertApprReq();"> 쿠폰제공 </button>
				</div>
				<div class="table-responsive">
					<table id="campTable" class="table table-hover table-condensed">
						<thead>
							<tr class="info">
								<td><input id='allCheckbox' type='checkbox'></td>
								<td>쿠폰번호</td>
								<td>쿠폰금액</td>
								<td class='hide'>쿠폰금액2</td>
								<td>쿠폰단계</td>
								<td>캠페인번호</td>
								<td>발행거래처번호</td>
								<td>제공고객번호</td>
								<td>사용거래처번호</td>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<div id="sysbtn2" class="text-right show" style="margin-bottom:10px;">
					<button type="button" class="btn btn-info btn-sm" onclick="fn_refresh();"> 새로고침 </button>
					<button type="button" class="btn btn-danger btn-sm hide" onclick="fn_insertApprReq();"> 쿠폰제공 </button>
				</div>
			</div>
			<div class="panel-footer">
				<blockquote>&nbsp;&nbsp;Do And Forget!!</blockquote>
			</div>
		</div>
	</div>
	<!-- gap -->
	<div style="height:70px;"></div>


<%@ include file="/WEB-INF/views/ara/common/_footer.jsp"%>


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
						<img src="${staticPATH}/bootstrap3/images/steve-jobs.png" style="width:250px;">
					</div>
				</div>
			</div>
		</div>
		<div class="modal" id="modal1" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header alert alert-success">
						쿠폰 정보<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						<table class="table text-left">
							<tr>
								<td>쿠폰번호</td>
								<td><div id="modalCpnNo"></div></td>
							</tr>
							<tr>
								<td>쿠폰마스터번호</td>
								<td><div id="modalCpnMst"></div></td>
							</tr>
							<tr>
								<td>쿠폰금액</td>
								<td><div id="modalCpnMny"></div></td>
							</tr>
							<tr class="hide">
								<td>쿠폰금액2</td>
								<td><div id="modalCpnMny2"></div></td>
							</tr>
							<tr>
								<td>캠페인번호</td>
								<td><div id="modalCampId"></div></td>
							</tr>
							<tr>
								<td>발행거래처</td>
								<td><div id="modalStrId"></div></td>
							</tr>
							<tr>
								<td>제공고객</td>
								<td><div id="modalUsrId"></div></td>
							</tr>
							<tr>
								<td>사용거래처</td>
								<td><div id="modalUsdStrId"></div></td>
							</tr>
							<tr>
								<td>쿠폰단계</td>
								<td><div id="modalCpnPhs"></div></td>
							</tr>
							<tr>
								<td>쿠폰생성일시</td>
								<td><div id="modalCreDttm"></div></td>
							</tr>
						</table>
						<img src="${staticPATH}/bootstrap3/images/LEGO_Logo.jpg" style="width:50px;">
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
	<!-- all of forms -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<form id='tempForm'>
		<input type='hidden' id='_strid' name='strid' value='${info.STR_ID}' />
		<input type='hidden' id='_campIds' name='campIds' value='' />
	</form>




</body>
<!-- script -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="${staticPATH}/bootstrap3/js/bootstrap.js"></script>
<script src="${staticPATH}/bootstrap3/js/ara.common.v01.js"></script>
<script type="text/javascript">
	var list;
	$(function() {
		if (true) console.log("step-1: $(function() {});");
		processEvent();
		selectNoPayCpnList();
	});
	$(document).ready(function(){
		if (true) console.log("step-2: $(document).ready(function(){})");
	});
	function processEvent() {
		if (true) $('#allCheckbox').on('change', function() {
			var flgAllCheckbox = $('#allCheckbox').is(':checked');
			if (!true) console.log('>>>>> #allCheckbox change is ' + flgAllCheckbox);
			$('input:checkbox[name="rowCheckbox"]').prop('checked', flgAllCheckbox);
		});
	}
	function selectNoPayCpnList(){
		jQuery.ajax({
			url           : "${staticPATH}/str/payment/selectNoPayCpnList.do",
			dataType      : "JSON",
			scriptCharset : "UTF-8",
			type          : "POST",
			data          : $("#tempForm").serialize(),
			success: function(result, option) {
				if (option == "success"){
					list = result.list;
					$("#campTable > tbody").empty();
					list.forEach(function(value, index, array) {
						var rowHtml = "";
						rowHtml += "<tr>";
						rowHtml += "  <td>";
						rowHtml += "    <input type='checkbox' name='rowCheckbox'>";
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-left'>";
						rowHtml += "    " + value.CPN_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + fn_comma(value.CPN_MNY) + " 원";
						rowHtml += "  </td>";
						rowHtml += "  <td class='hide'>";
						rowHtml += "    " + value.CPN_MNY;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.PHS_NM + " (" + value.CPN_PHS + ")";
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CAMP_ID;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.STR_ID;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.USR_ID;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.USD_STR_ID;
						rowHtml += "  </td>";
						rowHtml += "</tr>";
						$("#campTable > tbody:last").append(rowHtml);
					});
					if (!true) $('#campTable > tbody tr').on('click', function() {
						// not used
						var tr = $(this);
						if (!true) console.log(">>>>> (" + tr.index() + ")" + tr.text());
						var td = tr.children();
						var arr = [];
						td.each(function(idx) {
							arr.push(td.eq(idx).text().trim());
						});
						if (true) console.log(">>>>> (" + tr.index() + ")" + arr.join(','));
					});
					if (true) $('#campTable > tbody tr td').on('click', function() {
						var td = $(this);
						if (td.index() == 0)
							return;
						var tr = td.parent();
						if (true) console.log(">>>>> (tr, td) = (" + tr.index() + ", " + td.index() + ")");
						var info = list[tr.index()];
						if (true) console.log(">>>>> info ", info);
						$('#modalCpnNo').text(info.CPN_NO);
						$('#modalCpnMst').text(info.CPN_MST);
						$('#modalCpnMny').text(info.TYP_DESC + "(" + info.CPN_TYP + ")");
						$('#modalCpnMny2').text(info.CPN_MNY);
						$('#modalCampId').text(info.CAMP_ID);
						$('#modalStrId').text(info.STR_ID);
						$('#modalUsrId').text(info.USR_ID);
						$('#modalUsdStrId').text(info.USD_STR_ID);
						$('#modalCpnPhs').text(info.PHS_NM + "(" + info.CPN_PHS + ")");
						$('#modalCreDttm').text(info.CRE_DTTM);
						fn_modalToggle('#modal1');
					});
					if (true) {
						// console.log(">>>>> allCheckbos");
						$('#allCheckbox').prop('checked', false);
					}
				} else {
					alert("에러가 발생하였습니다.");
				}
			},
			error: function(result, option) {
				alert("에러가 발생하였습니다.");
			}
		});
	}
	function fn_refresh() {
		selectNoPayCpnList();
	}
	function fn_insertApprReq() {
		var campIds = [];
		var rowChecked = $('#campTable input:checkbox[name=rowCheckbox]:checked');
		rowChecked.each(function (index) {
			var campId = $(this).parent().parent().children().eq(1).text();
			// console.log(">>>>> " + index + ", " + campId);
			campIds.push(campId.trim());
		});
		console.log(">>>>> campIds = " + campIds.join(','));
		$('#tempForm #_campIds').val(campIds.join(','));
		
		jQuery.ajax({
			url           : "${staticPATH}/str/coupon/insertApprReq.do",
			dataType      : "JSON",
			scriptCharset : "UTF-8",
			type          : "POST",
			data          : $('#tempForm').serialize(),
			success: function(result, option) {
				if (option == "success"){
					alert("메시지: " + result.retMsg);
					selectNoPayCpnList();
				} else {
					alert("에러가 발생하였습니다.");
				}
			},
			error: function(result, option) {
				alert("에러가 발생하였습니다.");
			}
		});
	}
</script>
</html>
