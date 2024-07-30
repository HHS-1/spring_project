package service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dto.AdminLoginDto;
import io.jsonwebtoken.Jwts;
import model.Admin;
import mybatis.AdminMapper;

@Service
public class AdminLoginService {

	@Autowired
	private AdminMapper adminMapper;
	private PasswordEncoder passwordEncoder;

	// admin 로그인 Service;
	public ResponseEntity<String> adminLoginService(AdminLoginDto loginInfo) {
		passwordEncoder = new BCryptPasswordEncoder();
		Map<String, String> savedInfo = adminMapper.adminLoginMapper(loginInfo.getAdmin_id());

		String permission = savedInfo.get("permission");
		String saved_pw = savedInfo.get("admin_pw");
		String login_pw = loginInfo.getAdmin_pw();
		
		if(saved_pw == null) {
			return ResponseEntity.status(432).body("아이디 없음");
		}else if(permission.equals("N")) {
			return ResponseEntity.status(433).body("관리자 미승인");
		}else if(!passwordEncoder.matches(login_pw, saved_pw)) { 
			return ResponseEntity.status(434).body("비밀번호 틀림"); 
		}else {
			return ResponseEntity.ok("로그인 성공"); 
		}
		
	}
}
