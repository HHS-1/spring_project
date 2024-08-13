<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 등록 페이지</title>
    <link rel="stylesheet" type="text/css" href="/static/css/basic.css">
    <link rel="stylesheet" type="text/css" href="/static/css/login.css?v=1">
    <link rel="stylesheet" type="text/css" href="/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="/static/css/product.css?v=6">
    <link rel="icon" href="/static/img/logo.png" sizes="128x128">
    <link rel="icon" href="/static/img/logo.png" sizes="64x64">
    <link rel="icon" href="/static/img/logo.png" sizes="32x32">
    <link rel="icon" href="/static/img/logo.png" sizes="16x16">
    <script src="/static/js/uploadFile.js" defer></script>
    <script src="/static/js/productList.js?v=1" defer></script>
</head>
<body>
<%@include file="./header.jsp" %>
<main class="maincss">
<section>
<p>상품관리 페이지</p>
<div class="subpage_view">
    <span>등록된 상품 0건</span>
    <span>
        <form>
        <select class="p_select1">
            <option>상품명</option>
            <option>상품코드</option>
        </select>
        <input type="text" class="p_input1" placeholder="검색어를 입력해 주세요">
        <input type="submit" value="검색" title="상품검색" class="p_submit">
        </form>
    </span>
</div>
<div class="image_box">
	<div class="upload_box">
		<%@include file="./upload_box.jsp"%>
	</div>
</div>
<div class="subpage_view2">
    <ul>
        <li><input id="checkAll" type="checkbox"></li>
        <li>상품코드</li>
        <li>상품 이미지</li>
        <li>상품명</li>
        <li>카테고리 분류</li>
        <li>판매가격</li>
        <li>할인가격</li>
        <li>할인율</li>
        <li>재고현황</li>
        <li>판매유/무</li>
        <li>품절</li>
        <li>관리</li>
    </ul>
    <c:forEach var="products" items="${products}">
    <ul>
        <li><input name="product_code" type="checkbox" value="${products.product_code}"></li>
        <li>${products.product_code}</li>
        <li><input class="btn_getImage" type="button" value="상품 이미지" onclick="getProductImages(${products.product_code})"></li>
        <li>${products.product_name}</li>
        <li>${products.menu_sort}</li>
        <li>${products.product_price}</li>
        <li>${products.product_discount_price}</li>
        <li>${products.product_discount_rate}</li>
        <li>${products.product_each}</li>
        <li>${products.sale_usable}</li>
        <li>${products.soldout_usable}</li>
        <li>관리</li>
    </ul>
    </c:forEach>
    <c:if test="${empty products}">
    <ul>
        <li style="width: 100%;">등록된 상품이 없습니다.</li>
    </ul>
    </c:if>
</div>
<div class="subpage_view3">
    <ul class="pageing">
        <li><img src="/static/ico/double_left.svg"></li>
        <li><img src="/static/ico/left.svg"></li>
        <li>1</li>
        <li><img src="/static/ico/right.svg"></li>
        <li><img src="/static/ico/double_right.svg"></li>
    </ul>
</div>
<div class="subpage_view4">
    <input type="button" id="btn_deleteProduct" value="선택상품 삭제" title="선택상품 삭제" class="p_button">
    <span style="float: right;">
    <input type="button" value="신규상품 등록" title="신규상품 등록" class="p_button p_button_color1" onclick="location.href='/admin/product/add';">
    <input type="button" value="카테고리 관리" title="카테고리 관리" onclick="location.href='/admin/category';" class="p_button p_button_color2">
    </span>
</div>
</section>
</main>
<footer class="main_copyright">
    <div>
        Copyright ⓒ 2024 shopbag All rights reserved.
    </div>
</footer>
</body>
</html>