package model;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettingCompanyEntity {
    int idx_company;
    String admin_id, company_name, business_number, ceo_name, ceo_tel, report_number,
           carrier_number, company_post, company_address, info_manager, info_manager_email, in_date;

    public SettingCompanyEntity() {}

    public void setEntity(Map<String, String> dtoData, String id) {
        dtoData.forEach((key, value) -> {
            switch (key) {
                case "company_name":
                    this.setCompany_name(value);
                    break;
                case "business_number":
                    this.setBusiness_number(value);
                    break;
                case "ceo_name":
                    this.setCeo_name(value);
                    break;
                case "ceo_tel":
                    this.setCeo_tel(value);
                    break;
                case "report_number":
                    this.setReport_number(value);
                    break;
                case "carrier_number":
                    this.setCarrier_number(value);
                    break;
                case "company_post":
                    this.setCompany_post(value);
                    break;
                case "company_address":
                    this.setCompany_address(value);
                    break;
                case "info_manager":
                    this.setInfo_manager(value);
                    break;
                case "info_manager_email":
                    this.setInfo_manager_email(value);
                    break;
            }
        });
        
        this.setAdmin_id(id);
    }
}
