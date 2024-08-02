package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dto.ShopSettingDto;

@Controller
public class SettingShopController {
	
	@PostMapping("/admin/setting/shop/save")
	public ResponseEntity<String> saveSetting(@RequestBody ShopSettingDto shopSettingDto){
		System.out.println(shopSettingDto.getCompanySettingData());
		return null;
	}
}
