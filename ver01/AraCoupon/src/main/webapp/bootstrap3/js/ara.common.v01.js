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
function classFormatter() {
	if (true) $('.numberWithCommas').each(function() {
			$(this).text(numberWithCommas($(this).text()));
		});
	if (true) $('.numberToMoney').each(function() {
			$(this).text(numberToMoney($(this).text()));
		});
	if (true) $('.onlyNumber').each(function() {
			$(this).text(onlyNumber($(this).text()));
		});
	if (true) $('.phoneWithDashes').each(function() {
			$(this).text(phoneWithDashes($(this).text()));
		});
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
function numberWithCommas(number) {
	var parts = number.toString().split('.');
	parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ',');
	return parts.join('.');
}
function numberToMoney(number) {
	var parts = number.toString().split('.');
	parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ',');
	return parts.join('.') + "원";
}
function phoneWithDashes(phone) {
	var phone = phone.replace(/[^\d]/g, '');
	if (phone.charAt(1) == '1') {
		// mobile
		if (phone.length == 10) {
			phone = phone.replace(/(\d{3})(\d{3})(\d{4})/, "$1-$2-$3");
		} else if (phone.length == 11) {
			phone = phone.replace(/(\d{3})(\d{4})(\d{4})/, "$1-$2-$3");
		}
	} else {
		if (phone.length == 10) {
			phone = phone.replace(/(\d{2})(\d{4})(\d{4})/, "$1-$2-$3");
		} else if (phone.length == 11) {
			phone = phone.replace(/(\d{3})(\d{4})(\d{4})/, "$1-$2-$3");
		}
	}
	return phone;
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
function fn_loadPostPage(id, url, menuName) {
	$(id + " #_menuName").val(menuName);
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
function fn_returnAlert(result) {
	if (true) alert("[알림] " + result.retMsg + " (" + result.retCode + ")");
}
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//
// URL Parameter의 키(name)에 해당하는 값을 얻는다.
function fn_getParameterByName(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	results = regex.exec(location.search);
	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}
// 쿠키 생성
function fn_setCookie(cookieName, cookieValue, cookieDay){
	var expire = new Date();
	expire.setDate(expire.getDate() + cookieDay);
	cookies = cookieName + '=' + escape(cookieValue) + '; path=/ '; // 한글 깨짐을 막기위해 escape(cookieValue)를 합니다.
	if (typeof cookieDay != 'undefined')
		cookies += ';expires=' + expire.toGMTString() + ';';
	document.cookie = cookies;
}
/*
// 쿠키 가져오기. the same of the below
function fn_getCookie(cName) {
	cName = cName + '=';
	var cookieData = document.cookie;
	var start = cookieData.indexOf(cName);
	var cValue = '';
	if (start != -1) {
		start += cName.length;
		var end = cookieData.indexOf(';', start);
		if(end == -1)end = cookieData.length;
		cValue = cookieData.substring(start, end);
	}
	return unescape(cValue);
}
*/
// 쿠키 값을 얻는다.
function fn_getCookie(cookieName) {
	cookieName = cookieName + '=';
	var cookieData = document.cookie;
	var start = cookieData.indexOf(cookieName);
	var cookieValue = '';
	if (start != -1) {
		start += cookieName.length;
		var end = cookieData.indexOf(';', start);
		if (end == -1)
			end = cookieData.length;
		cookieValue = cookieData.substring(start, end);
	}
	return unescape(cookieValue);
}
// 쿠키 값을 삭제한다.
function fn_deleteCookie(cookieName){
	//var expireDate = new Date();
	//expireDate.setDate(expireDate.getDate() - 1);
	// document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
	document.cookie = cookieName + "=; expires=Thu, 01 Jan 1970 00:00:01 GMT;";
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











