package mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import dto.AdminPermissionDto;
import dto.CategoryDto;
import dto.ProductDto;
import model.AdminAuthentication;
import model.AdminEntity;
import model.AllSettingEntity;
import model.CategoryEntity;
import model.CategoryMenuEntity;
import model.PagingEntity;
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
	
	int createCategoryMapper(CategoryEntity categoryEntity);
	List<CategoryDto> getCategoryMapper(PagingEntity pagingEntity);
	int deleteCategoryMapper(List<String> idx_category);
	List<CategoryMenuEntity> getCategoryMenuMapper(String id);
	int checkCodeMapper(String code);
	
	
	int createProductMapper(ProductEntity ProductEntity);
	int saveProductImageMapper(ProductFileEntity productFileEntity);
	
	List<ProductEntity> getProductMapper(String id);
	List<Map<String, String>> getProductFilePath(List<String> product_code);
	List<String> getProductImageMapper(String product_code);
	
	int deleteProductImageMapper(List<String> product_code);
	int deleteProductMapper(List<String> product_code);
	
	int getCategoryCountMapper(@Param("id") String id, @Param("search") String search);
}
