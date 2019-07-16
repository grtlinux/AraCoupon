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
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;캠페인을 만든다. 캠페인은 쿠폰페키지를 만드는 행사이다. 쿠폰페키지는 같은 액면가의 쿠폰뭉치이다.</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table id="codeTable" class="table">
						<tbody>
							<tr>
								<td style="width:20%;"> 캠페인 명칭 </td>
								<td><input id='campNm' class='form-control' type='text' value='캠페인명'></td>
							</tr>
							<tr>
								<td>캠페인 설명</td>
								<td><input id='campDesc' class='form-control' type='text' value='캠페인설명'></td>
							</tr>
							<tr>
								<td>캠페인 시작일</td>
								<td><input id='campBgnDt' type="date" placeholder="date" value='${period.BGN_DT}'></td>
							</tr>
							<tr>
								<td>캠페인 종료일</td>
								<td><input id='campEndDt' type="date" placeholder="date" value='${period.END_DT}'> (보통 시작일에서 1개월 정도로 한다.)</td>
							</tr>
							<tr>
								<td>쿠폰 종류</td>
								<td>
									<select id="campCpnTyp">
										<c:forEach var="typ" items="${lstAraCpnTyp}">
											<option value="${typ.CODE}:${typ.CD_NM}" <c:if test="${typ.CODE == '005'}">selected</c:if> >${typ.CD_DESC}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td>쿠폰 갯수</td>
								<td>
									<label class="label-inline"><input id='campCpnCnt' type='number' value='10'></label>
									<label class="label-inline"> &nbsp;&nbsp; 쿠폰패키지금액=</label>
									<label class="label-inline"><input id='campCpnSum' class='commaNumbers bg-danger' type='text' value='0' readonly></label>
									<br>
									(0보다 큰값을 입력하세요. 반드시 쿠폰패키지금액을 확인한다.)
								</td>
							</tr>
							<tr>
								<td>쿠폰 내용</td>
								<td><input id='campCpnCntnt' class='form-control' type='text' value='테스트를 위한 쿠폰입니다.'></td>
							</tr>
							<tr class="hide">
								<td>그룹 선택</td>
								<td>
									<input id='campGrp' type='checkbox' name='campGrp' value='FOOD' checked> 음식업 <br>
									<input id='campGrp' type='checkbox' name='campGrp' value='SEEING' checked> 여행업 <br>
									<input id='campGrp' type='checkbox' name='campGrp' value='VIHICLE'> 교통업
								</td>
							</tr>
						</tbody>
					</table>
					<div id="sysbtn" class="col-md-12" style="text-align:right;margin-bottom:10px;">
						<button type="button" class="btn btn-danger btn-sm" onclick="fn_createCampInfo();"><i class="fa fa-floppy-o" aria-hidden="true"></i> 저장</button>
						<button type="button" class="btn btn-success btn-sm" onclick="fn_index();"><i class="fa fa-times" aria-hidden="true"></i> 닫기</button>
					</div>
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
							<table class="table">
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
						<img src="${staticPATH}/bootstrap3/images/steve-jobs.png" style="width:250px;">
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
		<input type='hidden' id='_ctrid'  name='ctrid'  value='${info.CTR_ID}' />
		<input type='hidden' id='_arakey' name='arakey' value='' />
	</form>

	<form id='createCampForm'>
		<input type='hidden' id='_ctrid'        name='ctrid'         value='${info.CTR_ID}' />
		<input type='hidden' id='_campNm'       name='campNm'        value='' />
		<input type='hidden' id='_campDesc'     name='campDesc'      value='' />
		<input type='hidden' id='_campBgnDt'    name='campBgnDt'     value='' />
		<input type='hidden' id='_campEndDt'    name='campEndDt'     value='' />
		<input type='hidden' id='_campCpnTyp'   name='campCpnTyp'    value='' />
		<input type='hidden' id='_campCpnMny'   name='campCpnMny'    value='' />
		<input type='hidden' id='_campCpnCnt'   name='campCpnCnt'    value='' />
		<input type='hidden' id='_campCpnSum'   name='campCpnSum'    value='' />
		<input type='hidden' id='_campCpnCntnt' name='campCpnCntnt'  value='' />
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
		selectList();
	});
	$(document).ready(function(){
		if (true) console.log("step-2: $(document).ready(function(){})");
	});
	function processEvent() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		if (true) $('#campCpnTyp').on('change', function() {
			if (true) console.log(">>>>> select: " + $(this).find('option:selected').val());
			var price = $('#campCpnTyp').find('option:selected').val().substring(4);
			var count = $('#campCpnCnt').val();
			if (count < 0) {
				$('#campCpnCnt').val(0).focus();
				return;
			}
			var cpnSum = price * count;
			if (!true) console.log(">>>>> cpnSum = " + cpnSum.toLocaleString());
			$('#campCpnSum').val(cpnSum.toLocaleString());
		});
		if (true) $('#campCpnCnt').on('change', function() {
			var price = $('#campCpnTyp').find('option:selected').val().substring(4);
			var count = $('#campCpnCnt').val();
			if (count < 0) {
				$('#campCpnCnt').val(0).focus();
				return;
			}
			var cpnSum = price * count;
			if (!true) console.log(">>>>> cpnSum = " + cpnSum.toLocaleString());
			$('#campCpnSum').val(cpnSum.toLocaleString());
		});
		if (true) $('#campCpnCnt').trigger('change');
	}
	function selectList() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
	}
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
</script>
<script type="text/javascript">
	function fn_createCampInfo() {
		if (true) {
			// validate
			if (isEmpty($('#campNm').val())) {
				$('#campNm').focus();
				return false;
			}
			if (isEmpty($('#campDesc').val())) {
				$('#campDesc').focus();
				return false;
			}
			if (isEmpty($('#campBgnDt').val())) {
				$('#campBgnDt').focus();
				return false;
			}
			if (isEmpty($('#campEndDt').val())) {
				$('#campEndDt').focus();
				return false;
			}
			if (isEmpty($('#campCpnCnt').val())) {
				$('#campCpnCnt').focus();
				return false;
			}
			if ($('#campCpnCnt').val() <= 0) {
				$('#campCpnCnt').focus();
				return false;
			}
			if ($('#campCpnCnt').val() > 100) {
				alert("쿠폰갯수가 100장을 넘을 수 없습니다.");
				$('#campCpnCnt').focus();
				return false;
			}
			if (isEmpty($('#campCpnCntnt').val())) {
				$('#campCpnCntnt').focus();
				return false;
			}
		}
		if (true) {
			var grp = [];
			$.each($('input[name=campGrp]:checked'), function() {
				grp.push($(this).val());
			});
			if (true) console.log(">>>>> " + grp.join(', '));
			
			var typ = $('#campCpnTyp').find('option:selected').val();
			var mny = typ.substring(4);
			var typ = typ.substring(0, 3);
			var cnt = $("#campCpnCnt").val();
			var sum = cnt * mny;
			if (sum > 1000000) {
				alert("쿠폰발행금액이 10,000,000원을 넘을 수 없습니다.");
				$('#campCpnCnt').focus();
				return false;
			}
			// transfer data
			$("#_campNm").val($("#campNm").val());
			$("#_campDesc").val($("#campDesc").val());
			$("#_campBgnDt").val($("#campBgnDt").val());
			$("#_campEndDt").val($("#campEndDt").val());
			$("#_campCpnTyp").val(typ);
			$("#_campCpnMny").val(mny);
			$("#_campCpnCnt").val(cnt);
			$("#_campCpnSum").val(sum);
			$("#_campCpnCntnt").val($("#campCpnCntnt").val());
			$("#_campGrp").val(grp.join(','));
		}
		if (true) {
			// ajax
			jQuery.ajax({
				url           : "${staticPATH}/ctr2/coupon/createCampInfo.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#createCampForm").serialize(),
				success: function(result, option) {
					if (option == "success" && result.retCode == "0000") {
						alert("알림: " + result.retMsg + " (CODE:" + result.retCode + ")");
						fn_loadPostPage('#tempForm', '${staticPATH}/ctr2/coupon/executeCampListPage.do');
					} else {
						alert("알림: " + result.retMsg + " (CODE:" + result.retCode + ")");
						fn_index();
					}
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.");
					fn_index();
				}
			});
		}
	}
	function fn_index() {
		fn_loadPostPage('#tempForm', '${staticPATH}/ctr2/index.do');
	}
</script>
</html>
