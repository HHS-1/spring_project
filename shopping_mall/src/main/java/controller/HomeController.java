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
import service.CommonService;
import utility.CookieUtil;

@Controller
public class HomeController {

	@Autowired
	private AdminListService adminListService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private JwtUtil jwtUtil;

    @GetMapping("/admin/login")
    public String adminLoginPage(HttpServletResponse response) {
    	response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        return "index";
    }
    
    @GetMapping("/admin/list")
    public String adminListPage(Model model, HttpServletRequest req) throws ServletException, IOException {
    	String path = "admin_list";
    	model.addAttribute("adminInfo",adminListService.getAdminService());
    	return commonService.verify(req,model,path);
    }
    
    @GetMapping("/admin/add")
    public String adminAddPage() {
        return "add_master";
    }
    
    @GetMapping("/admin/setting/shop")
    public String shopSettingPage(Model model, HttpServletRequest req) {
    	String path = "admin_siteinfo";
    	model.addAttribute("adminInfo",adminListService.getAdminService());
    	return commonService.verify(req,model,path);
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