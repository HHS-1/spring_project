package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.CategoryDto;
import service.CommonService;
import service.SettingCategoryService;

@Controller
public class SettingCategoryController {
	
	@Autowired
	private SettingCategoryService settingCategoryService;
	@Autowired
	private CommonService commonService;
	
	@PostMapping("/admin/category/create")
	public ResponseEntity<String> createCategory(@RequestBody CategoryDto categoryDto,
			@RequestHeader(value = "Authorization") String authorizationHeader) throws Exception {
		String user_id = commonService.authenticateUser(authorizationHeader);
		return settingCategoryService.createCategoryService(categoryDto, user_id);
	}
	
	@GetMapping("/admin/category/get")
	@ResponseBody
	public List<CategoryDto> getCategory(@RequestHeader(value = "Authorization") String authorizationHeader, String page, Model model) throws Exception{
		String user_id = commonService.authenticateUser(authorizationHeader);
		return settingCategoryService.getCategoryService(user_id, page);
	}
	
	@PostMapping("/admin/category/delete")
	public ResponseEntity<String> delteCategory(@RequestBody List<String> idx_category) throws Exception{
		return settingCategoryService.deleteCategoryService(idx_category);
	}
	
}
