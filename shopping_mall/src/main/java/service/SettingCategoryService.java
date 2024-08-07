package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dto.CategoryDto;
import mybatis.AdminMapper;

@Service
public class SettingCategoryService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	public ResponseEntity<String> createCategoryService(CategoryDto categoryDto) {
		try {
			adminMapper.createCategoryMapper(categoryDto);
			return ResponseEntity.ok("카테고리 저장 완료");
		
		}catch(Exception e) {
			return ResponseEntity.status(436).body("데이터 형식 불일치");
		}
	}
	
	public List<CategoryDto> getCategoryService(){
		return adminMapper.getCategoryMapper();
	}
}
