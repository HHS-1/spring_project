package controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jwt.JwtFilter;
import jwt.JwtUtil;
import service.AdminListService;
import utility.CookieUtil;

@Controller
public class HomeController {

	@Autowired
	private AdminListService adminListService;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private JwtFilter jwtFilter;
    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "index";
    }
    
    @GetMapping("/admin/list")
    public String adminListPage(Model model, HttpServletRequest req) throws ServletException, IOException {
    	    	
    	String refreshToken = CookieUtil.getCookie(req, "refreshToken");
    	if(refreshToken == null || refreshToken.isEmpty() ||jwtUtil.isTokenExpired(refreshToken)) {
			return "redirect:/admin/login";
		}else if(!jwtUtil.getPermission(refreshToken).equals("M")) {
			return "403";
		}
    
    	String id = jwtUtil.getId(refreshToken);
    	String permission = jwtUtil.getPermission(refreshToken);
    	String name = adminListService.getAdminNameService(id);
    	
    	model.addAttribute("userId",id);
    	model.addAttribute("userName", name);
    	model.addAttribute("permission",permission);
    	model.addAttribute("adminInfo",adminListService.getAdminService());
    	return "admin_list";
    }
    
    @GetMapping("/admin/add")
    public String adminAddPage() {
        return "add_master";
    }
    
    @GetMapping("/admin/test")
    @ResponseBody
    public String test() {
    	System.out.println("test success");
    	return "test success";
    }
    @GetMapping("/")
    public String main() {
    	System.out.println("메인페이지");
    	return null;
    }
    
}