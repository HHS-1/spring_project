package model;

import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;

import dto.ProductDto;
import lombok.Getter;

@Getter
@Setter
public class ProductEntity {
	private int idx_product;
	private String menu_code;
	private String menu_sort;
    private String product_code;
    private String product_name;
    private String product_info;
    private String product_price;
    private String product_discount_rate;
    private String product_discount_price;
    private String product_each;
    private String sale_usable;
    private String soldout_usable;
    private String product_detail;
    private String in_date;
    
    public ProductEntity(ProductDto productDto) {
    	this.setMenu_code(productDto.getMenu_code());
    	this.setMenu_sort(productDto.getMenu_sort());
    	this.setProduct_code(productDto.getProduct_code());
    	this.setProduct_detail(productDto.getProduct_detail());
    	this.setProduct_discount_price(productDto.getProduct_discount_price());
    	this.setProduct_discount_rate(productDto.getProduct_discount_rate());
    	this.setProduct_each(productDto.getProduct_each());
    	this.setProduct_info(productDto.getProduct_info());
    	this.setProduct_name(productDto.getProduct_name());
    	this.setProduct_price(productDto.getProduct_price());
    	this.setSale_usable(productDto.getSale_usable());
    	this.setSoldout_usable(productDto.getSoldout_usable());
    	
    };
    
    
}
