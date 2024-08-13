package model;

import dto.CategoryDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryEntity {
	int idx_category;
	String admin_id, sort_code, menu_code, menu_name,category_usable;
	
	public CategoryEntity(CategoryDto categoryDto, String user_id){
		this.setAdmin_id(user_id);
		this.setSort_code(categoryDto.getSort_code());
		this.setMenu_code(categoryDto.getMenu_code());
		this.setMenu_name(categoryDto.getMenu_name());
		this.setCategory_usable(categoryDto.getCategory_usable());
		
	}

}
