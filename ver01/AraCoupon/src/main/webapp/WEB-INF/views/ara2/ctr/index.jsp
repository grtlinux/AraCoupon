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
<%@ include file="/WEB-INF/views/ara2/common/jumbotron.jsp"%>



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
						<img class="hide" src="${staticPATH}/bootstrap3/images/steve-jobs.png" style="width:250px;">
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
</script>
</html>
