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
			alert('로그인에 성공하셨습니다.')
		}else if(response.status == 433){
			alert('승인 처리중입니다.\n관련 문의는 보안팀(1644-5470)으로 해주시기 바랍니다.')
		}else{
			alert('아이디 또는 비밀번호를 확인해주세요');
		}
	})
	.catch(error=>{
		console.log(error);
	})
}

document.querySelector("#login_frm").addEventListener("submit", event=>{
	event.preventDefault();
	login();
});