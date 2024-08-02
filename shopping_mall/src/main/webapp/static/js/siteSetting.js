function extractData(formId){
	const settingData = document.querySelectorAll(`#${formId} [name]`);
	const settingObjectData = {};
	settingData.forEach(element=>{
		settingObjectData[element.name] = element.value;
	});
	return settingObjectData;
}

const saveSetting = function(){
	fetch("./shop/save",{
		method : "POST",
		headers : {
			"Content-Type" : "application-json",
		},
		body : JSON.stringify([
			extractData("frm1"), extractData("frm2"), extractData("frm3")
		]),	
	})
	.then(response =>{
		console.log(response);
	})
	.catch(error => {
		console.log(error);
	})	
}

document.querySelector("#btn_setting_save").addEventListener("click",saveSetting);