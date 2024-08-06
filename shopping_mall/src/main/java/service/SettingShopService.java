package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dto.ShopSettingDto;
import model.SettingCompanyEntity;
import model.SettingPaymentEntity;
import model.SettingSiteEntity;
import mybatis.AdminMapper;

@Service
public class SettingShopService {

	@Autowired
	private AdminMapper adminMapper;
	
	
	
	public ResponseEntity<String> insertSettingService(ShopSettingDto shopSettingDto, String admin_id){
		SettingSiteEntity site = new SettingSiteEntity();
		site.setEntity(shopSettingDto.getSiteSettingData(), admin_id, site);
		
		SettingCompanyEntity company = new SettingCompanyEntity();
		company.setEntity(shopSettingDto.getCompanySettingData(), admin_id, company);
		
		SettingPaymentEntity payment = new SettingPaymentEntity();
		payment.setEntity(shopSettingDto.getPaymentSettingData(), admin_id, payment);
		
		try {
			adminMapper.insertSiteSettingMapper(site);
			adminMapper.insertCompanySettingMapper(company);
			adminMapper.insertPaymentSettingMapper(payment);	
		}catch(Exception e) {
			System.out.println(e);
			return ResponseEntity.status(435).body("세팅 실패 DB 오류");
		}
		return ResponseEntity.ok("세팅 저장 성공");
	}
}
