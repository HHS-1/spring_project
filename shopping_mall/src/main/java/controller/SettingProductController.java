package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.ProductDto;
import service.CommonService;
import service.SettingProductService;

@Controller
@ControllerAdvice
public class SettingProductController {

	@Autowired
	private SettingProductService settingProductService;
	@Autowired
	private CommonService commonService;
	
	@GetMapping("/admin/product/codeCheck")
	public ResponseEntity<String> checkCodeController(@RequestParam String code){
		return settingProductService.checkCodeService(code);
	}
	
	@PostMapping("/admin/product/create")
	@ResponseBody
	public ResponseEntity<String> createProductController(@ModelAttribute ProductDto productDto,
			@RequestHeader(value = "Authorization") String authorizationHeader) throws Exception{
		String user_id = commonService.authenticateUser(authorizationHeader);
		return settingProductService.createProductService(productDto, user_id);
	}
	
	@PostMapping("/admin/product/delete")
	public ResponseEntity<String> deleteProductController(@RequestBody List<String> product_code){
		return settingProductService.deleteProductService(product_code);
	}
	
	@GetMapping("/admin/product/getImage")
	@ResponseBody
	public ResponseEntity<List<String>> getProductImageController(@RequestParam String code){
		return settingProductService.getProductImageService(code);
	}
	
	@GetMapping("/admin/images/{filename}") // 파일 전달 api
	public ResponseEntity<Resource> serveFileController(@PathVariable String filename) {
       return settingProductService.serveFileService(filename);
    }
}
