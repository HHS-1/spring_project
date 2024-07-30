package mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import dto.AdminLoginDto;
import model.Admin;

@Mapper
public interface AdminMapper {
	int adminIdCheckMapper(String id);
	int createAdminMapper(Admin admin);
	List<Admin> getAdminMapper();
	Map<String,String> adminLoginMapper(String id);
}
