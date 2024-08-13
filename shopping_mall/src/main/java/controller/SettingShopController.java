package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import dto.ShopSettingDto;
import service.CommonService;
import service.SettingShopService;

@Controller
public class SettingShopController {
	@Autowired
	private SettingShopService settingShopService;
	@Autowired
	private CommonService commonService;
	
	
	
	@PostMapping("/admin/setting/shop/insert")
	public ResponseEntity<String> insertSetting(@RequestBody ShopSettingDto shopSettingDto, 
			@RequestHeader(value = "Authorization") String authorizationHeader) throws Exception{
		String admin_id = commonService.authenticateUser(authorizationHeader);
		return settingShopService.insertSettingService(shopSettingDto, admin_id);
	}
	
	@PostMapping("/admin/setting/shop/save")
	public ResponseEntity<String> saveSetting(@RequestBody ShopSettingDto shopSettingDto,
			@RequestHeader(value = "Authorization") String authorizationHeader) throws Exception{
		String admin_id = commonService.authenticateUser(authorizationHeader);
		return settingShopService.saveSettingService(shopSettingDto, admin_id);
	}
}
