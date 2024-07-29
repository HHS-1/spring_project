package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminSignupDto {
	String admin_id, admin_pw, admin_name, admin_email, admin_tel, admin_part, admin_position;
}
