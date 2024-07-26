$(()=>{
	const basket = [
		{
			"seq" : 1,
			"product" : "냉장고",
			"price" : "195000"
		},
		{
			"seq" : 2,
			"product" : "세탁기",
			"price" : "287000"
		},
		{
			"seq" : 3,
			"product" : "에어프라이어",
			"price" : "97000"
		}				
	];
	
	
	const arr = [
			["10%","20%","30%"],
			["30","40","50"],
		];
	
	//Front 배열값 응용편
	$("#btn3").click(function(){
		$.ajax({
			url : "./ajaxok3.do",
			method : "POST",
			dataType : "text",
			contentType : "application/json",
			data : JSON.stringify(basket),
			success : (function(result){
				console.log(result);
			}),
			error : function(error){
				console.log(error)
			}
			
		});
		
	});
	
	
	$("#btn2").click(function(){
		var data = new Array();
		data.push("홍길동");
		data.push("강감찬");
		data.push("이순신");
		var data2 = new Array();
		data2.push("하현수1");
		data2.push("하현수2");
		data2.push("하현수3");
		$.ajax({
			url : "./ajaxok2.do",
			method : "POST",
			cache : false,
			dataType : "JSON",
			contentType : "application/json",
			data : JSON.stringify({
				"all_data" : data,
				"ha" : data2,
			}),
			success : (function(result){
				console.log(result);
			}),
			error : function(error){
				console.log(error)
			}
			
		})
	})
	
	
	$("#btn").click(function(){
		const data = new Array();
		data.push("20");
		data.push("30");
		data.push("40");
		console.log(JSON.stringify({
				"alldata" : data,
			}))
		$.ajax({
			url : "./ajaxok.do",
			method : "POST",
			cache : false,
			dataType : "JSON",
			contentType : "application/json",
			data : JSON.stringify({
				"alldata" : data,
			}),
			success:function(result){
				console.log(result)
			},
			error : function(error){
				console.log(error)
			}

		});
	});
});