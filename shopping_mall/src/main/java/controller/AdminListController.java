package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dto.AdminPermissionDto;
import service.AdminListService;

@Controller
public class AdminListController {
	
	@Autowired
	private AdminListService adminListService;
	
	@PostMapping("/admin/permission")
	public ResponseEntity<String> modifyPermission(@RequestBody AdminPermissionDto adminPermissionDto){
		return adminListService.modifyPermissionService(adminPermissionDto);
		
	}
	
}
