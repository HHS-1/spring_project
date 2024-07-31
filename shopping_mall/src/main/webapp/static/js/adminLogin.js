//로그인
document.querySelector("#login_frm").addEventListener("submit", event=>{
	event.preventDefault();
	login();
});

//로그인 fetch
const login = function(){
	const id = document.querySelector("#admin_id").value;
	const pw = document.querySelector("#admin_pw").value;

	fetch("./login/api",{
		method : "POST",
		headers : {
			"Content-Type" : "application/json",
		},
		body : JSON.stringify({
			admin_id : id,
			admin_pw : pw
		}),
	})
	.then(response => {
		if(response.ok){
			return response.text();
		}else if(response.status == 433){
			alert('미승인 관리자입니다.\n관련 문의는 보안팀(1644-5470)으로 해주시기 바랍니다.')
		}else{
			alert('아이디 또는 비밀번호를 확인해주세요');
		}
	})
	.then(tokens=>{
		saveToken(tokens.accessToken);
		alert("로그인성공")
		location="./list";
	})
	.catch(error=>{
		console.log(error);
	})
}

//토큰 저장
function saveToken(token) {
    localStorage.setItem('accessToken', token);
}

// 토큰 get
function getToken() {
    return localStorage.getItem('accessToken');
}

// 토큰 삭제
function removeToken() {
    localStorage.removeItem('authToken');
}

