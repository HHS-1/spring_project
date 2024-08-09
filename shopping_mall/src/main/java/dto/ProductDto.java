package dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	private String menu_code;
    private String product_code;
    private String product_name;
    private String product_info;
    private String product_price;
    private String product_discount_rate;
    private String product_discount_price;
    private String product_each;
    private String sale_usable;
    private String soldout_usable;
    private MultipartFile product_image1;
    private MultipartFile product_image2;
    private MultipartFile product_image3;
    private String product_detail;
}
