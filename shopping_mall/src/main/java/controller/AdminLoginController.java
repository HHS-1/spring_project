package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dto.AdminLoginDto;
import service.AdminLoginService;

@Controller
public class AdminLoginController {
	@Autowired
	AdminLoginService loginService;
	
	@PostMapping("/admin/login/api")
	public ResponseEntity<?> adminLogin(@RequestBody AdminLoginDto loginInfo) {
		return loginService.adminLoginService(loginInfo);
	}
}
