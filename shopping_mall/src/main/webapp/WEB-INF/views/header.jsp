<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
   	 String contextPath = request.getContextPath();
	%>
<script src="/static/js/common.js?v=1" defer></script>
<header class="headercss">
    <div class="header_div">
        <p><img src="<%=contextPath%>/static/images/logo.png" class="logo_sm"> ADMINISTRATOR</p>
        <p>${userName}님 <button class="btn_top">[개인정보 수정]</button> <button class="btn_top" id="btn_logout">[로그아웃]</button></p>
    </div>
</header>
<nav class="navcss">
    <div class="nav_div">
        <ol>
        <c:if test="${permission.equals('M')}">
            <li title="쇼핑몰 상품관리"><a href="<%=contextPath%>/admin/list">쇼핑몰 관리자 리스트</a></li>
		</c:if>
            <li title="쇼핑몰 회원관리">쇼핑몰 회원관리</li>
            <li title="쇼핑몰 상품관리"><a href="<%=contextPath%>/admin/product">쇼핑몰 상품관리</a></li>
            <li title="쇼핑몰 기본설정"><a href="<%=contextPath%>/admin/setting/shop">쇼핑몰 기본설정</a></li>
        </ol>
    </div>
</nav>