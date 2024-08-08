package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jwt.JwtUtil;
import service.CommonService;
import service.HomeService;

@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;
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
    	model.addAttribute("adminInfo",homeService.getAdminService());
    	return commonService.verifyMaster(req,model,path);
    }
    
    @GetMapping("/admin/add")
    public String adminAddPage() {
        return "add_master";
    }
    
    @GetMapping("/admin/setting/shop")
	 public String getShopSetting(Model model, HttpServletRequest req) throws Exception{
	    
	    String id = commonService.verify(req, model);
	    if(id.startsWith("redirect:") || id.equals("403")) return id;
		else {
			model.addAttribute("settingData", homeService.getShopSettingService(id));			
		}
	    return "admin_siteinfo";
	 }
    
    @GetMapping("/admin/product")
    public String productPage(Model model, HttpServletRequest req) {
    	String id = commonService.verify(req, model);
	    if(id.startsWith("redirect:") || id.equals("403")) return id;
	    
	    return "product_list";
    }
    
    @GetMapping("/admin/product/add")
    public String productAddPage(Model model, HttpServletRequest req) {
    	String id = commonService.verify(req, model);
	    if(id.startsWith("redirect:") || id.equals("403")) return id;
	    
	    model.addAttribute("categoryMenu",homeService.getCategoryMenuService());
	    return "product_write";
    }
    
    @GetMapping("/admin/category")
    public String categoryPage(Model model, HttpServletRequest req) {
    	String id = commonService.verify(req, model);
	    if(id.startsWith("redirect:") || id.equals("403")) return id;
	    return "cate_list";
    }
    
    @GetMapping("/admin/category/add")
    public String categoryAddPage(Model model, HttpServletRequest req) {
    	String id = commonService.verify(req, model);
	    if(id.startsWith("redirect:") || id.equals("403")) return id;
	    return "cate_write";
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