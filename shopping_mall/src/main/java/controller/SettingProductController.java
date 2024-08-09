package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dto.ProductDto;
import service.SettingProductService;

@Controller
@ControllerAdvice
public class SettingProductController {

	@Autowired
	private SettingProductService settingProductService;
	
	@GetMapping("/admin/product/codeCheck")
	public ResponseEntity<String> checkCodeController(@RequestParam String code){
		return settingProductService.checkCodeService(code);
	}
	
	@PostMapping("/admin/product/create")
	@ResponseBody
	public ResponseEntity<String> createProductController(@ModelAttribute ProductDto productDto){

		return settingProductService.createProductService(productDto);
	}
}
