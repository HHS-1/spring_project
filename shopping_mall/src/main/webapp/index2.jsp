<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Session 연습</title>
</head>
<body>
<form id="frm">
ID : <input type="text" name="mid">
<input type="button" value="전송" onclick="post_data()">
</form>
</body>

<script>
function post_data(){
	frm.method="post";
	frm.action = "./loginok.do";
	frm.submit();
}
</script>
</html>