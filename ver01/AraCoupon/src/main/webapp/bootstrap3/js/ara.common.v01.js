/**
 * program: ara.common.v01.js
 * author: Kiea Seok Kang.. at TAIN Inc.
 * create date: 2019. July. 2nd
 * comment:
 *     2019.07.02: be created
 *
 *
 *
 */
$(function() {
	if (true) console.log(">>>>> ara.common.v01.js > step-1: $(function() {});");
});
$(document).ready(function(){
	if (true) console.log(">>>>> ara.common.v01.js > step-2: $(document).ready(function(){})");
	classPhoneFormatter();
	classMoneyFormatter();
});
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
// check empty object
function isEmpty(value) {
	if( value == "" || value == null || value == undefined || ( value != null && typeof value == "object" && !Object.keys(value).length ) ){
		return true;
	} else {
		return false;
	}
}
// Used to format phone number
function classPhoneFormatter() {
	if (true) console.log(">>>>> ara.common.v01.js > classPhoneFormatter()");
	$('.phone').on('input', function() {
		var number = $(this).val().replace(/[^\d]/g, '');
		if (number.length == 10) {
			//number = number.replace(/(\d{3})(\d{3})(\d{4})/, "($1) $2-$3");
			number = number.replace(/(\d{3})(\d{3})(\d{4})/, "$1-$2-$3");
		} else if (number.length == 11) {
			//number = number.replace(/(\d{3})(\d{4})(\d{4})/, "($1) $2-$3");
			number = number.replace(/(\d{3})(\d{4})(\d{4})/, "$1-$2-$3");
		} else if (false && number.length == 7) {
			number = number.replace(/(\d{3})(\d{4})/, "$1-$2");
		}
		$(this).val(number);
	});
}
// Used to format money number
function classMoneyFormatter() {

}
// remain only number string
function onlyNumber(str) {
	return str.replace(/[^\d]/g, '');
}
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
function fn_console(msg) {
	if (true) console.log(">>>>> " + msg);
}
function fn_loadPostPage(id, url) {
	$(id).attr('method', 'POST').attr('action', url).submit();
}
function fn_modalToggle(id) {
	$(id).modal("toggle");
}
function fn_comma(num){
	var len, point, str;
	num = num + "";
	point = num.length % 3 ;
	len = num.length;
	str = num.substring(0, point);
	while (point < len) {
		if (str != "") str += ",";
		str += num.substring(point, point + 3);
		point += 3;
	}
	return str;
}
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
/*
<html>
<head>
    <title>호출된 함수명 출력 TEST</title>
    <script type="text/javascript" charset="EUC-KR">
            <![CDATA[
        function $F(caller) {
            var f = arguments.callee.caller;
            if(caller) f = f.caller;
            var pat = /^function\s+([a-zA-Z0-9_]+)\s*\(/i;
            pat.exec(f);
            var func = new Object();
            func.name = RegExp.$1;
            return func;
        }
 
        function foo() {
            var name = $F().name;   // 함수 자신의 이름 가져오기
            console.log(name);      // 또는 alert($F().name);
        }
 
        function testArguments() {
            console.log(arguments);
        }
 
        function testCallee() {
            console.log(arguments.callee);
        }
 
        function testCaller() {
            console.log(arguments.callee.toString());
            console.log(arguments.callee.caller.toString());
        }
 
        function testCaller2() {
            testCaller();
        }
            ]]>
    </script>
</head>
<body>
<a href="javascript:testArguments(1, 2, 3);">arguments test</a><p/>
<a href="javascript:testCallee();">callee test</a><p/>
<a href="javascript:testCaller2();">callee.caller test</a><p/>
<a href="javascript:foo();">호출 함수 test</a><p/>
</body>
</html>


출처: https://citron413.tistory.com/entry/호출된-함수명-얻어오는-방법 [Noit's Blog]
 */











