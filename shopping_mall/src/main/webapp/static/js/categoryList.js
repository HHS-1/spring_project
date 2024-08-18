

window.onload = function(){
	paging(1,"");
	pagingBar("");
}
const pagingBar = function(search){
	const accessToken = sessionStorage.getItem("accessToken");
	fetch('/admin/category/count?search='+search,{
		method : "GET",
		headers : {
			'Authorization' : `Bearer ${accessToken}`
		}
	})
	.then(response=>{
		if(response.ok) return response.json();
	})
	.then(categoryCount=>{
		const paging_bar = document.querySelector("#paging_bar");
		const pageLength = Math.ceil(categoryCount / 5);
		let pageLinks = '';
		for (let a = 1; a <= pageLength; a++) {
		    pageLinks += `<li class="page" onclick="paging(${a},'${search}')">${a}</li>`;
		}
		
		paging_bar.innerHTML = `
			<li><img src="/static/ico/double_left.svg"></li>
	        <li><img src="/static/ico/left.svg"></li>
	       	${pageLinks}
	        <li><img src="/static/ico/right.svg"></li>
	        <li><img src="/static/ico/double_right.svg"></li>
		`;
	})

}
const paging = function(page, search){
	const accessToken = sessionStorage.getItem("accessToken");
	fetch('/admin/category/get?page='+page+'&search='+search,{
		method : "GET",
		headers : {
			'Authorization' : `Bearer ${accessToken}`
		}
	})
	.then(response=>{
		return response.json();
	})
	.then(data=>{
		const category_table = document.querySelector("#category_table");
		category_table.innerHTML = ''; // 테이블 초기화

        // 헤더 추가
        const header = `
            <ul>
                <li><input id="checkAll" type="checkbox"></li>
                <li>분류코드</li>
                <li>대메뉴 코드</li>
                <li>카테고리명</li>
                <li>소메뉴 코드(사용안함)</li>
                <li>소메뉴명(사용안함)</li>
                <li>사용 유/무</li>
                <li>관리</li>
            </ul>
			<ul id="none_category">
		       <li style="width: 100%;">등록된 카테고리가 없습니다.</li>
		    </ul>
        `;
        category_table.innerHTML += header;
	
		if(data != "") document.querySelector("#none_category").style.display = "none";

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
		
		
		
		
		document.querySelector("#checkAll").addEventListener('click', function(){
			allCheck(this);
		});
		
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


document.querySelector("#searchForm").addEventListener('submit', function(event) {
    event.preventDefault();
    paging(1, document.querySelector("#searchWord").value);
    pagingBar(document.querySelector("#searchWord").value);
});
document.querySelector("#btn_delete").addEventListener('click', delete_category);

