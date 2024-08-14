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
			}else {
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

const getProductImages = function(product_code) {
	for(let a = 1 ; a < 4 ; a++){ // preview 버그 방지 초기화
		const preview = document.querySelector("#preview" + a);
		preview.innerHTML = '';
	}
	
    fetch('/admin/product/getImage?code=' + product_code)
    .then(response => {
        if (response.ok) {
            return response.json(); 
        }
        throw new Error('Network response was not ok.');
    })
    .then(images => {
		images.forEach((image, index)=>{
			const preview = document.querySelector("#preview" + (index + 1));
			const imageName = image.split("/").pop();
			const img = document.createElement('img');
			img.src='/admin/images/'+imageName;
			img.style.width = "100%";
            img.style.height = "100%";
			preview.innerHTML = ''; 
            preview.appendChild(img); 
			
			img.addEventListener('click', ()=>{
				const imagePopup = document.querySelector("#imagePopup");
				const modalImage = document.querySelector("#modalImage");
				imagePopup.style.display="block";
				modalImage.src = img.src;
				modalImage.style.width = "100%";
				modalImage.style.height = "100%";
				
			})
		});
		
		document.querySelector("#image_box").style.display = 'flex';
		document.querySelector("#modal").style.display = 'block';
    })
    .catch(error => {
        alert('파일을 불러올 수 없습니다: ' + error.message);
    });
};


document.querySelector("#closeModal").addEventListener("click",()=>{
	document.querySelector("#imagePopup").style.display = "none";
})

//모달창, 이미지 팝업 닫기
document.querySelector("#modal").addEventListener("click", function(){
	this.style.display = "none";
	document.querySelector("#image_box").style.display = "none";
	document.querySelector("#imagePopup").style.display = "none";
})

document.querySelector("#btn_deleteProduct").addEventListener("click", deleteProduct);

document.querySelectorAll("input[name='idx_product']").forEach(checkbox => {
    		checkbox.addEventListener('change', checkboxUpdate);
});
document.querySelector("#checkAll").addEventListener('click', function(){
	allCheck(this);
});