package dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {
	int idx_product, product_price, product_discount_rate, product_discount_price,product_each;
	String menu_code, product_code, product_name, product_info, sale_usable, soldout_usable, 
	product_image1, product_image2, product_image3, product_detail;
}
