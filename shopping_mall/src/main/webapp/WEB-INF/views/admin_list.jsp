<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 등록 페이지</title>
    <link rel="stylesheet" type="text/css" href="../static/css/basic.css">
    <link rel="stylesheet" type="text/css" href="../static/css/login.css?v=1">
    <link rel="stylesheet" type="text/css" href="../static/css/main.css?v=1">
    <link rel="icon" href="../static/images/logo.png" sizes="128x128">
    <link rel="icon" href="../static/images/logo.png" sizes="64x64">
    <link rel="icon" href="../static/images/logo.png" sizes="32x32">
    <link rel="icon" href="../static/images/logo.png" sizes="16x16">
</head>
<body>
<header class="headercss">
    <div class="header_div">
        <p><img src="../static/images/logo.png" class="logo_sm"> ADMINISTRATOR</p>
        <p>홍길동 관리자 <a href="#">[개인정보 수정]</a> <a href="#">[로그아웃]</a></p>
    </div>
</header>
<nav class="navcss">
    <div class="nav_div">
        <ol>
            <li title="쇼핑몰 상품관리">쇼핑몰 관리자 리스트</li>
            <li title="쇼핑몰 회원관리">쇼핑몰 회원관리</li>
            <li title="쇼핑몰 상품관리">쇼핑몰 상품관리</li>
            <li title="쇼핑몰 기본설정">쇼핑몰 기본설정</li>
        </ol>
    </div>

</nav>
<main class="maincss">
<section>
    <p>신규등록 관리자</p>
    <ol class="new_admin_title2">
        <li>NO</li>
        <li>관리자명</li>
        <li>아이디</li>
        <li>전화번호</li>
        <li>이메일</li>
        <li>담당부서</li>
        <li>담당직책</li>
        <li>가입일자</li>
        <li>승인여부</li>
    </ol>
    <c:if test="${adminInfo == null}">
    <ol class="new_admin_none">
        <li>신규 등록된 관리자가 없습니다.</li>
    </ol>
    </c:if>
    <c:forEach var="adminInfo" items="${adminInfo}" varStatus="status">
    <ol class="new_admin_lists2">
        <li>${status.index + 1}</li>
        <li>${adminInfo.admin_name}</li>
        <li>${adminInfo.admin_id}</li>
        <li>${adminInfo.admin_tel}</li>
        <li>${adminInfo.admin_email}</li>
        <li>${adminInfo.admin_part}</li>
        <li>${adminInfo.admin_position}</li>
        <li>${adminInfo.formatted_join_date}</li>
        <li>
        <c:if test="${adminInfo.permission == 'Y'}">
            <input type="button" value="승인" class="new_addbtn1" title="승인">
        </c:if>
        <c:if test="${adminInfo.permission == 'N'}">
            <input type="button" value="미승인" class="new_addbtn2" title="미승인">
        </c:if>
        </li>
    </ol>
    </c:forEach>
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