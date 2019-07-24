<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>가게 - ${info.STR_NM}</title>
</head>
<%@ include file="/WEB-INF/views/ara2/common/cssStr.jsp"%>
<body>
<%@ include file="/WEB-INF/views/ara2/common/navbarStr.jsp"%>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- container for table panel -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container-fluid">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;<b>[${menuName}]</b> 쿠폰패키지목록에서 원하는 쿠폰패키지를 선택하면 원하는 쿠폰갯수 만큼 구매할 수 있다.</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table id="campTable" class="table table-hover table-condensed">
						<thead>
							<tr class="info text-center">
								<td class="show"><input id='allCheckbox' type='checkbox'></td>
								<td>캠페인#</td>
								<td>캠페인명</td>
								<td>캠페인설명</td>
								<td>캠페인단계</td>
								<td>캠페인기간</td>
								<!--
								<td>시작일</td>
								<td>종료일</td>
								<td>쿠폰타입</td>
								-->
								<td>액면가</td>
								<!--
								<td class='text-danger'>갯수</td>
								-->
								<td class='text-danger'>사용/남음/전체</td>
								<td>쿠폰합계</td>
								<td>쿠폰마스터</td>
								<!--
								<td>캠페인내</td>
								-->
								<td>캠페인생성일시</td>
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
<%@ include file="/WEB-INF/views/ara2/common/modalSelfInfoStr.jsp"%>


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
						캠페인 정보<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						<table class="table text-left">
							<tr>
								<td>캠페인 번호</td>
								<td><div id="modalCampNo"></div></td>
							</tr>
							<tr>
								<td>캠페인 명칭</td>
								<td><div id="modalCampNm"></div></td>
							</tr>
							<tr class="hide">
								<td>캠페인 설명</td>
								<td><div id="modalCampDesc"></div></td>
							</tr>
							<tr>
								<td>캠페인 단계</td>
								<td><div id="modalCampPhs"></div></td>
							</tr>
							<tr class="hide">
								<td>캠페인 시작일</td>
								<td><div id="modalBgnDt"></div></td>
							</tr>
							<tr class="hide">
								<td>캠페인 종료일</td>
								<td><div id="modalEndDt"></div></td>
							</tr>
							<tr>
								<td>캠페인 기간</td>
								<td><div id="modalPeriod"></div></td>
							</tr>
							<tr class="hide">
								<td>쿠폰 타입</td>
								<td><div id="modalCpnTyp"></div></td>
							</tr>
							<tr>
								<td>쿠폰 액면가</td>
								<td><div id="modalCpnMny"></div></td>
							</tr>
							<tr class="hide">
								<td>쿠폰 갯수</td>
								<td><div id="modalCpnCnt"></div></td>
							</tr>
							<tr>
								<td>구매된 갯수</td>
								<td><div id="modalBuyCnt"></div></td>
							</tr>
							<tr>
								<td>미사용 갯수</td>
								<td><span id="modalRmnCnt"></span>&nbsp;&nbsp;<input id="cpnSiz" class="text-success" type="number"></td>
							</tr>
							<tr>
								<td>전체 갯수</td>
								<td><div id="modalTtlCnt"></div></td>
							</tr>
							<tr class="hide">
								<td>쿠폰패키지 금액</td>
								<td><div id="modalCpnSum"></div></td>
							</tr>
							<tr class="hide">
								<td>쿠폰 마스터키</td>
								<td><div id="modalCpnMst"></div></td>
							</tr>
							<tr class="hide">
								<td>캠페인 내용</td>
								<td><div id="modalCampCntnt"></div></td>
							</tr>
							<tr class="hide">
								<td>캠페인 생성일시</td>
								<td><div id="modalCreDttm"></div></td>
							</tr>
							<tr class="hide">
								<td>캠페인 단계명</td>
								<td><div id="modalCdNm"></div></td>
							</tr>
						</table>
						<img class="hide" src="${staticPATH}/bootstrap3/images/LEGO_Logo.jpg" style="width:50px;">
						<br>
						<button id='btnBuyCpnList' type="button" class="btn btn-success btn-sm" onclick="fn_buyCpnList();"> 쿠폰 구매 </button>
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
		<input type='hidden' id='_strid' name='strid' value='${info.STR_ID}' />
		<input type='hidden' id='_campNo' name='campNo' value='' />
		<input type='hidden' id='_cpnSiz' name='cpnSiz' value='' />
		<input type='hidden' id='_cpnMny' name='cpnMny' value='' />
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
			url           : "${staticPATH}/str2/coupon/selectCampList2.do",
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
						rowHtml += "  <td>";
						rowHtml += "    " + value.CAMP_NM;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CAMP_DESC;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    (" + value.CAMP_PHS + ")" + value.CD_NM;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.BGN_DT + " ~ " + value.END_DT;
						rowHtml += "  </td>";
						//rowHtml += "  <td>";
						//rowHtml += "    " + value.BGN_DT;
						//rowHtml += "  </td>";
						//rowHtml += "  <td>";
						//rowHtml += "    " + value.END_DT;
						//rowHtml += "  </td>";
						//rowHtml += "  <td class='text-center'>";
						//rowHtml += "    " + value.CPN_TYP;
						//rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + fn_comma(value.CPN_MNY);
						rowHtml += "  </td>";
						//rowHtml += "  <td class='text-center text-danger'>";
						//rowHtml += "    " + fn_comma(value.CPN_CNT);
						//rowHtml += "  </td>";
						rowHtml += "  <td class='text-center text-danger'>";
						rowHtml += "    " + value.BUY_CNT + "/" + value.RMN_CNT + "/" + value.TTL_CNT;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + fn_comma(value.CPN_SUM);
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CPN_MST;
						rowHtml += "  </td>";
						//rowHtml += "  <td>";
						//rowHtml += "    " + value.CAMP_CNTNT;
						//rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CRE_DTTM;
						rowHtml += "  </td>";
						//rowHtml += "  <td>";
						//rowHtml += "    " + value.CD_NM;
						//rowHtml += "  </td>";
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
						$('#modalCampNo').text(info.CAMP_NO);
						$('#modalCampNm').text(info.CAMP_NM);
						$('#modalCampDesc').text(info.CAMP_DESC);
						$('#modalCampPhs').text("(" + info.CAMP_PHS + ") " + info.CD_NM);
						$('#modalBgnDt').text(info.BGN_DT);
						$('#modalEndDt').text(info.END_DT);
						$('#modalPeriod').text(info.BGN_DT + " - " + info.END_DT);
						$('#modalCpnTyp').text(info.CPN_TYP);
						$('#modalCpnMny').text(info.CPN_MNY);
						$('#modalCpnCnt').text(info.CPN_CNT);
						$('#modalBuyCnt').text(info.BUY_CNT);
						$('#modalRmnCnt').text(info.RMN_CNT);
						$('#modalTtlCnt').text(info.TTL_CNT);
						$('#modalCpnSum').text(info.CPN_SUM);
						$('#modalCpnMst').text(info.CPN_MST);
						$('#modalCampCntnt').text(info.CAMP_CNTNT);
						$('#modalCreDttm').text(info.CRE_DTTM);
						$('#modalCdNm').text(info.CD_NM);
						//
						$('#modalCampNoInfo #cpnSiz').val(info.RMN_CNT);
						$('#tempForm #_campNo').val(info.CAMP_NO);
						$('#tempForm #_cpnMny').val(info.CPN_MNY);
						//
						//$('#modalCpnSum').text(fn_comma(info.CPN_SUM) + " 원");
						//$('#modalCpnMny').text(fn_comma(info.CPN_MNY) + " 원");
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
	function fn_buyCpnList() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		$('#tempForm #_cpnSiz').val($('#modalCampNoInfo #cpnSiz').val());
		jQuery.ajax({
			url           : "${staticPATH}/str2/coupon/buyCpnList.do",
			dataType      : "JSON",
			scriptCharset : "UTF-8",
			type          : "POST",
			data          : $('#tempForm').serialize(),
			success: function(result, option) {
				if (option == "success"){
					alert("메시지: " + result.retMsg);
					fn_modalToggle('#modalCampNoInfo');
					fn_refresh();
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
		fn_loadPostPage('#tempForm', '${staticPATH}/str2/index.do');
	}
</script>
</html>
