<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pay - 고객정보 입력 및 결제금액 정보셋팅</title>
</head>
<body>
<form id="frm" method="post" action="./pay3.do" enctype="application/x-www-form-urlencoded">
<input type="hidden" name="goodcode" value="${stringList.get(0)}">
<input type="hidden" name="goodname" value="${stringList[1]}">
<input type="hidden" name="goodea" value="${stringList[3]}">
<input type="hidden" name="goodprice" value="${stringList[2]}">
<input type="hidden" name="price" value="${stringList[4]}">
상품코드 : ${stringList.get(0)}<br>
상품명 : ${stringList[1]}<br>
상품가격 : ${stringList[2]}원<br>
상품갯수 : ${stringList[3]}EA<br>
총결제금액 : <fn:formatNumber value="${stringList[4]}" pattern="#,###"/> 원<br>
<p>고객정보입력</p>
고객명 : <input type="text" name="buyername"><br>
연락처 : <input type="text" name="buyertel" maxlength="11"> *"-" 숫자만 입력<br>
이메일 : <input type="text" name="buyeremail"> * 실제 이메일 주소<br>
주소 : <input type="text" name="rec_post" maxlength="5" value="07283"><br>
<input type="text" name="rec_way" placeholder="도로명주소" value="서울특별시 영등포구 선유서로 31"><br>
<input type="text" name="rec_addr" placeholder="상세주소" value="101동 411호"><br>
<p>결제방식</p>
<input type="radio" name="gopaymethod" value="Card" checked> 신용카드
<input type="radio" name="gopaymethod" value="DirectBank"> 계좌이체
<input type="radio" name="gopaymethod" value="VBank"> 가상계좌이체
<br>
<input type="button" value="결제 선택완료" onclick="gopay()">
</form>
</body>
<script>
function gopay(){
	frm.submit();
}
</script>
</html>