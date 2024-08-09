package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dto.AdminSignupDto;
import service.AdminSignupService;

@Controller
public class AdminSignupController {
	
	@Autowired
	private AdminSignupService adminSignupService;
	
	//아이디 중복검사 컨트롤러
	@GetMapping("/admin/idCheck")
	public ResponseEntity<String> adminIdCheck(String id){
		return adminSignupService.adminIdCheckService(id);
	}
	
	//Admin 회원가입 컨트롤러
	@PostMapping("/admin/signup/api")
	public ResponseEntity<String> createAdmin(@RequestBody AdminSignupDto adminSignupDto){
		return adminSignupService.createAdminService(adminSignupDto);
	}
}
