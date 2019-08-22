<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>/kang/fileuploadPage.jsp</title>
</head>
<body>
	<h1>Hello world!</h1>
	<P>The time on the server is ${serverTime}.</P>
	<hr>

<style>
	.uploadResult {
		width: 100%;
		background-color: #aaaaff;
	}

	.uploadResult ul {
		display: flex;
		flex-flow: row;
		justify-content: center;
		align-items: center;
	}

	.uploadResult ul li {
		list-style: none;
		padding: 10px;
	}

	.uploadResult ul li img {
		width: 100px;
	}
</style>

<style>
	.bigPictureWrapper {
		position: absolute;
		display: none;
		justify-content: center;
		align-items: center;
		top:0%;
		width:100%;
		height:100%;
		background-color: gray;
		z-index: 100;
	}

	.bigPicture {
		position: relative;
		display:flex;
		justify-content: center;
		align-items: center;
	}
</style>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->

	<div class="hide">
		<div class='bigPictureWrapper'>
			<div class='bigPicture'></div>
		</div>
		<div class='uploadDiv'>
			<input type='file' name='uploadFile' multiple>
		</div>
		<div class='uploadResult'>
			<ul>
			</ul>
		</div>
		<button id='uploadBtn'>Upload</button>
	</div>
	<hr>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->

	<div class="hide">
		<form action="/file/uploadFormAction.do" method="POST" enctype="multipart/form-data">
			<input type="file" name="uploadFile" multiple>
			<input type="submit" value="SUBMIT">
		</form>
	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="${staticPATH}/bootstrap3/js/bootstrap.js"></script>
<script src="${staticPATH}/bootstrap3/js/ara.common.v01.js"></script>
<script src="${staticPATH}/bootstrap3/js/ara.jquery-barcode.js"></script>
<script type="text/javascript">
	$(function() {
		if (true) console.log("step-1: $(function() {});");
		fn_test();
	});
	function fn_test() {
		var str;
		str = "_under construct 한_2019-08-22.jpg";
		var check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		if (check.test(str)) {
			console.log(">>>>> str에 한글이 있습니다.");
		} else {
			console.log(">>>>> str에 한글이 NO.");
		}
		str = "_under construct 한_2019-08-22.jpg";
		var check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		if (check.test(str)) {
			console.log(">>>>> str에 한글이 있습니다.");
		} else {
			console.log(">>>>> str에 한글이 NO.");
		}
	}
</script>
<script>
	function showImage(fileCallPath){
		//alert(fileCallPath);
		$(".bigPictureWrapper").css("display","flex").show();

		$(".bigPicture")
			.html("<img src='/file/display.do?fileName="+fileCallPath+"'>")
			.animate({width:'100%', height: '100%'}, 1000);
	}
	$(".bigPictureWrapper").on("click", function(e) {
		$(".bigPicture").animate({width:'0%', height: '0%'}, 1000);
		setTimeout(() => {
			$(this).hide();
		}, 1000);
	});
	$(".uploadResult").on("click","span", function(e){
		var targetFile = $(this).data("file");
		var type = $(this).data("type");
		console.log(targetFile);
		$.ajax({
			url: '/file/deleteFile.do',
			data: {fileName: targetFile, type:type},
			dataType:'text',
			type: 'POST',
			success: function(result){
				alert(result);
				// KANG
				showUploadedFile([]);
			}
		}); //$.ajax
	});

	// string.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣|a-z|A-Z|0-9]+.*")
	//var regex1 = new RegExp("^[0-9a-zA-Z_.\-\w]+$");
	//   /0-9a-zA-Z_/  = /\w/
	//var regex1 = new RegExp("^[0-9a-zA-Z_\-\.\s]+$");
	//var regex1 = new RegExp("^[\w\.\-\s]+$");
	var regex1 = new RegExp("^[0-9a-zA-Z_\.\-]+$");
	var regex2 = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	var regex3 = new RegExp("[ㄱ-ㅎㅏ-ㅣ가-힣]+");   // 한글
	var hanCheck1 = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	//var maxSize = 5242880; //5MB
	var maxSize = 1024 * 1024 * 10;     // 10 MB

	function checkExtension(fileName, fileSize) {
		if (true) console.log(">>>>> " + fileName + ", " + fileSize);
		
		if (fileSize >= maxSize) {
			alert("[알림] 파일 사이즈 초과. (" + fileName + ":" + fileSize + ")");
			return false;
		}
		//if (!regex1.test(fileName)) {
		//	alert("[알림] 영숫자, 공백, 특수(_.) 만 허용됩니다. (" + fileName+ ")");
		//	return false;
		//}
		if (regex2.test(fileName)) {
			alert("[알림] 해당 종류의 파일은 업로드할 수 없습니다.");
			return false;
		}
		if (hanCheck1.test(fileName)) {
			alert("[알림] 한글이 포함된 파일명은 업로드할 수 없습니다.");
			return false;
		}
		return true;
	}

	var cloneObj = $(".uploadDiv").clone();

	$("#uploadBtn").on("click", function(e) {
		var formData = new FormData();
		var inputFile = $(".uploadDiv input[name='uploadFile']");
		var files = inputFile[0].files;
		console.log(files);
		for (var i = 0; i < files.length; i++) {
			if (!checkExtension(files[i].name, files[i].size)) {
				return false;
			}
			formData.append("uploadFile", files[i]);
		}
		$.ajax({
			url : '/file/uploadAjaxAction.do',
			type : 'POST',
			data : formData,
			dataType : 'json',
			processData : false,
			contentType : false,
			success : function(result) {
				console.log(result);
				showUploadedFile(result);
				$(".uploadDiv").html(cloneObj.html());
			}
		}); //$.ajax
	});

	var uploadResult = $(".uploadResult ul");

	function showUploadedFile(uploadResultArr) {
		var str = "";
		uploadResult.empty();
		$(uploadResultArr).each(function(i, obj) {
			if (!obj.image) {
				var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
				var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
				str += "<li><div>"
					+ "<a href='/file/download.do?fileName=" + fileCallPath + "'>"
					+ "<img src='/image/attach.png'>" + obj.fileName
					+ "</a>"
					+ "<span data-file=\'" + fileCallPath + "\' data-type='file'> x </span>"
					+ "<div></li>\n";
			} else {
				var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
				var originPath = obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName;
				originPath = originPath.replace(new RegExp(/\\/g),"/");
				str += "<li>"
					+ "<a href=\"javascript:showImage(\'" + originPath + "\')\">"
					+ "<img src='/file/display.do?fileName=" + fileCallPath + "'>"
					+ "</a>"
					+ "<span data-file=\'" + fileCallPath + "\' data-type='image'> x </span>"
					+ "<li>\n";
			}
		});
		uploadResult.append(str);
	}
</script>

</html>
