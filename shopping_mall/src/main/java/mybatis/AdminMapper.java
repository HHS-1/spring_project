package mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import dto.AdminPermissionDto;
import dto.CategoryDto;
import dto.ProductDto;
import model.AdminAuthentication;
import model.AdminEntity;
import model.AllSettingEntity;
import model.CategoryMenuEntity;
import model.ProductFileEntity;
import model.SettingCompanyEntity;
import model.SettingPaymentEntity;
import model.SettingSiteEntity;
import model.ProductEntity;

@Mapper
public interface AdminMapper {
	int adminIdCheckMapper(String id);
	int createAdminMapper(AdminEntity adminEntity);
	List<AdminEntity> getAdminMapper();
	Map<String,String> adminLoginMapper(String id);
	AdminAuthentication getAdminDetail(String id);
	String getAdminNameMapper(String id);
	int modifyPermissionMapper(AdminPermissionDto adminPermissionDto);
	int insertSiteSettingMapper(SettingSiteEntity settingSiteEntity);
	int insertCompanySettingMapper(SettingCompanyEntity settingCompanyEntity);
	int insertPaymentSettingMapper(SettingPaymentEntity settingPaymentEntity);
	AllSettingEntity getShopSettingMapper(String id);
	int saveSiteSettingMapper(SettingSiteEntity settingSiteEntity);
	int saveCompanySettingMapper(SettingCompanyEntity settingCompanyEntity);
	int savePaymentSettingMapper(SettingPaymentEntity settingPaymentEntity);
	
	int createCategoryMapper(CategoryDto categoryDto);
	List<CategoryDto> getCategoryMapper();
	int deleteCategoryMapper(List<String> idx_category);
	List<CategoryMenuEntity> getCategoryMenuMapper();
	int checkCodeMapper(String code);
	
	
	int createProductMapper(ProductEntity ProductEntity);
	int saveProductImageMapper(ProductFileEntity productFileEntity);
	
	List<ProductEntity> getProductMapper();
	List<Map<String, String>> getProductFilePath(List<String> product_code);
	int deleteProductMapper(List<String> product_code);
	
}
