package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Admin;
import mybatis.AdminMapper;

@Service
public class AdminListService {
	@Autowired
	private AdminMapper adminMapper;
	
	public List<Admin> getAdminService() {
		return adminMapper.getAdminMapper();
	}
	
	public String getAdminNameService(String id) {
		return adminMapper.getAdminNameMapper(id);
	}
}
