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
				<h3 class="panel-title"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;<b>[${menuName}]</b> 가게에서 수거한 쿠폰에 대해 정산을 요청한다. 여기서는 쿠폰갯수와 금액을 확인하고 정산처리를 한다.</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table id="campTable" class="table table-hover table-condensed">
						<thead>
							<tr class="danger text-center">
								<td class="show"><input id='allCheckbox' type='checkbox'></td>
								<td class='hide'>쿠폰금액0</td>
								<td>캠페인번호</td>
								<td>가게번호</td>
								<td class='hide'>가게타입</td>
								<td>쿠폰단계</td>
								<td>쿠폰마스터</td>
								<td class='hide'>쿠폰타입</td>
								<td>쿠폰금액</td>
								<td>쿠폰번호</td>
								<td>쿠폰내용</td>
								<td>캠페인기간</td>
								<td>쿠폰사용기간</td>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<div id="sysbtn" class="col-md-12" style="text-align:right;margin-bottom:10px;">
					<input id="sumMsg" type="text" size="40" value="선택된 쿠폰금액: 0 원 (0 장)">
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
<%@ include file="/WEB-INF/views/ara2/common/modalSelfInfoCtr.jsp"%>



	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- all of forms -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<form id='tempForm'>
		<input type='hidden' id='_menuName' name='menuName' value='' />
		<input type='hidden' id='_ctrid' name='ctrid' value='${info.CTR_ID}' />
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
		if (true) {
			$('.numberToMoney').each(function() {
				$(this).text(numberToMoney($(this).text()));
			});
		}
	}
	function selectList() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		jQuery.ajax({
			url           : "${staticPATH}/ctr2/payment/selectCompleteCalcList.do",
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
						rowHtml += "<tr class='text-center'>";
						rowHtml += "  <td>";
						rowHtml += "    <input type='checkbox' name='rowCheckbox'>";
						rowHtml += "  </td>";
						rowHtml += "  <td class='hide'>";
						rowHtml += "    " + value.CPN_MNY;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CAMP_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.ITM_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td class='hide'>";
						rowHtml += "    " + value.ITM_TYP;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CPN_PHS + ":" + value.CD_DESC;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CPN_MST;
						rowHtml += "  </td>";
						rowHtml += "  <td class='hide'>";
						rowHtml += "    " + value.CPN_TYP;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CPN_MNY;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CPN_NO;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CPN_CNTNT;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.CAMP_BGN_DT + " ~ " + value.CAMP_END_DT;
						rowHtml += "  </td>";
						rowHtml += "  <td class='text-center'>";
						rowHtml += "    " + value.TRM_BGN_DT + " ~ " + value.TRM_END_DT;
						rowHtml += "  </td>";
						rowHtml += "</tr>";
						$("#campTable > tbody:last").append(rowHtml);
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
	function fn_index() {
		fn_loadPostPage('#tempForm', '${staticPATH}/str2/index.do');
	}
</script>
</html>
