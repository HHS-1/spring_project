<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품등록 페이지</title>
	<link rel="stylesheet" type="text/css" href="/static/css/basic.css">
	<link rel="stylesheet" type="text/css" href="/static/css/login.css?v=1">
	<link rel="stylesheet" type="text/css" href="/static/css/main.css">
	<link rel="stylesheet" type="text/css" href="/static/css/product.css?v=9">
    <link rel="icon" href="/static/img/logo.png" sizes="128x128">
    <link rel="icon" href="/static/img/logo.png" sizes="64x64">
    <link rel="icon" href="/static/img/logo.png" sizes="32x32">
    <link rel="icon" href="/static/img/logo.png" sizes="16x16">
    <script src="/static/js/common.js?v=3" defer></script>
    <script src="/static/js/product.js?v=1" defer></script>
</head>
<body>
<%@include file="./header.jsp" %>
<main class="maincss">
<section>
<p>상품 등록 페이지</p>
<form id="frm_product" enctype="multipart/form-data">
<div class="product_insert">
    <ul>
        <li>대메뉴 카테고리</li>
        <li>
            <select class="product_input1" name="menu_code">
            	<option disabled selected>선택하세요</option>
            <c:forEach var="menu" items="${categoryMenu}">
                <option value="${menu.menu_code}">${menu.menu_code}. ${menu.menu_name}</option>
            </c:forEach>
            </select>
            <input type="button" value="카테고리 등록" title="카테고리 등록" class="product_btn" onclick="location.href='/admin/category/add'"> <span class="help_text">※ 해당 카테고리가 없을 경우 신규 등록하시길 바랍니다.</span>
        </li>
    </ul>
    <ul>
        <li>상품코드</li>
        <li>
            <input type="text" id="product_code" name="product_code" class="product_input1"> 
            <input type="button" id="btn_randomCode" value="자동생성" title="자동생성" class="product_btn">
            <input type="button" id="btn_codeCheck" value="중복확인" title="중복확인" class="product_btn"> <span class="help_text">※ 상품코드는 절대 중복되지 않도록 합니다.</span>
        </li>
    </ul>
    <ul>
        <li>상품명</li>
        <li>
            <input type="text" name="product_name" class="product_input2" maxlength="100"> <span class="help_text">※ 상품명은 최대 100자까지만 적용할 수 있습니다.</span>
        </li>
    </ul>
    <ul>
        <li>상품 부가설명</li>
        <li>
            <input type="text" name="product_info" class="product_input4" maxlength="200"> <span class="help_text">※ 상품부가설명은 최대 200자까지만 적용할 수 있습니다.</span>
        </li>
    </ul>
    <ul>
        <li>판매가격</li>
        <li>
            <input type="text" name="product_price" class="product_input3" maxlength="7"> <span class="help_text">※ , 없이 숫자만 입력하세요 최대 7자리</span>
        </li>
    </ul>
    <ul>
        <li>할인율</li>
        <li>
            <input type="text" name="product_discount_rate" class="product_input3" maxlength="2" value="0">% <span class="help_text">※ 숫자만 입력하세요</span>
        </li>
    </ul>
    <ul>
        <li>할인가격</li>
        <li>
            <input type="text" name="product_discount_price" class="product_input3" maxlength="7" value="0" readonly> <span class="help_text">※ 할인율이 0%일 경우 할인가격은 0으로 처리 합니다.</span>
        </li>
    </ul>
    <ul>
        <li>상품재고</li>
        <li>
            <input type="text" name="product_each" class="product_input3" maxlength="4" value="0">EA <span class="help_text">※ 숫자만 입력하세요. 재고가 0일 경우 soldout이 됩니다.</span>
        </li>
    </ul>
    <ul>
        <li>판매 유/무</li>
        <li>
            <label class="product_label">
            <input type="radio" name="sale_usable" style="vertical-align:-1px;" value="Y" checked> 판매시작
            </label>
            <label class="product_label">
            <input type="radio" name="sale_usable" style="vertical-align:-1px;" value="N"> 판매종료
            </label> <span class="help_text">※ 숫자만 입력하세요. 재고가 0일 경우 soldout이 됩니다.</span>
        </li>
    </ul>
    <ul>
        <li>조기품절</li>
        <li>
            <label class="product_label">
                <input type="radio" name="soldout_usable" style="vertical-align:-1px;" value="Y"> 사용
            </label>
            <label class="product_label">
                <input type="radio" name="soldout_usable" style="vertical-align:-1px;" value="N" checked> 미사용
            </label>
        </li>
    </ul>
    <ul style="height: 180px;">
        <li>상품 대표이미지</li>
        <li>
            <ol style="width:620px; height: auto; display : flex">
	            <li>
		            <div id="preview1" class="preview">
		            	<span class="plus">+</span>
		            </div>
		            <div>
			            <input type="file" id="product_image1" name="product_image1" style="display:none">
			            <!-- <span class="help_text">※ 상품 대표이미지 이며, 이미지 용량은 2MB 까지 입니다.</span> -->
		            </div>
	            </li>
	            <li>
		            <div id="preview2" class="preview">
		            	<span  class="plus">+</span>
		            </div>
		            <div>
			            <input type="file" id="product_image2" name="product_image2" style="display:none">   
		            </div>
	            </li>
	            <li>
		            <div id="preview3" class="preview">
		            	<span class="plus">+</span>
		            </div>
		            <div>
			            <input type="file" id="product_image3" name="product_image3" style="display:none">			   
		            </div>
	            </li>
            </ol>
        <span class="help_text">※ 이미지 용량은 2MB 까지 입니다.</span>
        </li>
    </ul>
    <ul style="height: 400px;">
        <li>상품 상세설명</li>
        <li>
            <textarea name="product_detail" class="product_text1" style="resize : none"></textarea>
        </li>
    </ul>
</div>
</form>
<div class="subpage_view4" style="text-align:center; margin-bottom: 100px;">
    <input type="button" value="상품 리스트" title="상품 리스트" class="p_button p_button_color1" style="margin-right: 5px;">
    <input type="button" id="btn_createProduct" value="상품 등록" title="상품 등록" class="p_button p_button_color2">
    
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