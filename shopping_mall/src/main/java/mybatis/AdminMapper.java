package mybatis;

import org.apache.ibatis.annotations.Mapper;
import model.Admin;

@Mapper
public interface AdminMapper {
	int adminIdCheckMapper(String id);
	int createAdminMapper(Admin admin);
}
