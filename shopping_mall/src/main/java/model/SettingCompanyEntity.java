package model;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class SettingCompanyEntity {
	int idx_company;
	String admin_id, company_name, business_number, ceo_name, ceo_tel, report_number, carrier_number, 
	company_post, company_address, info_manager, info_manager_email, in_date; 
	
	public SettingCompanyEntity() {}
	
	public void setEntity(Map<String, String> dtoData, String id, SettingCompanyEntity company) {
	    dtoData.forEach((key, value) -> {
	        switch (key) {
	            case "company_name":
	                company.setCompany_name(value);
	                break;
	            case "business_number":
	                company.setBusiness_number(value);
	                break;
	            case "ceo_name":
	                company.setCeo_name(value); 
	                break;
	            case "ceo_tel":
	                company.setCeo_tel(value);
	                break;
	            case "report_number":
	                company.setReport_number(value); 
	                break;
	            case "carrier_number":
	                company.setCarrier_number(value); 
	                break;
	            case "company_post":
	                company.setCompany_post(value); 
	                break;
	            case "company_address":
	                company.setCompany_address(value); 
	                break;
	            case "info_manager":
	                company.setInfo_manager(value);
	                break;
	            case "info_manager_email":
	                company.setInfo_manager_email(value);
	                break;
	        }
	    });
	    
	    company.setAdmin_id(id);
	}

}
