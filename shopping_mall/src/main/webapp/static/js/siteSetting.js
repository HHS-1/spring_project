
function extractData(formId){
	const settingData = document.querySelectorAll(`#${formId} [name]`);
	const settingObjectData = {};
	settingData.forEach(element=>{
		 if (element.type === 'radio') {
            if (element.checked) {
                settingObjectData[element.name] = element.value;
            }
        } else {
            settingObjectData[element.name] = element.value;
        }
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
		alert('저장이 완료되었습니다.');
		location.reload();
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
		window.location.reload();
	})
	.catch(error => {
		console.log(error);
	})	
}

document.querySelector("#btn_setting_save").addEventListener("click",()=>{
	if(document.querySelector("#dataCheck").value == null || document.querySelector("#dataCheck").value == ""){
		insertSetting();
	}else{
		saveSetting();
	}
});