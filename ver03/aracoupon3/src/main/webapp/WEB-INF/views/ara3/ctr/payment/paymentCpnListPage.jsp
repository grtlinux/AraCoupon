<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>센터 - ${info.CTR_NM}</title>
</head>
<%@ include file="/WEB-INF/views/ara3/common/cssCtr.jsp"%>
<body>
<%@ include file="/WEB-INF/views/ara3/common/navbarCtr.jsp"%>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- container for table panel -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container-fluid">
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;<b>[${menuName}]</b> 가게에서 수거한 쿠폰에 대해 정산을 요청한다. 여기서는 쿠폰갯수와 금액을 확인하고 정산처리를 한다.</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table id="campTable" class="table table-hover table-condensed">
						<thead>
							<tr class="danger text-center">
								<td class="show"><input id='allCheckbox' type='checkbox'></td>
								<td class='hide'>쿠폰액면가0</td>
								<td>쿠폰액면가</td>
								<td>쿠폰번호</td>
								<td>캠페인#</td>
								<td>고객#</td>
								<td>쿠폰마스터</td>
								<td>캠페인기간</td>
								<td>쿠폰사용기간</td>
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
					<input id="sumMsg" type="text" size="40" value="선택된 쿠폰금액: 0 원 (0 장)">
					<button type="button" class="btn btn-info btn-sm" onclick="fn_modalToggle('#modelCalcCpnList');"> 쿠폰정산처리 </button>
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
<%@ include file="/WEB-INF/views/ara3/common/modalSelfInfoCtr.jsp"%>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- modal dialog -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="row">
		<div class="modal" id="modelCalcCpnList" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header alert alert-success">
						결제쿠폰 정산요청<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						<table class="table text-left">
							<tr>
								<td>정산할 쿠폰 금액</td>
								<td><span id="modalSumMny">0</span> 원</td>
							</tr>
							<tr>
								<td>정산할 쿠폰 갯수</td>
								<td><span id="modalSumCnt">0</span> 장</td>
							</tr>
						</table>
						<br>
						<button id='btnCalculateCpnNoList' type="button" class="btn btn-success btn-sm" onclick="fn_calculateCpnNoList();"> 결제쿠폰 정산처리 </button>
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
		<input type='hidden' id='_ctrid' name='ctrid' value='${info.CTR_ID}' />
		<input type="hidden" id="_strid" name="strid" value='' />
		<input type='hidden' id='_sumMny' name='sumMny' value='' />
		<input type='hidden' id='_sumCnt' name='sumCnt' value='' />
		<input type='hidden' id='_cpnNoList' name='cpnNoList' value='' />
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
				if (true) {
					var cpnNoArr = [];
					var sumMny = 0;
					var sumCnt = 0;
					$('input[name=rowCheckbox]:checked').each(function(idx) {
						var tr = $(this).parent().parent();
						var td = tr.children();
						var cpnMny = td.eq(1).text();
						var cpnNo = td.eq(3).text();
						if (!true) console.log(">>>>> row: ", idx, cpnMny, cpnNo);
						cpnNoArr.push(cpnNo.trim());
						sumMny += Number(cpnMny);
						sumCnt ++;
					});
					if (!true) console.log(">>>>> rowCheckbox clicked. (sumMny, sumCnt) = ", sumMny, sumCnt);
					if (sumCnt == 0)
						$('#sumMsg').val("선택된 쿠폰금액: " + fn_comma(sumMny) + " 원 (" + sumCnt + " 장)");
					else
						$('#sumMsg').val("전부선택된 쿠폰금액: " + fn_comma(sumMny) + " 원 (" + sumCnt + " 장)");
					$('#tempForm > #_sumMny').val(sumMny);
					$('#tempForm > #_sumCnt').val(sumCnt);
					$('#tempForm > #_cpnNoList').val(cpnNoArr.join(','));
					$('#modelCalcCpnList #modalSumMny').text(fn_comma(sumMny));
					$('#modelCalcCpnList #modalSumCnt').text(fn_comma(sumCnt));
				}
			});
		}
	}
	function selectList() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		jQuery.ajax({
			url           : "${staticPATH}/ctr2/payment/selectPaymentCpnList.do",
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
						rowHtml += "  <td class='text-center hide'>";
						rowHtml += "    " + value.CPN_MNY;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + fn_comma(value.CPN_MNY) + "원";
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CPN_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CAMP_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.ITM_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CPN_MST;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CAMP_BGN_DT + " ~ " + value.CAMP_END_DT;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.TRM_BGN_DT + " ~ " + value.TRM_END_DT;
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
						*/
						rowHtml += "</tr>";
						$("#campTable > tbody:last").append(rowHtml);
					});
					if (true) $('#campTable > tbody tr td').on('click', function() {
						// not use
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
						$('#modalTrmBgnDt').text(info.TRM_BGN_DT);
						$('#modalTrmEndDt').text(info.TRM_END_DT);
						//
						classFormatter();
						//
						fn_modalToggle('#modalCampNoInfo');
					});
					if (!true) {
						// row를 선택하면 checkbox click 이벤트 발생
						$('#campTable > tbody tr').on('click', function(event) {
							if (event.target.type != 'checkbox') {
								$(':checkbox', this).trigger('click');
							}
						});
					}
					if (true) {
						// checkbox click 이벤트 발생하면 선택된 항목의 금액계산과 쿠폰번호들을 얻는다.
						$('input[name=rowCheckbox]').on('click', function(event) {
							var cpnNoArr = [];
							var sumMny = 0;
							var sumCnt = 0;
							$('input[name=rowCheckbox]:checked').each(function(idx) {
								var tr = $(this).parent().parent();
								var td = tr.children();
								var cpnMny = td.eq(1).text();
								var cpnNo = td.eq(3).text();
								if (!true) console.log(">>>>> row: ", idx, cpnMny, cpnNo);
								cpnNoArr.push(cpnNo.trim());
								sumMny += Number(cpnMny);
								sumCnt ++;
							});
							if (!true) console.log(">>>>> rowCheckbox clicked. (sumMny, sumCnt) = ", sumMny, sumCnt);
							$('#sumMsg').val("선택된 쿠폰금액: " + fn_comma(sumMny) + " 원 (" + sumCnt + " 장)");
							$('#tempForm > #_sumMny').val(sumMny);
							$('#tempForm > #_sumCnt').val(sumCnt);
							$('#tempForm > #_cpnNoList').val(cpnNoArr.join(','));
							$('#modelCalcCpnList #modalSumMny').text(fn_comma(sumMny));
							$('#modelCalcCpnList #modalSumCnt').text(fn_comma(sumCnt));
						});
					}
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
	function fn_calculateCpnNoList() {
		if (true) console.log(">>>>> ", arguments.callee.caller, $('#tempForm').serialize());
		if (true) {
			// validation
		}
		if (true) {
			// transfer
		}
		if (true) {
			// ajax call
			jQuery.ajax({
				url           : "${staticPATH}/ctr2/payment/calculateCpnNoList.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $('#tempForm').serialize(),
				success: function(result, option) {
					if (option == "success"){
						alert("메시지: " + result.retMsg);
						fn_modalToggle('#modelCalcCpnList');
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
	}
	function fn_index() {
		fn_loadPostPage('#tempForm', '${staticPATH}/str2/index.do');
	}
</script>
</html>
