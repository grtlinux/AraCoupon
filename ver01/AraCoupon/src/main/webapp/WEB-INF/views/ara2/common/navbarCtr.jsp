<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
				<a class="navbar-brand" href="${staticPATH}/ara2/index.do">ACSS</a>
			</div>
			<div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
				<!-- navbar menu -->
				<ul class="nav navbar-nav navbar-left">
					<li><a data-target="#modalSelfInfo" data-toggle="modal" href="#" onclick="fn_console('toggle event after click event.....');">내 정보</a></li>

					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰발행<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/ctr2/coupon/createCampFormPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;캠페인 생성</a></li>
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/ctr2/coupon/executeCampListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;캠페인 실행</a></li>
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/ctr2/coupon/resultCampListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;캠페인 결과</a></li>
						</ul>
					</li>
					<li class="dropdown hide">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰정산<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/ctr/calculate/calcListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;정산목록</a></li>
						</ul>
					</li>
					<li class="hide"><a href="/sample05/">통계</a></li>
				</ul>

				<!-- login menu -->
				<ul class="nav navbar-nav navbar-right hide">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span><span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${staticPATH}/ctr/login/login.do"><span class="glyphicon glyphicon-log-in"></span>&nbsp;로그인</a></li>
							<li><a href="${staticPATH}/ctr/login/register.do"><span class="glyphicon glyphicon-edit"></span>&nbsp;회원등록</a></li>
							<li><a href="${staticPATH}/ctr/login/logout.do"><span class="glyphicon glyphicon-log-out"></span>&nbsp;로그아웃</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- gap -->
	<div style="height:70px;"></div>
