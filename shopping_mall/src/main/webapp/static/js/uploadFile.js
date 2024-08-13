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


setupImagePreview('product_image1', 'preview1');
setupImagePreview('product_image2', 'preview2');
setupImagePreview('product_image3', 'preview3');