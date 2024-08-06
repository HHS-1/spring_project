
function extractData(formId){
	const settingData = document.querySelectorAll(`#${formId} [name]`);
	const settingObjectData = {};
	settingData.forEach(element=>{
		settingObjectData[element.name] = element.value;
	});
	return settingObjectData;
}



const insertSetting = function(){
	const accessToken = sessionStorage.getItem("accessToken");
	fetch("./shop/insert",{
		method : "POST",
		headers : {
			'Authorization': `Bearer ${accessToken}`,
			"Content-Type" : "application/json",
			
		},
		body: JSON.stringify({
		    siteSettingData: extractData("frm1"),
		    companySettingData: extractData("frm2"),
		    paymentSettingData: extractData("frm3")
		}),

	})
	.then(response =>{
		console.log(response);
	})
	.catch(error => {
		console.log(error);
	})	
}

const saveSetting = function(){
	const accessToken = sessionStorage.getItem("accessToken");
	fetch("./shop/save",{
		method : "POST",
		headers : {
			'Authorization': `Bearer ${accessToken}`,
			"Content-Type" : "application/json",
		},
		body: JSON.stringify({
		    siteSettingData: extractData("frm1"),
		    companySettingData: extractData("frm2"),
		    paymentSettingData: extractData("frm3")
		}),
	})
	.then(response =>{
		console.log(response);
	})
	.catch(error => {
		console.log(error);
	})	
}
document.querySelector("#btn_setting_save").addEventListener("click",insertSetting);