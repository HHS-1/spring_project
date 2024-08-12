<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" type="text/css" href="/static/css/category.css?v=7">
    <link rel="icon" href="/static/img/logo.png" sizes="128x128">
    <link rel="icon" href="/static/img/logo.png" sizes="64x64">
    <link rel="icon" href="/static/img/logo.png" sizes="32x32">
    <link rel="icon" href="/static/img/logo.png" sizes="16x16">
    <script src="/static/js/category.js?v=1" defer></script>
</head>
<body>
<%@include file="./header.jsp" %>
<main class="maincss">
<section>
    <p>카테고리 등록 페이지</p>
    <div class="cate_insert">
        <ul >
            <li>분류코드</li>
            <li><input id="sort_code" type="text" class="cate_input1" readonly></li>
            <li>※ 분류코드는 대메뉴 코드와 소메뉴 코드를 합쳐서 자동 입력 됩니다.</li>
        </ul>
        <ul>
            <li>대메뉴 코드</li>
            <li class="parent">
                <input id="menu_code" type="text" class="cate_input2">
                <select id="lg_menu" class="dropdown-select">
                	<option selected disabled>선택하세요</option>
                    <option>01</option>
                    <option>02</option>
                    <option>03</option>
                    <option>04</option>
                </select>
                <span class="arrow">&#9662;</span>
            </li>
            <li>※ 대메뉴에 사용할 코드 번호를 입력하세요 최소 2자 이상의 숫자로 입력하셔야 합니다.</li>
        </ul>
        <ul>
            <li>대메뉴명</li>
            <li><input id="menu_name" type="text" class="cate_input3"> <label><!--<input type="checkbox" style="margin-left:10px; margin-right: 5px;">대메뉴만 생성</label>--></li>
            <li>※ 소메뉴만 등록시 대메뉴 코드와 대메뉴명은 무조건 입력 되어야 합니다.</li>
        </ul>
        <ul>
            <li>소메뉴 코드(사용안함)</li>
            <li>

            </li>
            <li>※ 소메뉴에 사용할 코드 번호를 입력하세요 최소 2자 이상의 숫자로 입력하셔야 합니다.</li>
        </ul>
        <ul>
            <li>소메뉴명(사용안함)</li>
            <li></li>
            <li>※ 대메뉴만 등록시 소메뉴 코드 및 소메뉴명은 입력하지 않으셔도 됩니다.</li>
        </ul>
        <ul>
            <li>사용 유/무</li>
            <li>
                <label class="rmargin"><input type="radio" name="category_usable" value="Y" checked>사용함 </label>
                <label class="rmargin"><input type="radio" name="category_usable" value="N">사용안함</label>
            </li>
            <li>※ 카테고리 사용안함으로 설정시 쇼핑몰에 해당 메뉴는 생성 되지 않습니다.</li>
        </ul>
    </div>
    <div class="subpage_view4" style="text-align:center;">
        <input type="button" value="카테고리 리스트" title="카테고리 리스트" class="p_button p_button_color1" style="margin-right: 5px;" onclick="location.href='/admin/category'">
        <input type="button" id="btn_addCategory" value="카테고리 생성" title="카테고리 생성" class="p_button p_button_color2">
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