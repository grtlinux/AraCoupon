<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>/kang/barcodePage.jsp</title>
</head>
<body>
	<h1>Hello world!</h1>
	<P>The time on the server is ${serverTime}.</P>
	<hr>
	<div>
		<div class="text-center">
			<div id="barCodeTgt1"></div>
			<div id="barCodeTgt2"></div>
			<div id="barCodeTgt31"></div>
			<div id="barCodeTgt4"></div>
			<div id="barCodeTgt41"></div>
			<div id="barCodeTgt42"></div>
			<div id="barCodeTgt43"></div>
			<div id="barCodeTgt5"></div>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="${staticPATH}/bootstrap3/js/bootstrap.js"></script>
<script src="${staticPATH}/bootstrap3/js/ara.common.v01.js"></script>
<script src="${staticPATH}/bootstrap3/js/ara.jquery-barcode.js"></script>
<script type="text/javascript">
	$(function() {
		if (true) console.log("step-1: $(function() {});");
		processBarCode();
	});
	function processBarCode() {
		if (true) console.log(">>>>> 6. ", $F().name);
		// ref: https://doolyit.tistory.com/89
		// title: jquery barcode 출력(바코드출력)하기, jquery 공개소스
		//
		$('#barCodeTgt1').barcode('1234567890-1234567890', 'code128');
		
		$("#barCodeTgt2").barcode("12345678901234567890", "ean13",{barWidth:2, barHeight:30});
		$("#barCodeTgt3").barcode("1234567", "int25",{barWidth:2, barHeight:30});	
		$("#barCodeTgt31").barcode("1234567890123", "int25",{barWidth:2, barHeight:30});	
		$("#barCodeTgt4").barcode("12345678901234567890", "code128",{barWidth:1, barHeight:70,showHRI:true,bgColor:"lightgray"});
		$("#barCodeTgt41").barcode("12345-67890-12345-67890", "code128",{barWidth:1, barHeight:70,showHRI:true,bgColor:"lightgray"});
		$("#barCodeTgt42").barcode("11190-80901-00000-07317", "code128",{barWidth:2, barHeight:70,showHRI:true,bgColor:"lightgray"});
		$("#barCodeTgt43").barcode("11190-80901-00000-07317", "code128",{barWidth:1, barHeight:70,showHRI:true,bgColor:"lightgray"});
		$("#barCodeTgt5").barcode("12345678901234567890", "datamatrix",{showHRI:false,bgColor:"yellow"});
	}
</script>
</html>
