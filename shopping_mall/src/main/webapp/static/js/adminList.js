
const logout = function(){
	sessionStorage.removeItem("accessToken");
	sessionStorage.clear();
	location.href="./logout/api";
}

function approveMod(button){
	const idx_admin = button.getAttribute("admin");
	const status = button.getAttribute("case");
	const admin_name = button.getAttribute("admin_name");
	console.log(idx_admin);
	console.log(status);
	fetch("./permission",{
		method : "POST",
		headers : {
			"Content-Type": "application/json",
		},
		body : JSON.stringify({
			"idx_admin" : idx_admin,
			"status" : 	status,
		}),
	})
	.then(response=>{
		if(response.ok){
			alert(admin_name + '님의 권한이 변경되었습니다.');
			location.href="./list";
		}else{
			alert('권한 변경 실패');
		}
	})
	.catch(error=>{
		console.log(error);
	})
}

document.querySelector("#btn_logout").addEventListener("click",logout);
