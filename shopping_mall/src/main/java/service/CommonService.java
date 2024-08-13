package service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import jwt.JwtUtil;
import mybatis.AdminMapper;
import utility.CookieUtil;

@Service
public class CommonService {

	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private JwtUtil jwtUtil;
	
	public String getAdminNameService(String id) {
		return adminMapper.getAdminNameMapper(id);
	}
	
	public String verifyMaster(HttpServletRequest req, Model model, String path) {
		String refreshToken = CookieUtil.getCookie(req, "refreshToken");
    	if(refreshToken == null || refreshToken.isEmpty() ||jwtUtil.isTokenExpired(refreshToken)) {
			return "redirect:/admin/login";
		}else if(!jwtUtil.getPermission(refreshToken).equals("M")) {
			return "403";
		}
    	String id = jwtUtil.getId(refreshToken);
    	String permission = jwtUtil.getPermission(refreshToken);
    	String name = this.getAdminNameService(id);
    	
    	model.addAttribute("userId",id);
    	model.addAttribute("userName", name);
    	model.addAttribute("permission",permission);
    	
    	return path;
	}
	
	public String verify(HttpServletRequest req, Model model, String path) {
		String refreshToken = CookieUtil.getCookie(req, "refreshToken");
		
    	if(refreshToken == null || refreshToken.isEmpty() ||jwtUtil.isTokenExpired(refreshToken)) {
			return "redirect:/admin/login";
		}else if(jwtUtil.getPermission(refreshToken).equals("N")) {
			return "403";
		}
    	String id = jwtUtil.getId(refreshToken);
    	String permission = jwtUtil.getPermission(refreshToken);
    	String name = this.getAdminNameService(id);
    	
    	model.addAttribute("userId",id);
    	model.addAttribute("userName", name);
    	model.addAttribute("permission",permission);
    	
    	return path;
	}
	
	
	public String verify(HttpServletRequest req, Model model) {
		String refreshToken = CookieUtil.getCookie(req, "refreshToken");
		
    	if(refreshToken == null || refreshToken.isEmpty() ||jwtUtil.isTokenExpired(refreshToken)) {
			return "redirect:/admin/login";
		}else if(jwtUtil.getPermission(refreshToken).equals("N")) {
			return "403";
		}
    	String id = jwtUtil.getId(refreshToken);
    	String permission = jwtUtil.getPermission(refreshToken);
    	String name = this.getAdminNameService(id);
    	
    	model.addAttribute("userId",id);
    	model.addAttribute("userName", name);
    	model.addAttribute("permission",permission);
    	
    	return id;
	}
	
	@ResponseBody
	public String authenticateUser(String authorizationHeader) throws Exception {

	    if(authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
	    	throw new Exception("토큰이 존재하지 않음");
	    }
	    
	    String token = authorizationHeader.substring(7); // "Bearer " 이후의 토큰만 추출
	    if(token == null || jwtUtil.isTokenExpired(token)) {
	        throw new Exception("토큰이 만료됨");
	    }

	    String userId = jwtUtil.getId(token); // ID 추출
	    String permission = jwtUtil.getPermission(token);
	    if(userId == null || permission.equals("N")) {
	        throw new Exception("인증되지 않은 유저");
	    }

	    return userId;
	}
}
