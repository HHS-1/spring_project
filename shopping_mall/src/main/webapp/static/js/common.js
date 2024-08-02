
const logout = function(){
	sessionStorage.removeItem("accessToken");
	sessionStorage.clear();
	location.href="./logout/api";
	location.reload();
}
document.querySelector("#btn_logout").addEventListener("click",logout);


