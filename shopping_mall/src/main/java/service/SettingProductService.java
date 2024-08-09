package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dto.ProductDto;
import model.ProductFileEntity;
import model.productEntity;
import mybatis.AdminMapper;
import utility.FileUtility;

@Service
public class SettingProductService {

	@Autowired
	private AdminMapper adminMapper;
	
	@Value("${imageUpload.path}")
	private String filePath;
	
	public ResponseEntity<String> checkCodeService(String code){
		try {
			adminMapper.checkCodeMapper(code);
			return ResponseEntity.status(439).body("상품코드 중복");
		}catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.ok("중복 안 됨");
		}
	}
	
	public ResponseEntity<String> createProductService(ProductDto productDto){
		try{
			productEntity productEntity = new productEntity(productDto);
			ProductFileEntity productFileEntity = new ProductFileEntity(productDto, filePath);
			adminMapper.createProductMapper(productEntity);
			adminMapper.saveProductImageMapper(productFileEntity);
			return ResponseEntity.ok("product 저장 성공");

		}catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(438).body("product 저장 실패");
		}
	}
	
}
