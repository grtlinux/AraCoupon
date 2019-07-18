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
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰창고<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/usr2/coupon/stateCpnListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;갖고있는 쿠폰목록</a></li>
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/usr2/coupon/useCpnListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰사용</a></li>
						</ul>
					</li>
					<li class="dropdown hide">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰패키지발행<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/usr2/coupon/createCampFormPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰패키지 생성</a></li>
							<li class="divider hide"></li>
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/usr2/coupon/apprReqListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰패키지 신청목록</a></li>
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/usr2/coupon/apprResListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰펰키지 승인목록</a></li>
						</ul>
					</li>
				</ul>

				<!-- login menu -->
				<ul class="nav navbar-nav navbar-right hide">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span><span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${staticPATH}/usr/login/login.do"><span class="glyphicon glyphicon-log-in"></span>&nbsp;로그인</a></li>
							<li><a href="${staticPATH}/usr/login/register.do"><span class="glyphicon glyphicon-edit"></span>&nbsp;회원등록</a></li>
							<li><a href="${staticPATH}/usr/login/logout.do"><span class="glyphicon glyphicon-log-out"></span>&nbsp;로그아웃</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- gap -->
	<div style="height:70px;"></div>
