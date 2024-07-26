package com.shopping.mall;

import java.io.PrintWriter;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class webController {

	PrintWriter pw = null;

	@PostMapping("/ajaxok3.do")
	@ResponseBody
	public String ajaxok3(@RequestBody List<BasketDto> data) {		
		System.out.println(data);
		return "ok";
	}
	
	/*public String ajaxok3(@RequestBody String arr) {
		JSONArray ja1 = new JSONArray(arr);
		JSONArray ja2 = new JSONArray(ja1.get(0));
		JSONArray ja3 = new JSONArray(ja1.get(1));
		System.out.println(ja2.get(0));
		System.out.println(ja3.get(0));
		return "ok";
	}*/
	
	
	@PostMapping("/ajaxok2.do")
	@CrossOrigin(origins = "*", allowedHeaders= "*")
	public String ajaxok2(@RequestBody all_data_dto all_data) {
		 System.out.println(all_data.getAll_data());
		 System.out.println(all_data.getHa());
		 return null;
	}
	
	
	
	@PostMapping("/ajaxok.do")
	@ResponseBody
	@CrossOrigin(origins = "*", allowedHeaders= "*")
	public String ajaxok(@RequestBody String alldata) {
		JSONObject ja = new JSONObject(alldata);
		JSONArray data = ja.getJSONArray("alldata");
		System.out.println(data.get(1));

		return null;
	}
	
}
