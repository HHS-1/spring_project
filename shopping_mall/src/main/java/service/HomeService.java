package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.AdminEntity;
import model.AllSettingEntity;
import model.CategoryMenuEntity;
import model.ProductEntity;
import mybatis.AdminMapper;

@Service
public class HomeService {
	@Autowired
	private AdminMapper adminMapper;
	
	public List<AdminEntity> getAdminService() {
		return adminMapper.getAdminMapper();
	}
	public AllSettingEntity getShopSettingService(String id) {
		return adminMapper.getShopSettingMapper(id);
	}
	
	public List<CategoryMenuEntity> getCategoryMenuService(String id){
		return adminMapper.getCategoryMenuMapper(id);
	}
	
	public List<ProductEntity> getProductService(String id){
		return adminMapper.getProductMapper(id);
	}
	


}
