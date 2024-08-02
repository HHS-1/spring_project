package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingShopController {
	
	@PostMapping("/admin/setting/shop/save")
	public ResponseEntity<String> saveSetting(){
		System.out.println("test11");
		return null;
	}
}
