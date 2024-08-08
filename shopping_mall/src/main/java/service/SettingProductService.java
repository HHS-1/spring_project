package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dto.ProductDto;
import mybatis.AdminMapper;

@Service
public class SettingProductService {

	@Autowired
	private AdminMapper adminMapper;
	
	public ResponseEntity<String> createProductService(ProductDto productDto){
		try{
			adminMapper.createProductMapper(productDto);
			return ResponseEntity.ok("product 저장 성공");
		}catch(Exception e) {
			return ResponseEntity.status(438).body("product 저장 실패");
		}
	}
	
}
