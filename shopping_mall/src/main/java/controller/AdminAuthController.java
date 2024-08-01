package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dto.AdminLoginDto;
import service.AdminAuthService;

@Controller
public class AdminAuthController {
	@Autowired
	AdminAuthService authService;
	
	@PostMapping("/admin/login/api")
	public ResponseEntity<String> adminLogin(@RequestBody AdminLoginDto loginInfo, HttpServletResponse res) {
		return authService.adminLoginService(loginInfo, res);
	}
	
	@GetMapping("/admin/logout/api")
	public String adminLogout(HttpServletResponse res, HttpServletRequest req){
		return authService.adminLogoutService(res, req);
	}
}
