package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import dto.ProductDto;
import service.SettingProductService;

@Controller
public class SettingProductController {

	@Autowired
	private SettingProductService settingProductService;
	public ResponseEntity<String> createProductController(@RequestBody ProductDto productDto){
		return settingProductService.createProductService(productDto);
	}
}
