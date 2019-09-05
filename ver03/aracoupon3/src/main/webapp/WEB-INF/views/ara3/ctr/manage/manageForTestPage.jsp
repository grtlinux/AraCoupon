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
				<h3 class="panel-title"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;<b>[${menuName}]</b> 센터에서 관리를 위한 페이지.</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table id="campTable" class="table table-hover table-condensed">
						<thead>
							<tr class="danger">
								<td class="text-center" style="width:20%;">버 튼</td>
								<td class="text-center">내 용</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center"><button type="button" class="btn btn-danger btn-sm" onclick="fn_deleteTablesForOpen();"> 오픈시점 자료삭제 </button></td>
								<td class="text-left">오픈 시점으로 자료를 삭제한다.</td>
							</tr>
							<tr>
								<td class="text-center"><button type="button" class="btn btn-danger btn-sm" onclick="fn_createAllLoginInfo();"> 로그인 자료 생성 </button></td>
								<td class="text-left">아라쿠폰서비스시스템의 로그인 자료를 일괄 생성한다. 기존 자료는 삭제된다.</td>
							</tr>
							<tr>
								<td class="text-center"><button type="button" class="btn btn-danger btn-sm" onclick="fn_deleteTablesForOpen();"> 금액일괄 가게지급 </button></td>
								<td class="text-left">센터에서 모든 가게에 일괄적으로 같은 금액을 입금한다.</td>
							</tr>
							<tr>
								<td class="text-center"><button type="button" class="btn btn-danger btn-sm" onclick="fn_deleteTablesForOpen();"> 쿠폰사용기간 조정 </button></td>
								<td class="text-left">쿠폰의 사용기간을 각 건별로 조정한다.</td>
							</tr>
							<tr>
								<td class="text-center"><button type="button" class="btn btn-danger btn-sm" onclick="fn_deleteTablesForOpen();"> 쿠폰정보 변경취소 </button></td>
								<td class="text-left">쿠폰에 대한 정보를 개별적으로 변경하거나 취소할 수 있다. 쿠폰이력을 활용.</td>
							</tr>
							<tr>
								<td class="text-center"><button type="button" class="btn btn-danger btn-sm" onclick="fn_deleteTablesForOpen();"> 아라쿠폰 관리세팅 </button></td>
								<td class="text-left">아라쿠폰서비스시스템 환경정보 세팅 화면.</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="sysbtn" class="col-md-12" style="text-align:right;margin-bottom:10px;">
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


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- all of forms -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<form id='tempForm'>
		<input type='hidden' id='_menuName' name='menuName' value='' />
		<input type='hidden' id='_ctrid' name='ctrid' value='${info.CTR_ID}' />
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
		selectList();
	});
	$(document).ready(function(){
		if (true) console.log("step-2: $(document).ready(function(){})");
	});
	function processEvent() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
	}
	function selectList() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
	}
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
</script>
<script type="text/javascript">
	function fn_refresh() {
		selectList();
	}
	function fn_deleteTablesForOpen() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		if (!confirm("진심으로 삭제 하시겠습니까?")){
			return;
		}
		jQuery.ajax({
			url           : "${staticPATH}/ctr2/manage/deleteTablesForOpen.do",
			dataType      : "JSON",
			scriptCharset : "UTF-8",
			type          : "POST",
			data          : $('#tempForm').serialize(),
			success: function(result, option) {
				if (option == "success"){
					fn_returnAlert(result);
				} else {
					alert("에러가 발생하였습니다.");
				}
			},
			error: function(result, option) {
				alert("에러가 발생하였습니다.");
			}
		});
	}
	function fn_createAllLoginInfo() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
		if (!confirm("진심으로 로그인 모든정보를 삭제하고 새로 생성 하시겠습니까?")){
			return;
		}
		jQuery.ajax({
			url           : "${staticPATH}/ctr2/manage/createAllLoginInfo.do",
			dataType      : "JSON",
			scriptCharset : "UTF-8",
			type          : "POST",
			data          : $('#tempForm').serialize(),
			success: function(result, option) {
				if (option == "success"){
					fn_returnAlert(result);
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
