<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 페이지</title>
    <link rel="stylesheet" type="text/css" href="../static/css/basic.css">
    <link rel="stylesheet" type="text/css" href="../static/css/mainlogin.css?v=3">
    <link rel="icon" href="../static/images/logo.png" sizes="128x128">
    <link rel="icon" href="../static/images/logo.png" sizes="64x64">
    <link rel="icon" href="../static/images/logo.png" sizes="32x32">
    <link rel="icon" href="../static/images/logo.png" sizes="16x16">
</head>
<body class="bodycss">
    <header class="admin_title">
        <p><img src="../static/images/logo.png" class="logo_sm"> ADMINISTRATOR</p>
    </header>
    
	<form id="login_frm">
    <section class="admin_bgcolor">
        <div class="admin_login">
            <span>
                <div class="left_div">
                <ul>
                <li><input type="text" id="admin_id" class="input_text1" placeholder="관리자 아이디를 입력하세요"></li>
                <li><input type="password" id="admin_pw" class="input_text1" placeholder="관리자 패스워드를 입력하세요"></li>
                </ul>
                </div>
                <div class="right_div">
                    <button id="btn_login" type="submit" class="btn_submit" title="MASTER LOGIN">MASTER LOGIN</button>
                </div>
                <em class="alert_msg">※ 본 사이트는 관리자 외에는 접근을 금합니다. 페이지 접근에 대한 접속 정보는 모두 기록 됩니다.</em>
            </span>
            <span>
                <ol class="admin_info">
                    <li title="신규 관리자 등록요청">신규 관리자 등록요청</li>
                    <li title="아이디/패스워드 찾기">아이디/패스워드 찾기</li>
                </ol>                
            </span>
        </div>
    </section>
	</form>
    <footer class="admin_copy_login">
        <div>
            Copyright ⓒ 2024 shopbag All rights reserved.
        </div>
    </footer>
</body>
<script src="../static/js/adminLogin.js"></script>
</html>