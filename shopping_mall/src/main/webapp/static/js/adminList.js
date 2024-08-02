
function approveMod(button){
	const idx_admin = button.getAttribute("admin");
	const status = button.getAttribute("case");
	const admin_name = button.getAttribute("admin_name");
	let permissionConfirm = true;
	if(status == 1){
		permissionConfirm = confirm(admin_name + "님의 권한 승인을 해제하시겠습니까?");
	}else{
		permissionConfirm = confirm(admin_name + "님의 권한을 승인하시겠습니까?");
	}
	if(permissionConfirm){
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
	}else{
		return null;
	}
	
}

