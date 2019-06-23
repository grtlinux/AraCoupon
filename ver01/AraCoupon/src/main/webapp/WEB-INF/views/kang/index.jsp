<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--
	<base href="http://arajeju.com:8080/AraCoupon/" target="_self">
	<base href="http://172.30.1.20:8080/AraCoupon/" target="_self">
	<base href="http://192.168.1.117:8080/AraCoupon/" target="_self">
	-->
	<title>테스트 용도</title>
</head>
<!-- style -->
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<link rel="stylesheet" href="/AraCoupon/bootstrap3/css/bootstrap.css">
<link rel="stylesheet" href="/AraCoupon/bootstrap3/css/codingBooster.css">
<style type="text/css">
	.jumbotron {
		background-image: url('/AraCoupon/bootstrap3/images/jumbotronBackground.jpg');
		background-size: cover;
		text-shadow: black 0.4em 0.4em 0.4em;
		color: white;
	}
</style>
<body>
	<!-- navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="usr/home.do">ACSS</a>
			</div>
			<div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
				<!-- navbar menu -->
				<ul class="nav navbar-nav navbar-left">
					<li><a href="usr/info.do">내 정보</a></li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="usr/coupon/take.do"><span class="glyphicon glyphicon-list-all"></span>&nbsp;수령</a></li>
							<li><a href="usr/coupon/list.do"><span class="glyphicon glyphicon-list-all"></span>&nbsp;목록</a></li>
							<li class="divider"></li>
							<li><a href="usr/coupon/record.do"><span class="glyphicon glyphicon-list-all"></span>&nbsp;기록</a></li>
						</ul>
					</li>
				</ul>

				<!-- login menu -->
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span><span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="usr/login/login.do"><span class="glyphicon glyphicon-log-in"></span>&nbsp;로그인</a></li>
							<li><a href="usr/login/register.do"><span class="glyphicon glyphicon-edit"></span>&nbsp;회원등록</a></li>
							<li><a href="usr/login/logout.do"><span class="glyphicon glyphicon-log-out"></span>&nbsp;로그아웃</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>


	<!-- gap -->
	<div style="height:70px;"></div>


	<!-- container for jumbotron -->
	<div class="container">
		<!-- jumbotron -->
		<div class="jumbotron text-center">
			<h1>아라쿠폰서비스시스템(ACSS)을 소개합니다.</h1>
			<p>아라쿠폰서비스시스템은 여러분이 쿠폰서비스를 이용하여 많은 부가가치를 창출하기를 바라는 마음으로 ...</p>
			<p><a class="btn btn-primary btn-lg" role="button" data-target="#modal0" data-toggle="modal" href="#">아라쿠폰서비스시스템 가기</a></p>
		</div>
	</div>


	<!-- container for col -->
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h4>Ara Jeju System</h4>
				<p>크딩 부스터는 다른 사이트만 지원이 다른 깔끔한 구성을 보여줍니다. 모든 페이지가 사용자가 접근하고 읽기 쉽도록 정교하게 구성됩니다. 많은 강의를 들으세요.</p>
				<p class="text-center"><a class="btn btn-default" data-target="#modal1" data-toggle="modal" href="#">자세히 알아보기</a></p>
			</div>
			<div class="col-sm-4">
				<h4>폭 넓은 강사진</h4>
				<p>크딩 부스터는 다른 사이트만 지원이 다른 깔끔한 구성을 보여줍니다. 모든 페이지가 사용자가 접근하고 읽기 쉽도록 정교하게 구성됩니다. 많은 강의를 들으세요.</p>
				<p class="text-center"><a class="btn btn-default" data-target="#modal2" data-toggle="modal" href="#">자세히 알아보기</a></p>
			</div>
			<div class="col-sm-4">
				<h4>핵심적인 강의</h4>
				<p>크딩 부스터는 다른 사이트만 지원이 다른 깔끔한 구성을 보여줍니다. 모든 페이지가 사용자가 접근하고 읽기 쉽도록 정교하게 구성됩니다. 많은 강의를 들으세요.</p>
				<p><a class="btn btn-default" href="javascript:fn_console('핵심적인 강의');">자세히 알아보기</a></p>
			</div>
		</div>
	</div>


	<!-- container for panel -->
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;최신 강의 목록</h3>
			</div>
			<div class="panel-body">
				<div class="media">
					<div class="media-left">
						<a href="#"><img class="media-object" src="/AraCoupon/bootstrap3/images/CAN.jpg" style="width:100px;" alt="강의 이미지 1"></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading"><a href="javascript:fn_console('언어 기초 프로그램');">언어 기초 프로그램</a>&nbsp;<span class="badge">New</span></h4>
						언어 강의는 기초 프로그래밍 강의ㅣㅂ니다. ㅓ음 프로그램을 접하는 입뭄자가 듣기에 적합한 강의입니다.
						강의로는 무료이며 언어 기초 프로그래밍 강좌는 총 20간으로 구성됩니다.
					</div>
				</div>
				<hr>
				<div class="media">
					<div class="media-left">
						<a href="#"><img class="media-object" src="/AraCoupon/bootstrap3/images/PNG.jpg" style="width:100px;" alt="강의 이미지 2"></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading"><a href="javascript:fn_console('Java 언어 기초 프로그래밍 강좌');">Java 언어 기초 프로그래밍 강좌</a>&nbsp;<span class="badge">New</span></h4>
						언어 강의는 기초 프로그래밍 강의ㅣㅂ니다. ㅓ음 프로그램을 접하는 입뭄자가 듣기에 적합한 강의입니다.
						강의로는 무료이며 언어 기초 프로그래밍 강좌는 총 20간으로 구성됩니다.<br>
						언어 강의는 기초 프로그래밍 강의ㅣㅂ니다. ㅓ음 프로그램을 접하는 입뭄자가 듣기에 적합한 강의입니다.
						강의로는 무료이며 언어 기초 프로그래밍 강좌는 총 20간으로 구성됩니다.<br>
						언어 강의는 기초 프로그래밍 강의ㅣㅂ니다. ㅓ음 프로그램을 접하는 입뭄자가 듣기에 적합한 강의입니다.
						강의로는 무료이며 언어 기초 프로그래밍 강좌는 총 20간으로 구성됩니다.
					</div>
				</div>
				<hr>
				<div class="media">
					<div class="media-left">
						<a href="#"><img class="media-object" src="/AraCoupon/bootstrap3/images/SQL.jpg" style="width:100px;" alt="강의 이미지 3"></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading"><a href="javascript:fn_console('Android 언어 기초 프로그래밍 강좌');">Android 언어 기초 프로그래밍 강좌</a>&nbsp;<span class="badge">New</span></h4>
						언어 강의는 기초 프로그래밍 강의ㅣㅂ니다. ㅓ음 프로그램을 접하는 입뭄자가 듣기에 적합한 강의입니다.
						강의로는 무료이며 언어 기초 프로그래밍 강좌는 총 20간으로 구성됩니다.
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- container for form -->
	<div class="container">
		search: <input class="form-control" type="search" name="search" placeholder="search">
		tel: <input class="form-control" type="tel" name="tel" placeholder="tel">
		url: <input class="form-control" type="url" name="url" placeholder="url">
		email: <input class="form-control" type="email" name="emal" placeholder="email">

		password: <input class="form-control" type="password" name="password" placeholder="password">
		datetime: <input class="form-control" type="datetime" name="datetime" placeholder="datetime">
		datetime-local: <input class="form-control" type="datetime-local" name="datetime-local" placeholder="datetime-local">
		date: <input class="form-control" type="date" name="date" placeholder="date">
		month: <input class="form-control" type="month" name="month" placeholder="month">
		week: <input class="form-control" type="week" name="week" placeholder="week">
		time: <input class="form-control" type="time" name="time" placeholder="time">
		number: <input class="form-control" type="number" name="number" placeholder="number">
		range: <input class="form-control" type="range" name="range" placeholder="range">
		color: <input class="form-control" type="color" name="color" placeholder="color">
	</div>
	<br>



	<!-- container for panel -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;홍길동 강사</h3>
					</div>
					<div class="panel-body">
						<div class="media">
							<div class="media-left">
								<a href="#"><img class="media-object" src="/AraCoupon/bootstrap3/images/steve-jobs.png" style="width:50px;"></a>
							</div>
							<div class="media-body">
								<h4 class="media-heading">홍길동</h4>
								코딩 부스터의 홍길동 강사입니다.<br/>
								이것은 테이블을 활용하기 위한 템플릿 소스입니다.
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<blockquote>&nbsp;&nbsp;Do And Forget!!</blockquote>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- container for table -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<p>테이블</p>
				<div class="panel panel-primary">
					<table id="codeTable" class="table">
						<thead>
							<tr>
								<td>코드대분류</td>
								<td>코드대분류명</td>
								<td>코드소분류</td>
								<td>코드소분류명</td>
								<td>코드설명</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>코드대분류</td>
								<td>코드대분류명</td>
								<td>코드소분류</td>
								<td>코드소분류명</td>
								<td>코드설명</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	<!-- container for list-group -->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<p>강의</p>
				<div class="list-group">
					<a class="list-group-item" href="#">1강. Hello world!!!</a>
					<a class="list-group-item" href="#">2강. 변수와 상수</a>
					<a class="list-group-item" href="#">3강. 데이터 타입</a>
					<a class="list-group-item" href="#">4강. 연산자</a>
					<a class="list-group-item" href="#">5강. 조건문과 반복문</a>
				</div>
			</div>
		</div>
	</div>


	<!-- form for register -->
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<!-- indentation -->
			</div>
			<div class="col-sm-6">
				<form class="form-horizontal">
					<div class="form-group">
						<label>댓글:</label>
						<textarea rows="5" class="form-control" id="commentContent" name="commentContent"></textarea>
						<br>
						<button class="btn pull-right" type="submit">등록</button>
					</div>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-1">
				<!-- indentation -->
			</div>
			<div class="col-sm-2">
				search
			</div>
			<div class="col-sm-5">
				<input id="search" class="form-control" type="search" name="search" placeholder="search">
			</div>
		</div>
	</div>









	<!-- gap -->
	<div style="height:70px;"></div>


	<!-- footer -->
	<footer class="footer-default">
		<div class="container">
			<br>
			<div class="row">
				<div class="col-sm-12 text-center">
					<h6>
						Copyright &copy; 2014 ~ 2018, 2019 TAIN Inc.
					</h6>
				</div>
				<!--
				<div class="col-sm-4">
					<h5>소개</h5>
					<p>ACSS(Ara Coupon Service System)</p>
				</div>
				<div class="col-sm-2">
					<h5>네비게이션</h5>
					<div class="list-group">
						<a class="list-group-item" href="/sample05/">소개</a>
						<a class="list-group-item" href="/sample05/instructor">강사진</a>
						<a class="list-group-item" href="/sample05/lecture">강의</a>
					</div>
				</div>
				<div class="col-sm-2">
					<h5>SNS</h5>
					<div class="list-group">
						<a class="list-group-item" href="javascript:fn_console('facebook');">facebook</a>
						<a class="list-group-item" href="javascript:fn_console('YouTube');">YouTube</a>
						<a class="list-group-item" href="javascript:fn_console('Naver');">Naver</a>
					</div>
				</div>
				<div class="col-sm-2">
					<h5><span class="glyphicon glyphicon-ok"></span>&nbsp;&nbsp;by TAIN Inc.</h5>
				</div>
				-->
			</div>
		</div>
	</footer>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- modal dialog -->
	<div class="row">
		<div class="modal" id="modal0" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						아라쿠폰서비스시스템 특징<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						저희 서비스의 특징은 바로 강의를 들을 수 있다는 점입니다.<br>
						특히 다양한 무료 강의가 유튜브와 연동되어 제공됩니다.<br><br>
						<img src="/AraCoupon/bootstrap3/images/LEGO_Logo.jpg" style="width:250px;">
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
						<img src="/AraCoupon/bootstrap3/images/LEGO_Logo.jpg" style="width:250px;">
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
						<img src="/AraCoupon/bootstrap3/images/JPG-logo-highres.jpg" style="width:250px;">
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
<!-- script -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/AraCoupon/bootstrap3/js/bootstrap.js"></script>
<script type="text/javascript">
	$(function() {
		if (true) console.log("step-1: $(function() {});");
		fn_getIndex();
	});
	$(document).ready(function() {
		if (true) console.log("step-2: $(document).ready(function(){})");
	});
	function fn_console(msg) {
		if (true) console.log(">>>>> " + msg);
	}
	function isEmpty(value) {
		if( value == "" || value == null || value == undefined || ( value != null && typeof value == "object" && !Object.keys(value).length ) ){
			return true;
		} else {
			return false;
		}
	}
	function fn_getIndex(){
		jQuery.ajax({
			//url           : "http://arajeju.com:8080/AraCoupon/Kang/getIndex.do?serverType=IMSI",
			url           : "/AraCoupon/Kang/getIndex.do?serverType=IMSI",
			dataType      : "JSON",
			scriptCharset : "UTF-8",
			type          : "POST",
			//data          : $("#form").serialize(),
			//data          : {},
			data          : {
				key01: "val01",
				key02: "val02",
			},
			success: function(result, option) {
				if (option == "success"){
					fn_console("success");
					
					if (true) {
						fn_console("serverType: " + result.serverType);
						fn_console("key01: " + result.key01);
						fn_console("key02: " + result.key02);
						fn_console("map.serverType: " + result.map.serverType);
						console.log("result.map:", result.map);
						console.log("result.list:", result.list);
						console.log("result.list.length:", result.list.length);
						console.log("result.list[0]:", result.list[0]);
						console.log("result.list[0].COMM_CODE_NAME:", result.list[0].COMM_CODE_NAME);
						console.log("result.list[0].comm_code_name:", result.list[0].comm_code_name);
						//$("#TO_DATE").val(result.TO_DATE) ;
						//$("#TO_DATE_P1").val(result.TO_DATE_P1) ;
						//$("#TO_DATE_P2").val(result.TO_DATE_P2) ;
						result.list.forEach(function(value, index, array) {
							fn_console("list[" + index + "]=>" + value.COMM_CODE_ID + ", " + value.COMM_CODE_NAME + ", " + value.CODE_ID + ", " + value.CODE_NAME + ", " + value.DTL_CODE_DESC);
						});
					}
					
					$("#codeTable > tbody").empty();
					result.list.forEach(function(value, index, array) {
						var rowHtml = "";
						rowHtml += "<tr>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.COMM_CODE_ID;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.COMM_CODE_NAME;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CODE_ID;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.CODE_NAME;
						rowHtml += "  </td>";
						rowHtml += "  <td>";
						rowHtml += "    " + value.DTL_CODE_DESC;
						rowHtml += "  </td>";
						rowHtml += "</tr>";
						$("#codeTable > tbody:last").append(rowHtml);
					});
					$("#search").val(result.list[0].COMM_CODE_NAME);
				} else {
					alert("에러가 발생하였습니다.");
				}
			},
			error: function(result, option) {
				alert("에러가 발생하였습니다.");
			}
		});
	}
</script>
<script>
	/////////////////////////////////////////////////
	/////////////////////////////////////////////////
	/////////////////////////////////////////////////
	/////////////////////////////////////////////////
	/////////////////////////////////////////////////
	/////////////////////////////////////////////////
	// KANG-20190326: type-1 script BEGIN
	/////////////////////////////////////////////////
	var maxArrImg1 = 5;
	$("img1_addItem").tooltip();
	//
	//
	//
	function fn_img1_addItem_click() {
		if (arrImg1.length >= maxArrImg1) {
			if (true) alert("이미지는 " + maxArrImg1 + "개까지만 등록 가능합니다.");
			return;
		}
		if (!true) alert("fn_img1_addItem_click()");
		var idx = arrImg1.length + 1;
		arrImg1.push({ imgUrl: "" });
		fn_img1_appendTableTr();
		if (idx >= maxArrImg1) {
			$("#img1_addItem").attr("disabled", true);
		}
	}
	function fn_img1_inputBlur(idx, cls, value) {
		if (true) console.log(idx + ": " + cls + ": " + value);
		arrImg1[idx][cls] = value;   // KANG-20190405
	}
	function fn_img1_appendTableTr() {
		// clear
		$("#img1_table > tbody").empty();
		// value print
		arrImg1.forEach(function(value, index, array) {
			if (!true) alert("fn_img1_appendTableTr(): (" + index + "/" + array.length + ") : " + value.imgUrl);
			var rowHtml = "";
			rowHtml += "<tr>";
			rowHtml += "  <td class=\"info\">";
			rowHtml += "    이미지 URL " + (index+1) + " ";
			if (array.length > 1) {
				rowHtml += "    <span class=\"float-right\">";
				rowHtml += "      <button type=\"button\" onclick=\"javascript:fn_img1_del(" + index + ")\" class=\"btn btn-primary\" style=\"background-color:#aaa; height:15px;width:15px;padding:0px; font-size:10px;\">R</button>";
				if (index > 0) {
					rowHtml += "      <button type=\"button\" onclick=\"javascript:fn_img1_up(" + index + ")\" class=\"btn btn-primary\" style=\"background-color:#aaa; height:15px;width:15px;padding:0px; font-size:10px;\">U</button>";
				}
				if (index < array.length - 1) {
					rowHtml += "      <button type=\"button\" onclick=\"javascript:fn_img1_down(" + index + ")\" class=\"btn btn-primary\" style=\"background-color:#aaa; height:15px;width:15px;padding:0px; font-size:10px;\">D</button>";
				}
				rowHtml += "    </span>";
			}
			rowHtml += "  </td>";
			rowHtml += "  <td colspan='3'>";
			rowHtml += "    <input type='text' id='type1_imgUrl" + index + "' class='imgUrl' onblur=\"javascript:fn_img1_inputBlur(" + index + ",'imgUrl',this.value);\" style='width:700px;' value='" + value.imgUrl + "' maxlength='100' placeholder='500*500 사이즈 이미지 경로 입력' />";
			rowHtml += "    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button type='button' id='type1_imgUrl" + index +"' class='btn btn-success btn-sm' onclick=\"fn_pre_view_img('type1_imgUrl" + index +"');\"><i class='fa fa-eye' aria-hidden='true'></i> 미리보기</button>";
			rowHtml += "  </td>";
			rowHtml += "</tr>";
			$("#img1_table > tbody:last").append(rowHtml);
		});
	}
	function fn_img1_del(idx) {
		if (!true) alert("fn_img_del(" + idx + ")");
		arrImg1.splice(idx, 1);
		fn_img1_appendTableTr();
		$("#img1_addItem").removeAttr("disabled");
	}
	function fn_img1_up(idx) {
		if (!true) alert("fn_img_up(" + idx + ")");
		var temp = arrImg1[idx-1];
		arrImg1[idx-1] = arrImg1[idx];
		arrImg1[idx] = temp;
		fn_img1_appendTableTr();
	}
	function fn_img1_down(idx) {
		if (!true) alert("fn_img_down(" + idx + ")");
		var temp = arrImg1[idx+1];
		arrImg1[idx+1] = arrImg1[idx];
		arrImg1[idx] = temp;
		fn_img1_appendTableTr();
	}
	/////////////////////////////////////////////////
	// KANG-20190326: type-1 script END
	/////////////////////////////////////////////////
</script>

</html>
