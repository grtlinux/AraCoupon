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












