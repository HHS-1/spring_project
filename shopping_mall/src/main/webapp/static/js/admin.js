let usableId = false;
let usablePw = false;
//아이디 중복체크
document.querySelector("#btn_idCheck").addEventListener("click", ()=>{
	const id = document.querySelector("#admin_id").value;
	
	if(id == ""){
		alert('아이디를 입력해주세요');
		return false;
	}
	
	fetch("/admin/idCheck?id="+id)
	.then(response=>{
		if(response.ok){
			usableId = true;
			alert("사용가능한 아이디입니다.");
		}else{
			alert("아이디가 중복됩니다.");
		}
	})
	.catch(error=>{
		alert("서버 오류");
	})
});


//관리자 회원가입
const key = ["admin_id", "admin_pw", "admin_name", "admin_email", "admin_tel", "admin_part", "admin_position"];
document.querySelector("#btn_adminSignup").addEventListener("click", ()=>{
	const data = {};
	document.querySelector("#admin_tel").value = ""; 
	
	//아이디 중복, 비밀번호 불일치 체크
	if(usableId == false){
		alert('아이디 중복체크를 해주세요')
		return false;
	}else if(usablePw == false){
		alert('비밀번호가 일치하지 않습니다.')
		return false;
	}
		
	//휴대폰 번호 합산
	for(let a = 1 ; a <= 3 ; a++){
		document.querySelector("#admin_tel").value += document.querySelector("#hp"+a).value;
	}
	
	//빈 값 체크 & 데이터 객체로 전환
	for(let a = 0 ; a < key.length ; a++){
		const info = document.querySelector("#"+key[a]).value
		if(info == ""){
			alert('필수 값을 모두 입력해주세요');
			return false;
		}
		data[key[a]] = info;
	}

	fetch("/admin/signup/api",{
		method : "POST",
		headers : {
			"Content-Type" : "application/json",
		},
		body : JSON.stringify(data),
	})
	.then(response =>{
		if(response.ok){
			alert(data.admin_name + '님 반갑습니다. 로그인은 관리자 승인 후 가능합니다.');
			location.href = './login';
		}
	})
	.catch(error=>{
		console.log(error);
	})
	
});

//비밀번호 확인
document.querySelector("#admin_pw_check").addEventListener("keyup",function(){
	const pw_msg = document.querySelector("#pw_msg");
	if(this.value == document.querySelector("#admin_pw").value || this.value == ""){
		usablePw = true;
		pw_msg.style.display = "none";
	}else{
		usablePw = false;
		pw_msg.style.display = "block";
	}
})

