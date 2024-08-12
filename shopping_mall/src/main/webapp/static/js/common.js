const logout = function(){
	console.log("logout");
	sessionStorage.removeItem("accessToken");
	sessionStorage.clear();
	fetch("/admin/logout/api",{
		cache : "no-cache",
	})
	.then(response=>{
		if(response.redirected){
			window.location.replace(response.url);
		}
	})
	.catch(error => {
		alert('err');
	})

}
document.querySelector("#btn_logout").addEventListener("click",logout);


