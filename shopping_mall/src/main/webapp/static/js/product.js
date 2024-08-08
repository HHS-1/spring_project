document.querySelector("#btn_randomCode").addEventListener('click',()=>{
	let ranNumber = "";
	for(let a = 0 ; a < 7 ; a++){
		ranNumber += Math.ceil(Math.random()*9);	
	}
	document.querySelector("#product_code").value = ranNumber;
})

const extractData = function(){
	const productData = document.querySelectorAll("#product_insert [name]");
	const productObjectData = {};
	productData.forEach(element=>{
		 if (element.type === 'radio') {
            if (element.checked) {
                productObjectData[element.name] = element.value;
            }
        } else {
            productObjectData[element.name] = element.value;
        }
	});
	return productObjectData;
}

const createProduct = function(){
	fetch('/admin/product/create', {
		method : "POST",
		headers : {
			'Authorization' : `Bearer ${accessToken}`,
			"Content-Type" : "application/json",
		},
		body : JSON.stringify(extractData()),
	})
	.then(response=>{
		console.log(response);
	})
	.catch(error=>{
		console.log(error);
	})
}

document.getElementById('product_image1').addEventListener('change', function(event) {
            const files = event.target.files;
            const previewContainer = document.getElementById('priview');
            
            // 미리보기 컨테이너 비우기
            previewContainer.innerHTML = '';

            Array.from(files).forEach(file => {
                if (file.type.startsWith('image/')) {
                    const reader = new FileReader();

                    reader.onload = function(e) {
                        const img = document.createElement('img');
                        img.src = e.target.result;
                        previewContainer.appendChild(img);
						img.style.width = "200px";
						img.style.height = "155px";
						img.style.objectFit = cover;
                    }

                    reader.readAsDataURL(file);
                } else {
                    alert('Please upload image files only.');
                }
            });
        });