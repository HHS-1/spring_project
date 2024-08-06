package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminEntity {
	
	int idx_admin;
	String admin_id,admin_pw,admin_name,admin_email,admin_tel,admin_part,admin_position,permission,join_date;
	
	public AdminEntity() {}
	
	
	
}
