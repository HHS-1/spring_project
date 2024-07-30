package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import service.AdminListService;

@Controller
public class HomeController {

	@Autowired
	private AdminListService adminListService;
	
    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "index";
    }
    
    @GetMapping("/admin/list")
    public String adminListPage(Model model) {
    	model.addAttribute("adminInfo",adminListService.getAdminService());
    	return "admin_list";
    }
    
    @GetMapping("/admin/add")
    public String adminAddPage() {
        return "add_master";
    }
    
}