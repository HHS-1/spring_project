package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dto.ProductDto;
import model.ProductEntity;
import model.ProductFileEntity;
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
			ProductEntity ProductEntity = new ProductEntity(productDto);
			ProductFileEntity productFileEntity = new ProductFileEntity(productDto, filePath);
			adminMapper.createProductMapper(ProductEntity);
			adminMapper.saveProductImageMapper(productFileEntity);
			return ResponseEntity.ok("product 저장 성공");

		}catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(438).body("product 저장 실패");
		}
	}
	
	public ResponseEntity<String> deleteProductService(List<String> product_code){
		try {
			
			//FileUtility.deleteFile(adminMapper.getProductFilePath(product_code));
			FileUtility.deleteFile(adminMapper.getProductFilePath(product_code));
			//adminMapper.deleteProductMapper(idx_product);
			//return ResponseEntity.ok("상품 삭제 성공");
			return null;
		}catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(440).body("상품 삭제 실패");
		}
	}
	
}
