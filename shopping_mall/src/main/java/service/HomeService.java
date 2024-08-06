package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.AdminEntity;
import model.AllSettingEntity;
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
	
}
