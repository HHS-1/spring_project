package service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
	
	public String verify(HttpServletRequest req, Model model, String path) {
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
}
