<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="0">
    <title>관리자 등록 페이지</title>
    <link rel="stylesheet" type="text/css" href="/static/css/basic.css?v=1">
    <link rel="stylesheet" type="text/css" href="/static/css/login.css?v=2">
    <link rel="stylesheet" type="text/css" href="/static/css/main.css?v=1">
    <link rel="stylesheet" type="text/css" href="/static/css/subpage.css?v=5">
    <link rel="icon" href="/static/images/logo.png" sizes="128x128">
    <link rel="icon" href="/static/images/logo.png" sizes="64x64">
    <link rel="icon" href="/static/images/logo.png" sizes="32x32">
    <link rel="icon" href="/static/images/logo.png" sizes="16x16">
    <script src="/static/js/siteSetting.js?v=7" defer></script>

</head>
<body>
<%@include file="./header.jsp" %>
<main class="maincss">
<section>
    <p>홈페이지 가입환경 설정</p>
<form id="frm1">
<div class="subpage_view">
<ul class="info_form">
    <li>홈페이지 제목</li>
    <li>
    	<input id="dataCheck" type="hidden" value="${settingData.site_name}">
        <input name="site_name" type="text" value="${settingData.site_name}" class="in_form1"> 
    </li>
</ul>    
<ul class="info_form">
    <li>관리자 메일 주소</li>
    <li>
        <input name="admin_email" value="${settingData.admin_email}" type="text" class="in_form2"> ※ 관리자가 보내고 받는 용도로 사용하는 메일 주소를 입력합니다.(회원가입,인증메일,회원메일발송 등에서 사용)
    </li>
</ul> 
<ul class="info_form">
    <li>포인트 사용 유/무</li>
    <li class="checkcss">
    <em><label>
        <input type="radio" name="point_usable" class="ckclass" value="Y" 
            <c:if test="${settingData.point_usable.equals('Y')}">checked</c:if>/>포인트 사용
    </label></em>
	<em><label>
        <input type="radio" name="point_usable" class="ckclass" value="N" 
            <c:if test="${settingData.point_usable.equals('N') or settingData.point_usable == null}">checked</c:if>/>포인트 미사용
    </label></em>

    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>회원가입시 적립금</li>
    <li>
        <input name="reward" value="${settingData.reward}" type="text" class="in_form3" maxlength="5"> 점
    </li>
    <li>회원가입시 권한레벨</li>
    <li>
        <input name="auth_level" value="${settingData.auth_level}" type="text" class="in_form3" maxlength="1"> 레벨
    </li>
</ul> 
</div>
</form>
<p>홈페이지 기본환경 설정</p>
<form id="frm2">
<div class="subpage_view">
<ul class="info_form2">
    <li>회사명</li>
    <li>
        <input name="company_name" value="${settingData.company_name}" type="text" class="in_form0"> 
    </li>
    <li>사업자등록번호</li>
    <li>
        <input name="business_number" value="${settingData.business_number}" type="text" class="in_form0"> 
    </li>
</ul> 
<ul class="info_form2">
    <li>대표자명</li>
    <li>
        <input name="ceo_name" value="${settingData.ceo_name}" type="text" class="in_form0"> 
    </li>
    <li>대표전화번호</li>
    <li>
        <input name="ceo_tel" value="${settingData.ceo_tel}" type="text" class="in_form0"> 
    </li>
</ul>
<ul class="info_form2">
    <li>통신판매업 신고번호</li>
    <li>
        <input name="report_number" value="${settingData.report_number}" type="text" class="in_form0"> 
    </li>
    <li>부가통신 사업자번호</li>
    <li>
        <input name="carrier_number" value="${settingData.carrier_number}" type="text" class="in_form0"> 
    </li>
</ul>
<ul class="info_form2">
    <li>사업장 우편번호</li>
    <li>
        <input name="company_post" value="${settingData.company_post}" type="text" class="in_form0"> 
    </li>
    <li>사업장 주소</li>
    <li>
        <input name="company_address" value="${settingData.company_address}" type="text" class="in_form2"> 
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>정보관리책임자명</li>
    <li>
        <input name="info_manager" value="${settingData.info_manager}" type="text" class="in_form0"> 
    </li>
    <li>정보책임자 E-mail</li>
    <li>
        <input name="info_manager_email" value="${settingData.info_manager_email}" type="text" class="in_form1"> 
    </li>
</ul>
</div>
</form>
<p>결제 기본환경 설정</p>
<form id="frm3">
<div class="subpage_view">  
<ul class="info_form2">
    <li>무통장 은행</li>
    <li>
        <input name="bank_name" value="${settingData.bank_name}" type="text" class="in_form0"> 
    </li>
    <li>은행계좌번호</li>
    <li>
        <input name="account_number" value="${settingData.account_number}" type="text" class="in_form1"> 
    </li>
</ul>
<ul class="info_form">
    <li>신용카드 결제 사용</li>
    <li class="checkcss">
        <em><label><input name="credit_card_usable" type="radio" class="ckclass" value="Y" 
        <c:if test="${settingData.credit_card_usable.equals('Y')}">checked</c:if>> 사용</label></em> 
        <em><label><input name="credit_card_usable" type="radio" class="ckclass" value="N" 
        <c:if test="${settingData.credit_card_usable.equals('N') or settingData.point_usable == null}">checked</c:if>> 미사용</label></em> ※ 해당 PG사가 있을 경우 사용으로 변경합니다.
    </li>
</ul>
<ul class="info_form">
    <li>휴대폰 결제 사용</li>
    <li class="checkcss">
        <em><label><input name="mobile_payment_usable" type="radio" class="ckclass" value="Y"
        <c:if test="${settingData.mobile_payment_usable.equals('Y')}">checked</c:if>> 사용</label></em> 
        <em><label><input name="mobile_payment_usable" type="radio" class="ckclass" value="N" 
        <c:if test="${settingData.mobile_payment_usable.equals('N') or settingData.point_usable == null}">checked</c:if>> 미사용</label></em> ※ 주문시 휴대폰 결제를 가능하게 할 것인지를 설정합니다.
    </li>
</ul>
<ul class="info_form">
    <li>도서상품권 결제사용</li>
    <li class="checkcss">
        <em><label><input name="book_coupon_usable" type="radio" class="ckclass" value="Y"
        <c:if test="${settingData.book_coupon_usable.equals('Y')}">checked</c:if>> 사용</label></em> 
        <em><label><input name="book_coupon_usable" type="radio" class="ckclass" value="N" 
        <c:if test="${settingData.book_coupon_usable.equals('N') or settingData.point_usable == null}">checked</c:if>> 미사용</label></em> ※ 도서상품권 결제만 적용이 되며, 그 외에 상품권은 결제 되지 않습니다.
    </li>
</ul>
<ul class="info_form2">
    <li>결제 최소 포인트</li>
    <li>
        <input type="text" value="${settingData.min_point}" name="min_point" class="in_form0" maxlength="5" value="1000"> 점
    </li>
    <li>결제 최대 포인트</li>
    <li>
        <input type="text" value="${settingData.max_point}" name="max_point" class="in_form0" maxlength="5"> 점
    </li>
</ul>
<ul class="info_form">
    <li>현금 영수증 발급사용</li>
    <li class="checkcss">
        <em><label><input name="receipt_usable" type="radio" class="ckclass" value="Y"
        <c:if test="${settingData.receipt_usable.equals('Y')}">checked</c:if>> 사용</label></em> 
        <em><label><input name="receipt_usable" type="radio" class="ckclass" value="N"
         <c:if test="${settingData.receipt_usable.equals('N') or settingData.point_usable == null}">checked</c:if>> 미사용</label></em> ※ 현금영수증 관련 사항은 PG사 가입이 되었을 경우 사용가능 합니다.
    </li>
</ul>
<ul class="info_form2">
    <li>배송업체명</li>
    <li>
        <input name="delivery_company" value="${settingData.delivery_company}" type="text" class="in_form0"> 
    </li>
    <li>배송비 가격</li>
    <li>
        <input name="delivery_fee" value="${settingData.delivery_fee}" type="text" class="in_form0" maxlength="7"> 원
    </li>
</ul>
<ul class="info_form" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>희망배송일</li>
    <li class="checkcss">
        <em><label><input name="delivery_date_usable" type="radio" class="ckclass" value="Y"
        <c:if test="${settingData.delivery_date_usable.equals('Y')}">checked</c:if>> 사용</label></em> 
        <em><label><input name="delivery_date_usable" type="radio" class="ckclass" value="N"
        <c:if test="${settingData.delivery_date_usable.equals('N') or settingData.point_usable == null}">checked</c:if>> 미사용</label></em> ※ 희망배송일 사용시 사용자가 직접 설정 할 수 있습니다.
    </li>
</ul>
</div>
</form>
<div class="btn_div">
    <button id="btn_setting_save" type="button" class="sub_btn1" title="설정 저장" onclick="">설정 저장</button>
    <button type="button" class="sub_btn2" title="저장 취소">저장 취소</button>
</div>
</section>
<section></section>
<section></section>
</main>
<footer class="main_copyright">
    <div>
        Copyright ⓒ 2024 shopbag All rights reserved.
    </div>
</footer>
</body>
</html>