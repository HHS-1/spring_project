package dto;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopSettingDto {
	private Map<String, String> siteSettingData;
	private Map<String, String> companySettingData;
	private Map<String, String> paymentSettingData;
	
}
