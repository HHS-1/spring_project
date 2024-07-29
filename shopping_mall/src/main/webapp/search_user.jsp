<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 찾기</title>
</head>
<body>
<form id="frm" accept-charset="UTF-8">
<p>아이디 찾기</p>
고객명 : <input type="text" name="uname"><br>
이메일 : <input type="text" name="uemail"><br>
<button type="button" onclick="btn1()">아이디 찾기</button>
<p>패스워드 변경</p>
아이디 : <input type="text" name="uid"><br>
고객명 : <input type="text" name="uname2"><br>
<button type="button" onclick="btn2()">패스워드 찾기</button>
</form>

</body>
<script>
function btn1() {
	frm.method = "POST";
	frm.action = "./idsearch.do";
	frm.submit();
}

function btn2() {
	frm.method = "POST";
	frm.action = "./passmodify.do";
	frm.submit();
}

</script>

</html>