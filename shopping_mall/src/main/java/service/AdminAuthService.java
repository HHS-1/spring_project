package service;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dto.AdminLoginDto;
import jwt.JwtUtil;
import mybatis.AdminMapper;
import utility.CookieUtil;

@Service
public class AdminAuthService {

	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private JwtUtil jwtUtil; 
	
	private PasswordEncoder passwordEncoder;

	// admin 로그인 Service;
	public ResponseEntity<String> adminLoginService(AdminLoginDto loginInfo, HttpServletResponse res) {
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
			
			String accessToken = jwtUtil.createAccessToken(loginInfo.getAdmin_id(), permission);
			String refreshToken = jwtUtil.createRefreshToken(loginInfo.getAdmin_id(), permission);
			
			//HttpOnly 쿠키에 refreshToken 저장
			Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
			refreshTokenCookie.setHttpOnly(true);
			refreshTokenCookie.setPath("/");
		    refreshTokenCookie.setMaxAge(1 * 24 * 60 * 60); 
		    res.addCookie(refreshTokenCookie);
		    
		    
		   
			return ResponseEntity.ok(accessToken); 
		}
	}
	
	//admin 로그아웃 service
	public String adminLogoutService(HttpServletResponse res, HttpServletRequest req){
		CookieUtil.deleteCookie(res, "refreshToken", "/");
		req.getSession().invalidate();
		
		res.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0"); // 캐시 방지
	    res.setHeader("Pragma", "no-cache"); // HTTP 1.0
	    res.setDateHeader("Expires", 0);
		
		return "redirect:/admin/login";
	}
}
