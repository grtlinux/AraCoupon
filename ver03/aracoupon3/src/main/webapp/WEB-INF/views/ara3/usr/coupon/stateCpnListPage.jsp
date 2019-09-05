<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>고객 - ${info.USR_NM}</title>
</head>
<%@ include file="/WEB-INF/views/ara3/common/cssUsr.jsp"%>
<body>
<%@ include file="/WEB-INF/views/ara3/common/navbarUsr.jsp"%>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- container for table panel -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container-fluid">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;<b>[${menuName}]</b> 고객의 갖고 있는 쿠폰을 보여준다.</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table id="campTable" class="table table-hover table-condensed">
						<thead>
							<tr class="info text-center">
								<td class="show"><input id='allCheckbox' type='checkbox'></td>
								<td>캠페인#</td>
								<td>고객#</td>
								<td>쿠폰액면가</td>
								<td>쿠폰마스터</td>
								<td>쿠폰번호</td>
								<td>캠페인시작일</td>
								<td>캠페인종료일</td>
								<!--
								<td>캠페인#</td>
								<td>고객#</td>
								<td>고객타입</td>
								<td>쿠폰단계#</td>
								<td>쿠폰단계</td>
								<td>쿠폰마스터</td>
								<td>쿠폰타입</td>
								<td>쿠폰액면가</td>
								<td>쿠폰번호</td>
								<td>쿠폰내용</td>
								<td>쿠폰생성일</td>
								<td>쿠폰갱신일</td>
								<td>캠페인명</td>
								<td>캠페인단계#</td>
								<td>캠페인단계</td>
								<td>캠페인시작일</td>
								<td>캠페인종료일</td>
								-->
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<div id="sysbtn" class="col-md-12" style="text-align:right;margin-bottom:10px;">
					<button type="button" class="btn btn-info btn-sm" onclick="fn_refresh();"> 새로고침 </button>
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


<%@ include file="/WEB-INF/views/ara3/common/footer.jsp"%>
<%@ include file="/WEB-INF/views/ara3/common/modalSelfInfoUsr.jsp"%>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- modal dialog -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="row">
		<div class="modal" id="modalCampNoInfo" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header alert alert-success">
						쿠폰 정보<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						<table class="table text-left">
							<tr>
								<td>캠페인 번호</td>
								<td><div id="modalCampNo"></div></td>
							</tr>
							<tr>
								<td>고객 번호</td>
								<td><div id="modalItmNo"></div></td>
							</tr>
							<tr class="hide">
								<td>고객 타입</td>
								<td><div id="modalItmTyp"></div></td>
							</tr>
							<tr class="hide">
								<td>쿠폰단계 번호</td>
								<td><div id="modalCpnPhs"></div></td>
							</tr>
							<tr class="hide">
								<td>쿠폰 단계</td>
								<td><div id="modalCdDesc"></div></td>
							</tr>
							<tr>
								<td>쿠폰 마스터</td>
								<td><div id="modalCpnMst"></div></td>
							</tr>
							<tr class="hide">
								<td>쿠폰 타입</td>
								<td><div id="modalCpnTyp"></div></td>
							</tr>
							<tr>
								<td>쿠폰 액면가</td>
								<td><div id="modalCpnMny"></div></td>
							</tr>
							<tr>
								<td>쿠폰 번호</td>
								<td><div id="modalCpnNo"></div></td>
							</tr>
							<tr class="hide">
								<td>쿠폰 내용</td>
								<td><span id="modalCpnCntnt"></span></td>
							</tr>
							<tr class="hide">
								<td>쿠폰 생성일</td>
								<td><div id="modalCreDttm"></div></td>
							</tr>
							<tr class="hide">
								<td>쿠폰 갱신일</td>
								<td><div id="modalUpdDttm"></div></td>
							</tr>
							<tr>
								<td>캠페인 명</td>
								<td><div id="modalCampNm"></div></td>
							</tr>
							<tr class="hide">
								<td>캠페인단계 번호</td>
								<td><div id="modalCampPhs"></div></td>
							</tr>
							<tr class="hide">
								<td>캠페인 단계</td>
								<td><div id="modalCampCdDesc"></div></td>
							</tr>
							<tr>
								<td>캠페인 시작일</td>
								<td><div id="modalCampBgnDt"></div></td>
							</tr>
							<tr>
								<td>캠페인 종료일</td>
								<td><div id="modalCampEndDt"></div></td>
							</tr>
						</table>
						<img class="hide" src="${staticPATH}/bootstrap3/images/LEGO_Logo.jpg" style="width:50px;">
						<br>
						<button id='btnBuyCpnList' type="button" class="btn btn-success btn-sm hide" onclick="fn_buyCpnList();"> 쿠폰 구매 </button>
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
		<input type='hidden' id='_usrid' name='usrid' value='${info.USR_ID}' />
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
		if (true) {
			$('#allCheckbox').on('change', function() {
				var flgAllCheckbox = $('#allCheckbox').is(':checked');
				if (!true) console.log('>>>>> #allCheckbox change is ' + flgAllCheckbox);
				$('input:checkbox[name="rowCheckbox"]').prop('checked', flgAllCheckbox);
			});
		}
	}
	function selectList() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		jQuery.ajax({
			url           : "${staticPATH}/usr2/coupon/selectStateCpnList.do",
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
						rowHtml += "    " + value.CAMP_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.ITM_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + fn_comma(value.CPN_MNY) + "원";
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CPN_MST;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CPN_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CAMP_BGN_DT;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CAMP_END_DT;
						rowHtml += "  </td>";
						/*
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CAMP_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.ITM_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.ITM_TYP;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    (" + value.CPN_PHS;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CD_DESC;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CPN_MST;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CPN_TYP;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CPN_MNY;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CPN_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center text-danger'>";
						rowHtml += "    " + value.CPN_CNTNT;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center text-danger'>";
						rowHtml += "    " + value.CRE_DTTM;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center text-danger'>";
						rowHtml += "    " + value.UPD_DTTM;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CAMP_NM;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CAMP_PHS;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CAMP_CD_DESC;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CAMP_BGN_DT;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CAMP_END_DT;
						rowHtml += "  </td>";
						rowHtml += "</tr>";
						*/
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
						$('#modalCampNo').text(info.CAMP_NO);
						$('#modalItmNo').text(info.ITM_NO);
						$('#modalItmTyp').text(info.ITM_TYP);
						$('#modalCpnPhs').text(info.CPN_PHS);
						$('#modalCdDesc').text(info.CD_DESC);
						$('#modalCpnMst').text(info.CPN_MST);
						$('#modalCpnTyp').text(info.CPN_TYP);
						$('#modalCpnMny').text(info.CPN_MNY);
						$('#modalCpnNo').text(info.CPN_NO);
						$('#modalCpnCntnt').text(info.CPN_CNTNT);
						$('#modalCreDttm').text(info.CRE_DTTM);
						$('#modalUpdDttm').text(info.UPD_DTTM);
						$('#modalCampNm').text(info.CAMP_NM);
						$('#modalCampPhs').text(info.CAMP_PHS);
						$('#modalCampCdDesc').text(info.CAMP_CD_DESC);
						$('#modalCampBgnDt').text(info.CAMP_BGN_DT);
						$('#modalCampEndDt').text(info.CAMP_END_DT);
						fn_modalToggle('#modalCampNoInfo');
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
	function fn_index() {
		fn_loadPostPage('#tempForm', '${staticPATH}/usr2/index.do');
	}
</script>
</html>
