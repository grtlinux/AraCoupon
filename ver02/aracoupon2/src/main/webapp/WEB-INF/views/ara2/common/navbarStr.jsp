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
				<a class="navbar-brand" href="${staticPATH}/">ACSS</a>
			</div>
			<div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
				<!-- navbar menu -->
				<ul class="nav navbar-nav navbar-left">
					<li><a data-target="#modalSelfInfo" data-toggle="modal" href="#" onclick="fn_console('toggle event after click event.....');">내 정보</a></li>

					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">가게계좌<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/str2/account/selectAcntInOutListPage.do', '가게계좌 입출금내역');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;가게계좌 입출금내역</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰창고<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/str2/coupon/buyCpnListPage.do', '쿠폰구매');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰구매</a></li>
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/str2/coupon/stateCpnListPage.do', '쿠폰상황');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰상황</a></li>
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/str2/coupon/giveCpnListPage.do', '쿠폰제공');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰제공</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">결제쿠폰창고<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/str2/payment/paymentCpnListPage.do', '결제쿠폰목록');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;결제쿠폰목록</a></li>
						</ul>
					</li>

					<!--
					<li class="dropdown hide">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰패키지발행<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/str/coupon/createCampFormPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰패키지 생성</a></li>
							<li class="divider hide"></li>
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/str/coupon/apprReqListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰패키지 신청목록</a></li>
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/str/coupon/apprResListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰펰키지 승인목록</a></li>
						</ul>
					</li>
					<li class="dropdown hide">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰제공<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/str/provide/givableCpnListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰제공</a></li>
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/str/provide/allCpnListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;쿠폰목록</a></li>
						</ul>
					</li>
					<li class="dropdown hide">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰결제<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/str/payment/payCpnListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;결제 쿠폰목록</a></li>
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/str/payment/noPayCpnListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;미결제 쿠폰목록</a></li>
						</ul>
					</li>
					<li class="dropdown hide">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">쿠폰정산<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/str/calculate/tempCalcListPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;임시정산</a></li>
						</ul>
					</li>
					<li class="hide"><a href="/sample05/">통계</a></li>
					-->
				</ul>

				<!-- login menu -->
				<ul class="nav navbar-nav navbar-right hide">
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
