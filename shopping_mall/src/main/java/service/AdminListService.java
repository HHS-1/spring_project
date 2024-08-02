package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dto.AdminPermissionDto;
import model.Admin;
import mybatis.AdminMapper;

@Service
public class AdminListService {
	@Autowired
	private AdminMapper adminMapper;
	
	public List<Admin> getAdminService() {
		return adminMapper.getAdminMapper();
	}

	
	public ResponseEntity<String> modifyPermissionService(AdminPermissionDto adminPermissionDto){
		if(adminMapper.modifyPermissionMapper(adminPermissionDto)>0) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.status(434).build();
		}
	}
}
