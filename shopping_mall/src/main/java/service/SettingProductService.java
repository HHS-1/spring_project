package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

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

	public ResponseEntity<String> checkCodeService(String code) {
		try {
			adminMapper.checkCodeMapper(code);
			return ResponseEntity.status(439).body("상품코드 중복");
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.ok("중복 안 됨");
		}
	}

	public ResponseEntity<String> createProductService(ProductDto productDto, String user_id) {
		try {
			ProductEntity ProductEntity = new ProductEntity(productDto, user_id);
			ProductFileEntity productFileEntity = new ProductFileEntity(productDto, filePath);
			adminMapper.createProductMapper(ProductEntity);
			adminMapper.saveProductImageMapper(productFileEntity);
			return ResponseEntity.ok("product 저장 성공");

		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(438).body("product 저장 실패");
		}
	}

	public ResponseEntity<String> deleteProductService(List<String> product_code) {
		try {

			// FileUtility.deleteFile(adminMapper.getProductFilePath(product_code));
			if (FileUtility.deleteFile(adminMapper.getProductFilePath(product_code))) {
				if (adminMapper.deleteProductImageMapper(product_code) > 0) {
					adminMapper.deleteProductMapper(product_code);
					return ResponseEntity.ok("상품 삭제 성공");
				}
			} else {
				return ResponseEntity.status(440).body("파일 삭제 오류(서버)");
			}

		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(441).body("상품 삭제 실패");
		}
		return null;
	}

	public ResponseEntity<List<String>> getProductImageService(String product_code) {
		return ResponseEntity.ok(adminMapper.getProductImageMapper(product_code));
	}
	
	public ResponseEntity<Resource> serveFileService(String fileName){
		try {
			final Path rootLocation = Paths.get(filePath);
			Path file = rootLocation.resolve(fileName);
			Resource resource = new UrlResource(file.toUri());
			return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
		}catch(Exception e) {
			
		}
		
		return null;
	}
}
