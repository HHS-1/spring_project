document.querySelector("#btn_randomCode").addEventListener('click',()=>{
	let ranNumber = "";
	for(let a = 0 ; a < 7 ; a++){
		ranNumber += Math.ceil(Math.random()*9);	
	}
	document.querySelector("#product_code").value = ranNumber;
})