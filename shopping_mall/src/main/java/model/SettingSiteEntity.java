package model;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettingSiteEntity {
	int  idx_site, reward, auth_level;
	String admin_id, site_name, admin_email, point_usable,in_date;
	
	public SettingSiteEntity() {};
	
	public void setEntity(Map<String, String> dtoData, String id, SettingSiteEntity site) {
		dtoData.forEach((key, value)->{
			switch(key) {
			case "site_name" :
				site.setSite_name(value);
				break;
			case "admin_email" :
				site.setAdmin_email(value);
				break;
			case "point_usable" :
				site.setPoint_usable(value);
				break;
			case "reward" :
				site.setReward(Integer.valueOf(value));
				break;
			case "auth_level" :
				site.setAuth_level(Integer.valueOf(value));
				break;
			}
		});
		site.setAdmin_id(id);
	}
}
