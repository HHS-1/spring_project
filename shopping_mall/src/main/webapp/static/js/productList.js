const allCheck = function(allCheckbox){
	document.querySelectorAll("input[name='product_code']").forEach(checkbox=>{
		checkbox.checked = allCheckbox.checked;
	})
}

const checkboxUpdate = function(){
	const allCheckbox = document.querySelector("#checkAll");
    const checkboxes = document.querySelectorAll("input[name='product_code']");
    
    if (Array.from(checkboxes).some(checkbox => !checkbox.checked)) {
        allCheckbox.checked = false;
    } else {
        allCheckbox.checked = true;
    }
}

const deleteProduct = function(){
	const accessToken = sessionStorage.getItem("accessToken");
	const idx_arr = new Array();
	document.querySelectorAll("input[name='product_code']:checked").forEach(checkbox=>{
		idx_arr.push(checkbox.value);
	});
	if(confirm('정말 삭제하시겠습니까?')){
		fetch('/admin/product/delete',{
			method : "POST",
			headers : {
				"Content-Type" : "application/json",
				'Authorization': `Bearer ${accessToken}`,
			},
			body : JSON.stringify(idx_arr),
		})
		.then(response =>{
			if(response.ok){
				location.reload();
			}else if(response.status == 440){
				alert('상품 삭제 오류');
				return false;
			}
		})
		.catch(error => {
			console.log(error);
		})
	}else{
		return false;
	}
	
	
}

document.querySelector("#btn_deleteProduct").addEventListener("click", deleteProduct);

document.querySelectorAll("input[name='idx_product']").forEach(checkbox => {
    		checkbox.addEventListener('change', checkboxUpdate);
});
document.querySelector("#checkAll").addEventListener('click', function(){
	allCheck(this);
});