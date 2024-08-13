window.onload = function(){
	const accessToken = sessionStorage.getItem("accessToken");
	fetch('/admin/category/get',{
		method : "GET",
		headers : {
			'Authorization' : `Bearer ${accessToken}`
		}
	})
	.then(response=>{
		return response.json();
	})
	.then(data=>{
		
		if(data != "") document.querySelector("#none_category").style.display = "none";
		
		
		const category_table = document.querySelector("#category_table");
		data.forEach(data=>{
			const category_list = document.createElement('ul');
			category_list.innerHTML = `
            <li><input name="idx_category" type="checkbox" value="${data.idx_category}"></li>
            <li id="sort_code" style="text-align: left; text-indent: 5px;">
                <input type="text" class="item-input" value="${data.sort_code}" readonly>
            </li>
            <li><input type="text" class="item-input" value="${data.menu_code}" readonly></li>
            <li style="text-align: left; text-indent: 5px;">
                <input type="text" class="item-input" value="${data.menu_name}" readonly>
            </li>
            <li>-</li>
            <li style="text-align: left; text-indent: 5px;">-</li>
            <li><input type="text" class="item-input" value="${data.category_usable}" readonly></li>
            <li>[수정]</li>
        `;
		category_table.appendChild(category_list);
		})
		
		document.querySelectorAll("input[name='idx_category']").forEach(checkbox => {
    		checkbox.addEventListener('change', checkboxUpdate);
		});
		
	})
	.catch(error=>{
		console.log(error);
	})
}


const delete_category = function(){
	const accessToken = sessionStorage.getItem("accessToken");
	const idx_arr = new Array();
	document.querySelectorAll("input[name='idx_category']:checked").forEach(checkbox=>{
		idx_arr.push(checkbox.value);
	})
	
	fetch('/admin/category/delete',{
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
		}else if(response.status == 437){
			alert('해당 카테고리로 등록된 상품이 존재해 삭제가 불가능합니다.');
			return false;
		}
	})
	.catch(error => {
		console.log(error);
	})
}

const allCheck = function(allCheckbox){
	document.querySelectorAll("input[name='idx_category']").forEach(checkbox=>{
		checkbox.checked = allCheckbox.checked;
	})
}

const checkboxUpdate = function(){
	const allCheckbox = document.querySelector("#checkAll");
    const checkboxes = document.querySelectorAll("input[name='idx_category']");
    
    if (Array.from(checkboxes).some(checkbox => !checkbox.checked)) {
        allCheckbox.checked = false;
    } else {
        allCheckbox.checked = true;
    }
}





document.querySelector("#checkAll").addEventListener('click', function(){
	allCheck(this);
});
document.querySelector("#btn_delete").addEventListener('click', delete_category);

