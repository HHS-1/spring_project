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
    fetch('/admin/product/getImage?code=' + product_code)
    .then(response => {
        if (response.ok) {
            return response.json(); 
        }
        throw new Error('Network response was not ok.');
    })
    .then(images => {
	console.log(images);
        /*images.forEach((imageData, index) => {
            const preview = document.querySelector("#preview" + (index + 1));
            const byteArray = new Uint8Array(imageData); // 서버에서 받은 이미지 데이터
            const blob = new Blob([byteArray], { type: 'image/png' }); // 또는 'image/png', 'image/gif' 등 적절한 타입 설정
            const url = URL.createObjectURL(blob); 
            const img = document.createElement('img');
            img.src = url; 
            img.style.width = "100%";
            img.style.height = "100%";
            img.onerror = () => {
                console.error('이미지를 로드할 수 없습니다: ' + url);
            };
            preview.innerHTML = ''; 
            preview.appendChild(img); 
        });*/
    })
    .catch(error => {
        alert('파일을 불러올 수 없습니다: ' + error.message);
    });
};



//btn_getImage
document.querySelector("#btn_deleteProduct").addEventListener("click", deleteProduct);

document.querySelectorAll("input[name='idx_product']").forEach(checkbox => {
    		checkbox.addEventListener('change', checkboxUpdate);
});
document.querySelector("#checkAll").addEventListener('click', function(){
	allCheck(this);
});