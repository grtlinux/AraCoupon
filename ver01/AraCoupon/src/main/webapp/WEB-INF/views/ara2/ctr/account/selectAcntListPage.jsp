<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>센터 - ${info.CTR_NM}</title>
</head>
<%@ include file="/WEB-INF/views/ara2/common/cssCtr.jsp"%>
<body>
<%@ include file="/WEB-INF/views/ara2/common/navbarCtr.jsp"%>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- container for table panel -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container-fluid">
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;각 가게의 계정내역을 보여준다.</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table id="campTable" class="table table-hover table-condensed">
						<thead>
							<tr class="info text-center">
								<td class="show"><input id='allCheckbox' type='checkbox'></td>
								<td>계정내역#</td>
								<td>아이템ID</td>
								<td>아이템타입</td>
								<td>가게명</td>
								<td>잔액</td>
								<td>입출금최근일시</td>
								<!--
								<td>캠페인단계명</td>
								-->
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<div id="sysbtn" class="col-md-12" style="text-align:right;margin-bottom:10px;">
					<button type="button" class="btn btn-info btn-sm" onclick="fn_refresh();"> 새로고침 </button>
					<button type="button" class="btn btn-danger btn-sm hide" onclick="fn_createCouponPackage();"> 쿠폰발행 </button>
					<button type="button" class="btn btn-success btn-sm" onclick="fn_index();"><i class="fa fa-times" aria-hidden="true"></i> 닫기</button>
				</div>
			</div>
			<div class="panel-footer">
				<blockquote>&nbsp;&nbsp;Do And Forget!!</blockquote>
			</div>
		</div>
	</div>
	<!-- gap -->
	<div style="height:70px;"></div>


<%@ include file="/WEB-INF/views/ara2/common/footer.jsp"%>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- modal dialog -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="row">
		<!-- user information -->
		<div class="modal" id="modalSelfInfo" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header alert alert-danger">
						내 정보(센터)<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						<div class="panel panel-primary">
							<table class="table text-left">
								<tbody>
									<tr>
										<td>센터ID</td>
										<td class="align-left">${info.CTR_ID}</td>
									</tr>
									<tr>
										<td>센터명</td>
										<td>${info.CTR_NM}</td>
									</tr>
									<tr>
										<td>전화번호</td>
										<td>${info.TEL_NUM}</td>
									</tr>
									<tr>
										<td>핸드폰번호</td>
										<td>${info.MBL_NUM}</td>
									</tr>
									<tr>
										<td>이메일</td>
										<td>${info.EML_ADDR}</td>
									</tr>
									<tr class="hide">
										<td>전화번호</td>
										<td>${info.TEL_NO}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<img class="hide" src="${staticPATH}/bootstrap3/images/steve-jobs.png" style="width:250px;">
					</div>
				</div>
			</div>
		</div>
	</div>	
	<div class="row">
		<div class="modal" id="modalAcntInfo" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header alert alert-success">
						가게 계좌 정보<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						<table class="table text-left">
							<tr>
								<td>계정내역 번호</td>
								<td><div id="modalAnctHist"></div></td>
							</tr>
							<tr>
								<td>아이템ID</td>
								<td><div id="modalItmId"></div></td>
							</tr>
							<tr>
								<td>아이템타입</td>
								<td><div id="modalItmTyp"></div></td>
							</tr>
							<tr>
								<td>가게명</td>
								<td><div id="modalStrNm"></div></td>
							</tr>
							<tr>
								<td>잔액</td>
								<td><div id="modalAcntBlnc"></div></td>
							</tr>
							<tr>
								<td>입출금최근일시</td>
								<td><div id="modalCreDttm"></div></td>
							</tr>
						</table>
						<img class="hide" src="${staticPATH}/bootstrap3/images/LEGO_Logo.jpg" style="width:50px;">
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
		<input type='hidden' id='_ctrid' name='ctrid' value='${info.CTR_ID}' />
		<input type='hidden' id='_strid' name='strid' value='' />
		<input type='hidden' id='_arakey' name='arakey' value='' />
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
		selectList();
	});
	$(document).ready(function(){
		if (true) console.log("step-2: $(document).ready(function(){})");
	});
	function processEvent() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		if (true) $('#allCheckbox').on('change', function() {
			var flgAllCheckbox = $('#allCheckbox').is(':checked');
			if (!true) console.log('>>>>> #allCheckbox change is ' + flgAllCheckbox);
			$('input:checkbox[name="rowCheckbox"]').prop('checked', flgAllCheckbox);
		});
	}
	function selectList() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		jQuery.ajax({
			url           : "${staticPATH}/ctr2/account/selectAcntList.do",
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
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.ACNTHIST_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.ITM_ID;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.ITM_TYP;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.STR_NM;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + fn_comma(value.ACNT_BLNC);
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CRE_DTTM;
						rowHtml += "  </td>";
						rowHtml += "</tr>";
						$("#campTable > tbody:last").append(rowHtml);
					});
					if (true) $('#campTable > tbody tr td').on('click', function() {
						var td = $(this);
						if (td.index() == 0)
							return;
						var tr = td.parent();
						if (true) console.log(">>>>> (tr, td) = (" + tr.index() + ", " + td.index() + ")");
						var info = list[tr.index()];
						if (true) console.log(">>>>> info ", info);
						$('#modalAnctHist').text(info.ACNTHIST_NO);
						$('#modalItmId').text(info.ITM_ID);
						$('#modalItmTyp').text(info.ITM_TYP);
						$('#modalStrNm').text(info.STR_NM);
						$('#modalAcntBlnc').text(fn_comma(info.ACNT_BLNC) + " 원");
						$('#modalCreDttm').text(info.CRE_DTTM);
						fn_modalToggle('#modalAcntInfo');
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
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
</script>
<script type="text/javascript">
	function fn_refresh() {
		selectList();
	}
	function fn_createStrAcnt() {
		var campNos = [];
		var rowChecked = $('#campTable input:checkbox[name=rowCheckbox]:checked');
		rowChecked.each(function (index) {
			var campNo = $(this).parent().parent().children().eq(1).text();
			// console.log(">>>>> " + index + ", " + campNo);
			campNos.push(campNo.trim());
		});
		if (true) console.log(">>>>> campNos = " + campNos.join(','));
		$('#tempForm #_campNos').val(campNos.join(','));
		jQuery.ajax({
			url           : "${staticPATH}/ctr2/coupon/createCouponPackage.do",
			dataType      : "JSON",
			scriptCharset : "UTF-8",
			type          : "POST",
			data          : $('#tempForm').serialize(),
			success: function(result, option) {
				if (option == "success"){
					alert("메시지: " + result.retMsg);
					selectList();
				} else {
					alert("에러가 발생하였습니다.");
				}
			},
			error: function(result, option) {
				alert("에러가 발생하였습니다.");
			}
		});
	}
	function fn_index() {
		fn_loadPostPage('#tempForm', '${staticPATH}/ctr2/index.do');
	}
</script>
</html>
