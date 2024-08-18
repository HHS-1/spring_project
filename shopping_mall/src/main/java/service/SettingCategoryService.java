package service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dto.CategoryDto;
import model.CategoryEntity;
import model.PagingEntity;
import mybatis.AdminMapper;

@Service
public class SettingCategoryService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	public ResponseEntity<String> createCategoryService(CategoryDto categoryDto, String user_id) {
		try {
			CategoryEntity categoryEntity = new CategoryEntity(categoryDto, user_id);
			adminMapper.createCategoryMapper(categoryEntity);
			return ResponseEntity.ok("카테고리 저장 완료");
		
		}catch(Exception e) {
			return ResponseEntity.status(436).body("카테고리 저장 실패");
		}
	}
	
	public ResponseEntity<Integer> getCategoryCountService(String user_id, String search) {
		return ResponseEntity.ok(adminMapper.getCategoryCountMapper(user_id, search));
	}
	
	public List<CategoryDto> getCategoryService(String user_id, String page, String search){
		int firstIndex = ((Integer.valueOf(page))-1)*5;
		final int pagingNumber = 5;
		PagingEntity pagingEntity = new PagingEntity(user_id, firstIndex, pagingNumber, search);
		return adminMapper.getCategoryMapper(pagingEntity);
	}
	
	public ResponseEntity<String> deleteCategoryService(List<String> idx_category) throws SQLIntegrityConstraintViolationException{
		 try{
			 adminMapper.deleteCategoryMapper(idx_category);
			 return ResponseEntity.ok("카테고리 삭제 성공");
		 }catch(Exception e) {
			 return ResponseEntity.status(437).body("카테고리가 등록된 상품이 있음");
		 }
	}
}
