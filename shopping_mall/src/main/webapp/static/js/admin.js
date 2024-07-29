
//아이디 중복체크
document.querySelector("#btn_idCheck").addEventListener("click", ()=>{
	const id = document.querySelector("#admin_id").value;
	console.log(id);
	fetch("./id_check?id="+id)
	.then(response=>{
		if(response.ok){
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
	for(let a = 1 ; a <= 3 ; a++){
		document.querySelector("#admin_tel").value += document.querySelector("#hp"+a).value;
	}
	for(let a = 0 ; a < key.length ; a++){
		data[key[a]] = document.querySelector("#"+key[a]).value;
	}
	console.log(data);
	fetch("./signup",{
		method : "POST",
		headers : {
			"Content-Type" : "application/json",
		},
		body : JSON.stringify(data),
	})
	.then(response =>{
		console.log(response);
	})
	.catch(error=>{
		console.log(error);
	})
	
});