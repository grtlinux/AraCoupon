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
<link rel="stylesheet" href="${staticPATH}/bootstrap3/css/codingBooster5.css">
<style type="text/css">
	.jumbotron {
		background-image: url('${staticPATH}/bootstrap3/images/jumbotronBackground.jpg');
		background-size: cover;
		text-shadow: black 0.4em 0.4em 0.4em;
		color: white;
	}
</style>
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
<!-- body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="" -->

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- navigation -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${staticPATH}/ara.do">ACSS</a>
			</div>
			<div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
				<!-- navbar menu -->
				<ul class="nav navbar-nav navbar-left">
					<li><a data-target="#modal0" data-toggle="modal" href="#" onclick="fn_console('toggle event after click event.....');">내 정보</a></li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰발행<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('${staticPATH}/str/coupon/createCampFormPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰패키지 생성</a></li>
							<!-- li class="divider"></li -->
							<li><a href="javascript:fn_loadPostPage('${staticPATH}/str/coupon/apprReqListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰패키지 신청목록</a></li>
							<li><a href="javascript:fn_loadPostPage('${staticPATH}/str/coupon/apprResListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰펰키지 승인목록</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰제공<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('${staticPATH}/str/provide/giveCoupon.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰제공</a></li>
							<li><a href="javascript:fn_loadPostPage('${staticPATH}/str/provide/listCoupon.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;제공된 쿠폰목록</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰결제<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('${staticPATH}/str/payment/listPayment.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;결제목록</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰정산<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('${staticPATH}/str/calculate/listCalculate.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;정산목록</a></li>
						</ul>
					</li>
					<!--
					<li><a href="/sample05/">통계</a></li>
					-->
				</ul>

				<!-- login menu -->
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span><span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${staticPATH}/str/login/login.do"><span class="glyphicon glyphicon-log-in"></span>&nbsp;로그인</a></li>
							<li><a href="${staticPATH}/str/login/register.do"><span class="glyphicon glyphicon-edit"></span>&nbsp;회원등록</a></li>
							<li><a href="${staticPATH}/str/login/logout.do"><span class="glyphicon glyphicon-log-out"></span>&nbsp;로그아웃</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- gap -->
	<div style="height:70px;"></div>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- container for table panel -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container-fluid">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;캠페인 쿠폰페키지를 만든다.</h3>
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
								<td><input id='campDesc' class='form-control' type='text' value='캠페인설명 00 000 YYMMDD 9'></td>
							</tr>
							<tr>
								<td>캠페인 시작일</td>
								<td><input id='campBgnDt' type="date" placeholder="date" value='2019-06-01'></td>
							</tr>
							<tr>
								<td>캠페인 종료일</td>
								<td><input id='campEndDt' type="date" placeholder="date" value='2019-06-30'> (보통 시작일에서 1개월 정도로 한다.)</td>
							</tr>
							<tr>
								<td>오퍼 종류</td>
								<td>
									<input id='offTypCpn' type='radio' name='campOffTyp' value='CPN' checked> 쿠폰(Coupon)<br>
									<input id='offTypGft' type='radio' name='campOffTyp' value='GFT' disabled> 선물(Gift)
								</td>
							</tr>
							<tr>
								<td>쿠폰 종류</td>
								<td>
									<select id="cpnTyp">
										<option value="01:10000">10,000원</option>
										<option value="02:20000">20,000원</option>
										<option value="03:50000" selected>50,000원</option>
										<option value="04:100000">100,000원</option>
										<option value="05:150000">150,000원</option>
										<option value="06:200000">200,000원</option>
										<option value="07:300000">300,000원</option>
										<option value="08:500000">500,000원</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>쿠폰 갯수</td>
								<td>
									<label class="label-inline"><input id='campCpnCnt' type='number' value='0'></label>
									<label class="label-inline"> &nbsp;&nbsp; 쿠폰패키지금액=</label>
									<label class="label-inline"><input id='campMulti' class='commaNumbers bg-danger' type='text' value='0' readonly></label>
									<br>
									(0보다 큰값을 입력하세요. 반드시 쿠폰패키지금액을 확인한다.)
								</td>
							</tr>
							<tr id='hidden' style="display:none;">
								<td>그룹 선택</td>
								<td>
									<input id='campGrp' type='checkbox' name='campGrp' value='FOOD'> 음식업 <br>
									<input id='campGrp' type='checkbox' name='campGrp' value='SEEING'> 여행업 <br>
									<input id='campGrp' type='checkbox' name='campGrp' value='VIHICLE'> 교통업
								</td>
							</tr>
							<tr>
								<td>오퍼 설명</td>
								<td><input id='offDesc' class='form-control' type='text' value='오퍼설명'></td>
							</tr>
							<tr>
								<td>쿠폰 명칭</td>
								<td><input id='cpnNm' class='form-control' type='text' value='쿠폰명'></td>
							</tr>
							<tr>
								<td>채널 종류</td>
								<td>
									<input id='chlTypSms' type='radio' name='campChlTyp' value='SMS' checked> 문자메시지(SMS)<br>
									<input id='chlTypEml' type='radio' name='campChlTyp' value='EML' disabled> 이메일(Email)
								</td>
							</tr>
							<tr>
								<td>채널 설명</td>
								<td><input id='chlDesc' class='form-control' type='text' value='채널설명'></td>
							</tr>
							<tr>
								<td>SMS 명칭</td>
								<td><input id='smsNm' class='form-control' type='text' value='SMS명'></td>
							</tr>
						</tbody>
					</table>
					<div id="sysbtn" class="col-md-12" style="text-align:right;margin-bottom:10px;">
						<button type="button" class="btn btn-danger btn-sm" onclick="fn_saveCampInfo();"><i class="fa fa-floppy-o" aria-hidden="true"></i> 저장</button>
						<button type="button" class="btn btn-success btn-sm" onclick="fn_close();"><i class="fa fa-times" aria-hidden="true"></i> 닫기</button>
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


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- footer -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<footer class="footer-default">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 text-center">
					<h6>
						ACSS ( Ara Coupon Service System )<br>
						Copyright &copy; 2014 ~ 2018, 2019 TAIN Inc.
					</h6>
				</div>
			</div>
		</div>
	</footer>


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
					<div class="modal-header">
						코딩부스터의 특징<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						저희 서비스의 특징은 바로 강의를 들을 수 있다는 점입니다.<br>
						특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<br><br>
						<img src="${staticPATH}/bootstrap3/images/LEGO_Logo.jpg" style="width:250px;">
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
	</form>
	<form id='saveCampInfoForm'>
		<input type='hidden' id='_strid'        name='strid'         value='${info.STR_ID}' />
		<input type='hidden' id='_campNm'       name='campNm'        value='' />
		<input type='hidden' id='_campDesc'     name='campDesc'      value='' />
		<input type='hidden' id='_campBgnDt'    name='campBgnDt'     value='' />
		<input type='hidden' id='_campEndDt'    name='campEndDt'     value='' />
		<input type='hidden' id='_campOffTyp'   name='campOffTyp'    value='' />
		<input type='hidden' id='_campCpnTyp'   name='campCpnTyp'    value='' />
		<input type='hidden' id='_campCpnCnt'   name='campCpnCnt'    value='' />
		<input type='hidden' id='_campGrp'      name='campGrp'       value='' />
		<input type='hidden' id='_offDesc'      name='offDesc'       value='' />
		<input type='hidden' id='_cpnNm'        name='cpnNm'         value='' />
		<input type='hidden' id='_campChlTyp'   name='campChlTyp'    value='' />
		<input type='hidden' id='_chlDesc'      name='chlDesc'       value='' />
		<input type='hidden' id='_smsNm'        name='smsNm'         value='' />
	</form>
	<form id='approvalReqForm'>
		<input type='hidden' id='_strid'        name='strid'         value='' />
		<input type='hidden' id='_campid'       name='campid'        value='' />
	</form>


</body>
<!-- script -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- script type="text/javascript" src="${staticPATH}/bootstrap3/js/jquery.numberformatter-1.2.4.jsmin.js"></script -->
<script type="text/javascript" src="${staticPATH}/bootstrap3/js/bootstrap.js"></script>
<script type="text/javascript">
	$(function() {
		if (true) console.log("step-1: $(function() {});");
		processEvent();
	});
	$(document).ready(function(){
		if (true) console.log("step-2: $(document).ready(function(){})");
	});
	function isEmpty(value) {
		if( value == "" || value == null || value == undefined || ( value != null && typeof value == "object" && !Object.keys(value).length ) ){
			return true;
		} else {
			return false;
		}
	}
	function processEvent() {
		if (!true) $('input[name=campOffTyp]').on('click', function() {
			console.log(">>>>> radio: " + $(this).val());
		});
		if (true) $('#cpnTyp').on('change', function() {
			console.log(">>>>> select: " + $(this).find('option:selected').val());
			var price = $('#cpnTyp').find('option:selected').val().substring(3);
			var count = $('#campCpnCnt').val();
			if (count < 0) {
				$('#campCpnCnt').val(0)
				$('#campCpnCnt').focus();
				return;
			}
			var multi = price * count;
			if (!true) console.log(">>>>> multi = " + multi.toLocaleString());
			$('#campMulti').val(multi.toLocaleString());
		});
		if (true) $('#campCpnCnt').on('change', function() {
			var price = $('#cpnTyp').find('option:selected').val().substring(3);
			var count = $('#campCpnCnt').val();
			if (count < 0) {
				$('#campCpnCnt').val(0)
				$('#campCpnCnt').focus();
				return;
			}
			var multi = price * count;
			if (!true) console.log(">>>>> multi = " + multi.toLocaleString());
			$('#campMulti').val(multi.toLocaleString());
		});
		if (!true) {
			$(".commaNumbers").each(function() {
				$(this).format({format:"#,###", locale:"us"});
			});
		}
	}
	function fn_console(msg) {
		if (true) console.log(">>>>> " + msg);
	}
	function fn_loadPostPage(url) {
		$('#tempForm').attr('method', 'POST').attr('action', url).submit();
	}
	function fn_printCheckboxs() {
		var grp = [];
		$.each($('input[name=campGrp]:checked'), function() {
			grp.push($(this).val());
		});
		console.log(">>>>> " + grp.join(', '));
	}
	function fn_saveCampInfo() {
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
			if (isEmpty($('#offDesc').val())) {
				$('#offDesc').focus();
				return false;
			}
			if (isEmpty($('#cpnNm').val())) {
				$('#cpnNm').focus();
				return false;
			}
			if (isEmpty($('#chlDesc').val())) {
				$('#chlDesc').focus();
				return false;
			}
			if (isEmpty($('#smsNm').val())) {
				$('#smsNm').focus();
				return false;
			}
		}
		if (true) {
			var grp = [];
			$.each($('input[name=campGrp]:checked'), function() {
				grp.push($(this).val());
			});
			console.log(">>>>> " + grp.join(', '));
			
			// transfer data
			$("#_campNm").val($("#campNm").val());
			$("#_campDesc").val($("#campDesc").val());
			$("#_campBgnDt").val($("#campBgnDt").val());
			$("#_campEndDt").val($("#campEndDt").val());
			$("#_campOffTyp").val($('input[name=campOffTyp]:checked').val());
			$("#_campCpnTyp").val($('#cpnTyp').find('option:selected').val());
			$("#_campCpnCnt").val($("#campCpnCnt").val());
			$("#_campGrp").val(grp.join(','));
			$("#_offDesc").val($("#offDesc").val());
			$("#_cpnNm").val($("#cpnNm").val());
			$("#_campChlTyp").val($('input[name=campChlTyp]:checked').val());
			$("#_chlDesc").val($("#chlDesc").val());
			$("#_smsNm").val($("#smsNm").val());
		}
		if (true) {
			// call ajax
			jQuery.ajax({
				url           : "${staticPATH}/str/coupon/saveCampInfo.do",
				dataType      : "JSON",
				scriptCharset : "UTF-8",
				type          : "POST",
				data          : $("#saveCampInfoForm").serialize(),
				success: function(result, option) {
					if (option == "success") {
						alert("메시지:" + result.RET);
						//window.location = "${staticPATH}/str/coupon/approvalReq.do?strid=${info.STR_ID}";
						$('#approvalReqForm > #_strid').val(result.strid);
						$('#approvalReqForm > #_campid').val(result.CAMP_ID);
						$('#tempForm').attr('method', 'POST').attr('action', '${staticPATH}/str/coupon/apprReqListPage.do').submit();
					} else {
						alert("에러가 발생하였습니다. RET=" + result.RET);
					}
					fn_close();
				},
				error: function(result, option) {
					alert("에러가 발생하였습니다.");
					fn_close();
				}
			});
		}
	}
	function fn_close() {
		
	}
</script>
</html>
