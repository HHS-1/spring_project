var codeCheckFlag;

const createRandomNumber = function(){
	let ranNumber = "";
	for(let a = 0 ; a < 7 ; a++){
		ranNumber += Math.ceil(Math.random()*9);	
	}
	document.querySelector("#product_code").value = ranNumber;
}

const checkProductCode = function(){
	codeCheckFlag = false;
	const inputProductCode = document.querySelector("#product_code").value;
	fetch('/admin/product/codeCheck?code='+inputProductCode)
	.then(response=>{
		if(response.ok){
			codeCheckFlag = true;
			alert('사용 가능한 상품코드입니다.');
		}else{
			codeCheckFlag = false;
			alert('상품코드가 중복됩니다.');
		}
	})
	
}

function calculateDiscount() {
    const price = document.querySelector('input[name="product_price"]').value;
    const discountRate = document.querySelector('input[name="product_discount_rate"]').value;
    const discountPriceInput = document.querySelector('input[name="product_discount_price"]');

    if (isNaN(price) || price < 0) {
        discountPriceInput.value = "0";
        return;
    }
    if (isNaN(discountRate) || discountRate < 0) {
        discountPriceInput.value = "0";
        return;
    }

    const discountPrice = (price * discountRate) / 100;

    discountPriceInput.value = discountPrice;
}

const createProduct = function(){
	const accessToken = sessionStorage.getItem("accessToken");
	const productData = document.forms['frm_product'];
	const formData = new FormData(productData);
	let fileCheckFlag = false;
	
	
	if(!formData.get("menu_sort")){
		alert('대메뉴 카테고리를 선택해주세요');
		return false;
	}else if(!formData.get("product_code")){
		alert('상품 코드를 입력해주세요');
		return false;
	}else if(isNaN(formData.get("product_code"))){
		alert('상품 코드는 숫자만 입력 가능합니다');
		return false;
	}else if(!codeCheckFlag){
		alert('상품 코드 중복체크를 해주세요');
		return false;
	}else if(!formData.get("product_info")){
		alert('상품 부가설명을 입력해주세요');
		return false;
	}else if(!formData.get("product_price")){
		alert('판매가격을 입력해주세요');
		return false;
	}else if(isNaN(formData.get("product_price"))){
		alert('판매가격은 숫자만 입력 가능합니다');
		return false;
	}else if(!formData.get("product_discount_rate")){
		alert("할인율을 설정해주세요")
		return false;
	}else if(isNaN(formData.get("product_discount_rate"))){
		alert('할인율은 숫자만 입력 가능합니다');
		return false;
	}else if(!formData.get("product_each")){
		alert('재고를 입력해주세요')
		return false;
	}else if(isNaN(formData.get("product_each"))){
		alert('재고는 숫자만 입력 가능합니다');
		return false;
	}
	
	for(let a = 1 ; a <= 3 ; a++){ //첨부파일 1개 이상 체크
		if(document.querySelector("#product_image"+a).value != ""){
			fileCheckFlag = true;
			break;
		}		
	}
	if(!fileCheckFlag){
		alert('상품 이미지는 한 개 이상 첨부하셔야합니다.');
		return false;
	}
	
	formData.append("menu_code",formData.get("menu_sort").split('.')[0]);
	
	fetch('/admin/product/create', {
		method : "POST",
		headers : {
			'Authorization' : `Bearer ${accessToken}`
		},
		body : formData,
	})
	.then(response=>{
		alert('상품등록이 완료되었습니다.');
		location.href="/admin/product";
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
		
		previewContainer.innerHTML = '';
		
		if(files.length != 0 && files[0].size > maxSize){
			alert('2MB 이하의 파일만 가능합니다.');
			return false;
		}

        if (files.length === 0) {
			console.log("test22")
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
