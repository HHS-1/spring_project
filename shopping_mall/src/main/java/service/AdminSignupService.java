package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dto.AdminSignupDto;
import model.Admin;
import mybatis.AdminMapper;

@Service
public class AdminSignupService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	//아이디 중복검사 Service
	public ResponseEntity<String> adminIdCheckService(String id){
		if(adminMapper.adminIdCheckMapper(id) > 0) {
			return ResponseEntity.status(430).body("아이디 중복");
		}else {
			return ResponseEntity.ok("사용가능한 아이디");
		}
	}
	
	//회원가입 Service
	public ResponseEntity<String> createAdminService(AdminSignupDto adminSignupDto){
		Admin admin = new Admin();
        admin.setAdmin_id(adminSignupDto.getAdmin_id());
        admin.setAdmin_pw(adminSignupDto.getAdmin_pw());
        admin.setAdmin_name(adminSignupDto.getAdmin_name());
        admin.setAdmin_email(adminSignupDto.getAdmin_email());
        admin.setAdmin_tel(adminSignupDto.getAdmin_tel());
        admin.setAdmin_part(adminSignupDto.getAdmin_part());
        admin.setAdmin_position(adminSignupDto.getAdmin_position());
		
        System.out.println(adminMapper.createAdminMapper(admin));
		return null;
	}
}
