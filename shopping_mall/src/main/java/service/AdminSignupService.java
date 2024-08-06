package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dto.AdminSignupDto;
import model.AdminEntity;
import mybatis.AdminMapper;

@Service
public class AdminSignupService {
	
	@Autowired
	private AdminMapper adminMapper;
	private PasswordEncoder passwordEncoder;
	
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
		AdminEntity adminEntity = new AdminEntity();
		this.passwordEncoder = new BCryptPasswordEncoder();
		
        adminEntity.setAdmin_id(adminSignupDto.getAdmin_id());
        adminEntity.setAdmin_pw(passwordEncoder.encode(adminSignupDto.getAdmin_pw()));
        adminEntity.setAdmin_name(adminSignupDto.getAdmin_name());
        adminEntity.setAdmin_email(adminSignupDto.getAdmin_email());
        adminEntity.setAdmin_tel(adminSignupDto.getAdmin_tel());
        adminEntity.setAdmin_part(adminSignupDto.getAdmin_part());
        adminEntity.setAdmin_position(adminSignupDto.getAdmin_position());
		
        try{
        	adminMapper.createAdminMapper(adminEntity);
        	return ResponseEntity.ok("회원가입 성공");
        }catch(Exception e) {
        	System.out.println(e);
        	return ResponseEntity.status(431).body("회원가입 실패");
        }

	}
}
