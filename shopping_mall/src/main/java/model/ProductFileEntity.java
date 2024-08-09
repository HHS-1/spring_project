package model;

import org.springframework.beans.factory.annotation.Value;

import dto.ProductDto;
import lombok.Getter;
import lombok.Setter;
import utility.FileUtility;

@Getter
@Setter
public class ProductFileEntity {

	String product_code, product_image1, product_image2, product_image3, product_image1_name, product_image2_name, product_image3_name;
	
	public ProductFileEntity(ProductDto productDto, String filePath) {
		this.setProduct_code(productDto.getProduct_code());
		this.setProduct_image1(FileUtility.saveFile(productDto.getProduct_image1(), filePath));
		this.setProduct_image1_name(productDto.getProduct_image1().getOriginalFilename());
		this.setProduct_image2(FileUtility.saveFile(productDto.getProduct_image2(), filePath));
		this.setProduct_image2_name(productDto.getProduct_image2().getOriginalFilename());
		this.setProduct_image3(FileUtility.saveFile(productDto.getProduct_image3(), filePath));
		this.setProduct_image3_name(productDto.getProduct_image3().getOriginalFilename());
	}
}
