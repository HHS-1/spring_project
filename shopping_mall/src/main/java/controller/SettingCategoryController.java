package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.CategoryDto;
import service.SettingCategoryService;

@Controller
public class SettingCategoryController {
	
	@Autowired
	private SettingCategoryService settingCategoryService;
	
	@PostMapping("/admin/category/create")
	public ResponseEntity<String> createCategory(@RequestBody CategoryDto categoryDto) {
		return settingCategoryService.createCategoryService(categoryDto);
	}
	
	@GetMapping("/admin/category/get")
	@ResponseBody
	public List<CategoryDto> getCategory(){
		return settingCategoryService.getCategoryService();
	}
	
	@PostMapping("/admin/category/delete")
	public ResponseEntity<String> delteCategory(@RequestBody List<String> idx_category){
		return settingCategoryService.deleteCategoryService(idx_category);
	}
	
}
