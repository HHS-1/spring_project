package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jwt.JwtUtil;
import service.AdminListService;
import utility.CookieUtil;

@Controller
public class HomeController {

	@Autowired
	private AdminListService adminListService;
	@Autowired
	private JwtUtil jwtUtil;
	
    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "index";
    }
    
    @GetMapping("/admin/list")
    public String adminListPage(Model model, HttpServletRequest req) {
    	String refreshToken = CookieUtil.getCookie(req, "refreshToken");
    	
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
    
}