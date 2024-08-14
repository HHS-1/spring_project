const addCategory = function(){
	const accessToken = sessionStorage.getItem("accessToken");
	const categoryData = {
		sort_code : document.querySelector("#sort_code").value,
		menu_code : document.querySelector("#menu_code").value,
		menu_name : document.querySelector("#menu_name").value,
		category_usable : document.querySelector("input[name='category_usable']:checked").value
	}
	console.log(categoryData);
	fetch("/admin/category/create",{
		method : "POST",
		headers : {
			'Authorization': `Bearer ${accessToken}`,
			"Content-Type" : "application/json",
		},
		body : JSON.stringify(categoryData),		
	})
	.then(response=>{
		if(response.ok){
			alert('생성이 완료되었습니다.');
			location.reload();
		}else if(response.status = 436){
			alert('대메뉴코드가 중복됩니다');
			return false;
		}
	})
	.catch(error=>{
		console.log(error);
	})
}

document.querySelector("#lg_menu").addEventListener("change",function(){
	document.querySelector("#menu_code").value = this.value;
	document.querySelector("#sort_code").value = this.value;
})
document.querySelector("#btn_addCategory").addEventListener("click", addCategory);
