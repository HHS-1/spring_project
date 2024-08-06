package mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import dto.AdminPermissionDto;
import model.AdminAuthentication;
import model.AdminEntity;
import model.AllSettingEntity;
import model.SettingCompanyEntity;
import model.SettingPaymentEntity;
import model.SettingSiteEntity;

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
}
