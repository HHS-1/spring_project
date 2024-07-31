package jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import model.AdminAuthentication;
import mybatis.AdminMapper;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	AdminMapper adminMapper;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		
		AdminAuthentication adminInfo = adminMapper.getAdminDetail(id);
		
		// admin정보가 없을 때 (세션만료 전 아이디를 삭제한경우?)
        if (adminInfo == null) {
            throw new UsernameNotFoundException("관리자 정보 없음");
        }
		
		return new CustomUserDetails(adminInfo.getAdmin_id(), adminInfo.getAdmin_pw(), adminInfo.getPermission());
	}
}
