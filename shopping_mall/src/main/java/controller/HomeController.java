package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "index";
    }
    
    @GetMapping("/admin/list")
    public String adminListPage() {
        return "admin_list";
    }
    
    @GetMapping("/admin/add")
    public String adminAddPage() {
        return "add_master";
    }
    
}