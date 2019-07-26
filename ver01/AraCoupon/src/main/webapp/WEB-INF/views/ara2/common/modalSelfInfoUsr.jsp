<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
					<div class="modal-header alert alert-info">
						내 정보(고객)<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body text-center">
						<div class="panel panel-primary">
							<table class="table text-left">
								<tbody>
									<tr>
										<td>고객ID</td>
										<td class="align-left">${info.USR_ID}</td>
									</tr>
									<tr>
										<td>고객명</td>
										<td>${info.USR_NM}</td>
									</tr>
									<tr>
										<td>전화번호</td>
										<td class="phoneWithDashes">${info.TEL_NUM}</td>
									</tr>
									<tr>
										<td>핸드폰번호</td>
										<td class="phoneWithDashes">${info.MBL_NUM}</td>
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
