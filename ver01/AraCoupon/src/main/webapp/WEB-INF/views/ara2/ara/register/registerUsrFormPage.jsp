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
<body>
<%@ include file="/WEB-INF/views/ara2/common/navbarAra.jsp"%>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- container for table panel -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container-fluid">
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;<b>[${menuName}]</b> 고객을 등록합니다. (*)는 필수항목입니다. 나중에 아라고객 임을 확인하는데 필요합니다.</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table id="codeTable" class="table">
						<tbody>
							<tr>
								<td class="text-danger" style="width:20%;"> 고객이름 또는 별명(*) </td>
								<td><input id='usrName' class='form-control' type='text' value='' placeholder='이름 또는 별명'></td>
							</tr>
							<tr>
								<td class="text-danger" >고객 이메일 주소(*)</td>
								<td><input id='usrEmail' class='form-control' type='text' value='' placeholder='Email 주소'></td>
							</tr>
							<tr>
								<td class="text-danger" >고객 모바일 번호(*)</td>
								<td>
									<input id='usrMobile' class='bg-danger' type='text' size='25' value='' placeholder='모바일번호를 입력'>&nbsp;('-'를 빼고 입력)&nbsp;&nbsp;
									<!--
									<button id='btnRegisterUsr' type="button" class="btn btn-info btn-sm" onclick="fn_registerUsr();">아라키(AraKey) 발송</button>
									&nbsp;&nbsp; -> &nbsp;&nbsp;
									<input id='arakey' class='bg-danger' type='text' size='20' value='' placeholder='아라키(AraKey)를 입력' disabled>
									-->
								</td>
							</tr>
						</tbody>
					</table>
					<div id="sysbtn" class="col-md-12" style="text-align:right;margin-bottom:10px;">
						<button type="button" class="btn btn-danger btn-sm" onclick="fn_createUsrInfo();"><i class="fa fa-floppy-o" aria-hidden="true"></i> 저장</button>
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


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- all of forms -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<form id='tempForm'>
		<input type='hidden' id='_menuName' name='menuName' value='' />
		<input type='hidden' id='_usrName' name='usrName' value='' />
		<input type='hidden' id='_usrEmail' name='usrEmail' value='' />
		<input type='hidden' id='_usrMobile' name='usrMobile' value='' />
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
		if (true) {
			$('#usrName').focus();
		}
	}
	function selectList() {
		if (true) console.log(">>>>> ", arguments.callee.caller);
	}
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
</script>
<script type="text/javascript">
	function fn_createUsrInfo() {
		if (true) {
			// validate
			if (isEmpty($('#usrName').val())) {
				$('#usrName').focus();
				return false;
			}
			if (isEmpty($('#usrEmail').val())) {
				$('#usrEmail').focus();
				return false;
			}
			if (isEmpty($('#usrMobile').val())) {
				$('#usrMobile').focus();
				return false;
			}
		}
		if (true) {
			// transfer data
			$("#_usrName").val($("#usrName").val());
			$("#_usrEmail").val($("#usrEmail").val());
			$("#_usrMobile").val($("#usrMobile").val());
			$("#_arakey").val($("#arakey").val());
		}
		if (true) {
			// ajax
			jQuery.ajax({
				url           : "${staticPATH}/ara2/register/createUsrInfo.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#tempForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						alert("알림: " + result.retMsg + " (CODE:" + result.retCode + ")");
						fn_index()
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
		fn_loadPostPage('#tempForm', '${staticPATH}/ara2/index.do');
	}
</script>
</html>
