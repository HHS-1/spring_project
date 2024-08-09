const createRandomNumber = function(){
	let ranNumber = "";
	for(let a = 0 ; a < 7 ; a++){
		ranNumber += Math.ceil(Math.random()*9);	
	}
	document.querySelector("#product_code").value = ranNumber;
}

const checkProductCode = function(){
	const inputProductCode = document.querySelector("#product_code").value;
	fetch('/admin/product/codeCheck?code='+inputProductCode)
	.then(response=>{
		if(response.ok){
			alert('사용 가능한 상품코드입니다.');
		}else{
			alert('상품코드가 중복됩니다.');
		}
	})
	
}

const createProduct = function(){
	const accessToken = sessionStorage.getItem("accessToken");
	const productData = document.forms['frm_product'];
	const formData = new FormData(productData);
	for (let [key, value] of formData.entries()) {
        console.log(`${key}: ${value} : ${typeof(value)}`);
		
    }
	fetch('/admin/product/create', {
		method : "POST",
		headers : {
			'Authorization' : `Bearer ${accessToken}`
		},
		body : formData,
	})
	.then(response=>{
		console.log(response);
	})
	.catch(error=>{
		console.log(error);
	})
}


function setupImagePreview(inputId, previewId) {
    const imageInput = document.getElementById(inputId);
    const previewContainer = document.getElementById(previewId);
    const plus = document.querySelector('.plus');

	
	previewContainer.addEventListener("click",()=>{
		imageInput.click();
	});
	
    imageInput.addEventListener('change', function(event) {
        const files = event.target.files;
		const maxSize = 2 * 1024 * 1024;
		if(files[0].size > maxSize){
			alert('2MB 이하의 파일만 가능합니다.');
			return false;
		}
        previewContainer.innerHTML = '';

        if (files.length === 0) {
            previewContainer.style.border = '2px dashed rgba(0, 0, 0, 0.3)';
            previewContainer.append(plus);
        } else {
            Array.from(files).forEach(file => {
                if (file.type.startsWith('image/')) {
                    const reader = new FileReader();

                    reader.onload = function(e) {
                        const img = document.createElement('img');
                        img.src = e.target.result;
                        previewContainer.appendChild(img);
                        img.style.width = "200px";
                        img.style.height = "155px";
                        previewContainer.style.border = 'none';
                    }

                    reader.readAsDataURL(file);
                } else {
                    alert('이미지 형식의 파일만 로드가 가능합니다.');
                    previewContainer.append(plus);
                }
            });
        }
    });
}



document.querySelector("#btn_randomCode").addEventListener('click', createRandomNumber)
document.querySelector("#btn_codeCheck").addEventListener('click', checkProductCode);
document.querySelector("#btn_createProduct").addEventListener('click', createProduct);

setupImagePreview('product_image1', 'preview1');
setupImagePreview('product_image2', 'preview2');
setupImagePreview('product_image3', 'preview3');
