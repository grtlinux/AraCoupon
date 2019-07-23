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
					<li class="hide"><a data-target="#modalAra" data-toggle="modal" href="#" onclick="fn_clearModalAra('ARA');">아라</a></li>
					<li><a data-target="#modalUsr" data-toggle="modal" href="#" onclick="fn_clearModalAra('USR');">고객</a></li>
					<li><a data-target="#modalStr" data-toggle="modal" href="#" onclick="fn_clearModalAra('STR');">가게</a></li>
					<li><a data-target="#modalCtr" data-toggle="modal" href="#" onclick="fn_clearModalAra('CTR');">센타</a></li>
					<li><a href="javascript:fn_loadPostPage('#tempForm', '${staticPATH}/ara2/underConstruct/underConstructPage.do');"><span class="glyphicon glyphicon-list-all"></span>&nbsp;공사중</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- gap -->
	<div style="height:70px;"></div>
