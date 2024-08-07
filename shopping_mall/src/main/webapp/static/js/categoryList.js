window.onload = function(){
	fetch('/admin/category/get')
	.then(response=>{
		return response.json();
	})
	.then(data=>{
		
		if(data != "") document.querySelector("#none_category").style.display = "none";
		
		
		const category_table = document.querySelector("#category_table");
		data.forEach(data=>{
			const category_list = document.createElement('ul');
			category_list.innerHTML = `
            <li><input type="checkbox"></li>
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
	})
	.catch(error=>{
		console.log(error);
	})
}